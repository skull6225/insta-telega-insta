package com.example.demo.integration.insta.uri;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.integration.insta.properties.EndpointProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class InstaUriBuilder {

	private final EndpointProperties properties;

	public URI fetchSendResponseForMessageUri() {
		log.debug("Method fetchSendResponseForMessageUri of InstaUriBuilder");
		return UriComponentsBuilder.fromUriString(properties.getApi().getUri())
				.path(properties.getMessageProperties().getPath().getByDefault()).build().encode().toUri();
	}
	
}
