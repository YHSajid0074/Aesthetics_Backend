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
                "        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
                "        .email-container { background-color: #ffffff; max-width: 600px; margin: 20px auto; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
                "        .header { background-color: #007bff; color: #ffffff; padding: 10px 20px; border-radius: 8px 8px 0 0; text-align: center; }" +
                "        .content { padding: 20px; color: #333333; line-height: 1.6; }" +
                "        .footer { font-size: 12px; text-align: center; color: #777777; margin-top: 20px; }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div class='email-container'>" +
                "        <div class='header'>" +
                "            <h1>Email to a noob</h1>" +
                "        </div>" +
                "        <div class='content'>" +
                "            <p>Dear " + recipientName + ",</p>" +
                "            <p>" + messageContent + "</p>" +
                "            <p>Best regards,</p>" +
                "            <p><strong>Sajid</strong></p>" +
                "        </div>" +
                "        <div class='footer'>" +
                "            <p>" + footerText + "</p>" +
                "        </div>" +
                "    </div>" +
                "</body>" +
                "</html>";
    }

}
