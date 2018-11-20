package com.witcher.kicker.email.service;

import com.witcher.kicker.email.setting.MailSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private MailSetting mailSetting;

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(String subject, String textMessage) {
        sendEmail(mailSetting.getRecipient(), subject, textMessage);
    }

    @Override
    public void sendEmailStartApp() {
        if (mailSetting.isEnableSendOnStartUp()) {
            sendEmail(mailSetting.getRecipientStartUp(), "Kicker", "Application getting started!");
        }
    }

    private void sendEmail(String recipient, String subject, String textMessage) {
        try {
            if (mailSetting.isEnable()){
                MimeMessage message = sender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message);

                helper.setTo(recipient);
                helper.setText(textMessage);
                helper.setSubject(subject);

                LOGGER.debug("Send mail to " + recipient);

                sender.send(message);
            }
        } catch (MessagingException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
