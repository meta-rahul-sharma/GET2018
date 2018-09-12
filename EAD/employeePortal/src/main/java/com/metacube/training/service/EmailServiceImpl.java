package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmailDAO;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	EmailDAO emailDao;
	
	public void generateForgottenPassword(String to, String subject, String text) {
		emailDao.generateForgottenPassword(to, subject, text);
	}
}
