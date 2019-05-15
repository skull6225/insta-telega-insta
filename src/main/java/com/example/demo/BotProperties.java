package com.example.demo;

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
	
	private Creator creator;
	private Session session;

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
	@ConfigurationProperties("session")
	public static class Session {
		private Integer minutes;
	}
	
}
