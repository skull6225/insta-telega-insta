package com.example.demo.handler;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.example.demo.integration.insta.model.Model;
import com.example.demo.integration.insta.service.InstaService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ResponseHandler {

	private final InstaService instaService;

	private Model model;

	public void replyToMessage(Update update) {
		if (Optional.ofNullable(update.getMessage().getText()).isPresent()) {
			resend(update);
		}
	}

	public void resend(Update update) {
		instaService.sendResponseForMessage(update.getMessage().getText(), model);
	}
	
	public void setModel(Model model) {
		this.model = model;
	}

}
