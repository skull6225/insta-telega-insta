package com.example.demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import lombok.RequiredArgsConstructor;

@Component
@Service
@RequiredArgsConstructor
public class ResponseHandler {

	public void replyToMessage(Update update) throws URISyntaxException {
		if (!update.getMessage().getText().toString().equals(null)) {
			try {
				resend(update);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	public String sendsec(Model model) throws IOException {
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

		String apiToken = "814985849:AAEF5SvcbokHxL-RmeoQ0LFfM9qmBSEvDec";
		String chatId = "224014177";
		String text = model.getMessage();

		urlString = String.format(urlString, apiToken, chatId, text);

		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();

		StringBuilder sb = new StringBuilder();
		InputStream is = new BufferedInputStream(conn.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String inputLine = "";
		while ((inputLine = br.readLine()) != null) {
			sb.append(inputLine);
		}
		String response = sb.toString();
		return saveModel(model.getPk());
	}

	String myModel;

	public String saveModel(String model) {
		myModel = model;
		return model;

	}

	public void resend(Update update) throws TelegramApiException, URISyntaxException {
		URI url = new URI("http://localhost:8199/instagram/messageApi");

		String requestJson = " {\"message\":\"" + update.getMessage().getText() + "\"" + ",\"pk\":\"" + myModel + "\"}";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		restTemplate.postForLocation(url, entity);

	}

}
