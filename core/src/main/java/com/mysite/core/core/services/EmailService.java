package com.mysite.core.core.services;

public interface EmailService {

    void sendEmail(
            String toEmail,
            String ccEmail,
            String fromEmail,
            String subject,
            String content
    );
}
