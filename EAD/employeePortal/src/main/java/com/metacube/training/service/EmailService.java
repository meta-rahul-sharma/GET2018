package com.metacube.training.service;

public interface EmailService {
	public void generateForgottenPassword(String to, String subject, String text);
}
