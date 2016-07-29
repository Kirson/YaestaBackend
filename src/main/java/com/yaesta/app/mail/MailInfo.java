package com.yaesta.app.mail;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
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
	private String htmlBody;
	private File file;
	private List<String> attachmentList;
	private ItemInfo itemInfo;
	private List<ItemInfo> itemInfoList;
	private String generalText;
	private Long refId;
	private String refVtexId;
	private List<String> textList;
	
	public MailInfo(){
		attachmentList = new ArrayList<String>();
		itemInfoList = new ArrayList<ItemInfo>();
		textList = new ArrayList<String>();
	}
	
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
	public String getHtmlBody() {
		return htmlBody;
	}
	public void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public List<String> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<String> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}

	public List<ItemInfo> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(List<ItemInfo> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

	public String getGeneralText() {
		return generalText;
	}

	public void setGeneralText(String generalText) {
		this.generalText = generalText;
	}

	public Long getRefId() {
		return refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

	public String getRefVtexId() {
		return refVtexId;
	}

	public void setRefVtexId(String refVtexId) {
		this.refVtexId = refVtexId;
	}

	public List<String> getTextList() {
		return textList;
	}

	public void setTextList(List<String> textList) {
		this.textList = textList;
	}
	
	
	
}
