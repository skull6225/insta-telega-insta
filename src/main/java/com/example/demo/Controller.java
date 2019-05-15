package com.example.demo;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@RestController
public class Controller {
	private final ResponseHandler service;
	@PostMapping("/message")
	public ResponseEntity<?> subscribe(@RequestBody Model model) throws IOException, TelegramApiException {
		service.sendsec(model);
		log.debug("Model {} write!",model);
		return ResponseEntity.ok().build();
	}

}
