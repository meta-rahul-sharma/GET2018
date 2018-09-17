package com.metacube.training.dao;

public interface EmailDAO {
	public void generateForgottenPassword(String to, String subject, String text);
}
