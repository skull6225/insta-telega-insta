package com.example.demo;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.example.demo.config.properties.BotProperties;
import com.example.demo.handler.ResponseHandler;

@Component
public class Bot extends AbilityBot {
	
	private final ResponseHandler responseHandler;
	private final BotProperties properties;
	
	@Lazy
	@Autowired
	public Bot(BotProperties properties, ResponseHandler responseHandler) {
		super(properties.getToken(), properties.getUsername());
		this.properties = properties;
		this.responseHandler = responseHandler;
	}

	public Reply replyToMessage() {
		Consumer<Update> action = upd -> responseHandler.replyToMessage(upd);
		return Reply.of(action, Flag.MESSAGE);
	}
	
	@Override
	public int creatorId() {
		return properties.getCreator().getId();
	}
	
}
