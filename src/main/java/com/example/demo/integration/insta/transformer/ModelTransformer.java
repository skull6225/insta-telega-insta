package com.example.demo.integration.insta.transformer;

import org.springframework.stereotype.Component;

import com.example.demo.integration.insta.model.Model;

@Component
public class ModelTransformer {

	public Model transform(Model model) {
		return transform(model, model.getMessage());
	}

	public Model transform(Model model, String message) {
		return Model.builder().pk(model.getPk()).message(message).build();
	}

}
