package com.witcher.kicker.email.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailSetting {

    @Value("${mail.recipient}")
    private String recipient;

    @Value("${mail.recipient.startup}")
    private String recipientStartUp;

    @Value("${mail.enable}")
    private boolean enable;

    @Value("${mail.enable.startup}")
    private boolean enableSendOnStartUp;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getRecipientStartUp() {
        return recipientStartUp;
    }

    public void setRecipientStartUp(String recipientStartUp) {
        this.recipientStartUp = recipientStartUp;
    }

    public boolean isEnableSendOnStartUp() {
        return enableSendOnStartUp;
    }

    public void setEnableSendOnStartUp(boolean enableSendOnStartUp) {
        this.enableSendOnStartUp = enableSendOnStartUp;
    }
}
