package com.javaexp.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorApi {

	private Integer statusCode;
	private String title;
	private String status;
	private String details;
	private LocalDateTime locatDateTime;
}
