package com.example.demo.integration.insta.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.demo.integration.insta.properties.endpoints.MessageProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Component
@RequiredArgsConstructor
@ConfigurationProperties("endpoint")
public class EndpointProperties {

	private final ApiProperties api;
	private final MessageProperties messageProperties;
	
}