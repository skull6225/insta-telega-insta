package com.example.demo.integration.insta.service;

import org.jvnet.hk2.annotations.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.demo.integration.insta.model.Model;
import com.example.demo.integration.insta.transformer.ModelTransformer;
import com.example.demo.integration.insta.uri.InstaUriBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class InstaService {

	private final RestTemplate restTemplate;
	private final ModelTransformer transformer;
	private final InstaUriBuilder uriBuilder;

	public void sendResponseForMessage(String message, Model model) {
		log.debug("Method sendResponseForMessage of InstaService, message: {}, model: {}", message, model);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Model> request = new HttpEntity<>(transformer.transform(model, message), headers);
		restTemplate.exchange(uriBuilder.fetchSendResponseForMessageUri(), HttpMethod.POST, request, Model.class);
	}

}
