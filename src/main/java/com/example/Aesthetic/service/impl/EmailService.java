package com.example.Aesthetic.service.impl;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void send(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("yeamimhossainsajid@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);

    }

    public void sendProfessionalEmail(String to, String recipientName, String messageContent, String footerText) {
        try {
            String htmlContent = createEmailTemplate(recipientName, messageContent, footerText);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(to);
            helper.setFrom("yeamimhossainsajid@gmail.com");
            helper.setSubject("Mail from agiles.com");
            helper.setText(htmlContent, true); // true indicates HTML content

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public String createEmailTemplate(String recipientName, String messageContent, String footerText) {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "    <style>" +
                "        body { font-family: Arial, sans-serif; background-color: #121212; color: #ffffff; margin: 0; padding: 0; }" +
                "        .email-container { background-color: #1e1e2e; max-width: 600px; margin: 20px auto; padding: 20px; border-radius: 8px; box-shadow: 0 0 15px rgba(255, 255, 255, 0.1); }" +
                "        .logo { text-align: center; margin-bottom: 20px; }" +
                "        .header { font-size: 24px; text-align: center; margin-bottom: 20px; color: #d4d4ff; }" +
                "        .content { padding: 20px; line-height: 1.8; color: #e0e0e0; }" +
                "        .footer { font-size: 14px; text-align: center; color: #a0a0a0; margin-top: 20px; }" +
                "        img { max-width: 100px; border-radius: 50%; }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div class='email-container'>" +
                "        <div class='logo'>" +
                "            <img src='https://yourwebsite.com/path-to-purple-circle-logo.png' alt='Logo'>" +
                "        </div>" +
                "        <div class='header'>" +
                "            Your Trustworthy Technology Partner" +
                "        </div>" +
                "        <div class='content'>" +
                "            <p>Dear " + recipientName + ",</p>" +
                "            <p>" + messageContent + "</p>" +
                "            <p>Best regards,</p>" +
                "            <p><strong>Agiles Team</strong></p>" +
                "        </div>" +
                "        <div class='footer'>" +
                "            <p>" + footerText + "</p>" +
                "        </div>" +
                "    </div>" +
                "</body>" +
                "</html>";
    }


}
