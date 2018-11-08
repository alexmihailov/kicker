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

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private MailSetting mailSetting;

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(String subject, String textMessage) throws MessagingException {
        if (mailSetting.isEnable()){
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(mailSetting.getRecipient());
            helper.setText(textMessage);
            helper.setSubject(subject);

            logger.debug("Send mail to " + mailSetting.getRecipient());

            sender.send(message);
        }
    }
}
