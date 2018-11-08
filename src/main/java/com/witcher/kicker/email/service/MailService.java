package com.witcher.kicker.email.service;

import javax.mail.MessagingException;

public interface MailService {

    void sendEmail(String subject, String message) throws MessagingException;
}
