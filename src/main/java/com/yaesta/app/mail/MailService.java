package com.yaesta.app.mail;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;


@Service
public class MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	VelocityEngine velocityEngine;
	
	public void sendMailTemplate(MailInfo mailInfo, String template){
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(javax.mail.internet.MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(mailInfo.getMailReceiver().getEmail());
                message.setFrom(mailInfo.getMailSender().getEmail()); 
                message.setSubject(mailInfo.getSubject());
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("mailInfo", mailInfo);
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, "UTF-8", model);
                message.setText(text, true);
            }
        };
        this.javaMailSender.send(preparator);
		
	}
	
	public void sendMail(MailInfo mailInfo){
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(javax.mail.internet.MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(mailInfo.getMailReceiver().getEmail());
                message.setFrom(mailInfo.getMailSender().getEmail()); 
                 String text = mailInfo.getBody();
                message.setText(text, true);
                message.setSubject(mailInfo.getSubject());
            }
        };
        this.javaMailSender.send(preparator);
		
	}
	
}
