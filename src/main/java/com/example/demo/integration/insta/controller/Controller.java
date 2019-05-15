package com.example.demo.integration.insta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.handler.ResponseHandler;
import com.example.demo.integration.insta.model.Model;
import com.example.demo.service.BotService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class Controller {

	private final ResponseHandler handler;
	private final BotService service;

	@PostMapping
	public ResponseEntity<?> subscribe(@RequestBody Model model) {
		log.debug("Model {} write!", model);
		
		service.sendMessage(model.getMessage());
		handler.setModel(model);
		
		return ResponseEntity.ok().build();
	}

}
