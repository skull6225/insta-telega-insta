package com.example.demo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Component
@ConfigurationProperties("bot")
public class BotProperties {
    
	private String token;
	private String username;
	private String chatId;
	
	private Creator creator;
	
	private Api api;
	private Path path;

	
	@Setter
	@Getter
	@NoArgsConstructor
	@ConfigurationProperties("creator")
	public static class Creator {
		private Integer id;
	}
	
	@Setter
	@Getter
	@NoArgsConstructor
	@ConfigurationProperties("api")
	public static class Api {
		private String uri;
	}
	
	@Setter
	@Getter
	@NoArgsConstructor
	@ConfigurationProperties("path")
	public static class Path {
		private String byDefault;
	}
	
}
