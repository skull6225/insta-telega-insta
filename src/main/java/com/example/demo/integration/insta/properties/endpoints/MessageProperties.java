package com.example.demo.integration.insta.properties.endpoints;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Component
@ConfigurationProperties("message")
public class MessageProperties {

	private Path path;

	@Setter
	@Getter
	@NoArgsConstructor
	@ConfigurationProperties("path")
	public static class Path {
		private String byDefault;
	}

}
