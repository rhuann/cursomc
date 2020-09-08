package com.rhuan.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.rhuan.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
