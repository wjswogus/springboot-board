package com.cos.board.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionController {

	@ExceptionHandler(value=IllegalArgumentException.class)
	public String 잘못된인수(Exception e) {
		return  e.getMessage();
	}
}
