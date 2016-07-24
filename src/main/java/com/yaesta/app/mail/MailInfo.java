package com.yaesta.app.mail;

import java.io.Serializable;
import java.util.List;

public class MailInfo implements Serializable {

	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 7094710821566935074L;
	private MailParticipant mailSender;
	private MailParticipant mailReceiver;
	private List<MailParticipant> receivers;
	private String subject;
	private String body;
	
	public MailParticipant getMailSender() {
		return mailSender;
	}
	public void setMailSender(MailParticipant mailSender) {
		this.mailSender = mailSender;
	}
	public MailParticipant getMailReceiver() {
		return mailReceiver;
	}
	public void setMailReceiver(MailParticipant mailReceiver) {
		this.mailReceiver = mailReceiver;
	}
	public List<MailParticipant> getReceivers() {
		return receivers;
	}
	public void setReceivers(List<MailParticipant> receivers) {
		this.receivers = receivers;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
