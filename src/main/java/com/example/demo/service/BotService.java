package com.example.demo.service;

import java.net.URI;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.config.properties.BotProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BotService {

	private final RestTemplate restTemplate;
	private final BotProperties properties;

	public void sendMessage(String text) {
		log.debug("Method sendMessage of BotService, text: {}", text);
		
		Integer chatId = Integer.valueOf(properties.getChatId()); 
		restTemplate.exchange(sendMessageToChat(chatId, text), HttpMethod.POST, null, String.class);
	}

	private URI sendMessageToChat(Integer chatId, String text) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		Optional.ofNullable(chatId).ifPresent(c -> params.add("chat_id", c.toString()));
		Optional.ofNullable(text).ifPresent(t -> params.add("text", t.toString()));

		return UriComponentsBuilder.fromUriString(properties.getApi().getUri())
				.path(String.format("bot%s%s", properties.getToken(), properties.getPath().getByDefault()))
				.queryParams(params).build().encode().toUri();
	}
}