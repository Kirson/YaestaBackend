package com.yaesta.app.util.ws;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import sun.misc.BASE64Encoder;


@SuppressWarnings("restriction")
public class WebServiceMessageSenderWithAuth extends HttpUrlConnectionMessageSender {

	

	private String vitexUser;
	private String vitexPassword;
	
	public WebServiceMessageSenderWithAuth(String vitexUser,String vitexPassword){
		this.vitexUser=vitexUser;
		this.vitexPassword=vitexPassword;
	}
	
	
	
	public String getVitexUser() {
		return vitexUser;
	}



	public void setVitexUser(String vitexUser) {
		this.vitexUser = vitexUser;
	}



	public String getVitexPassword() {
		return vitexPassword;
	}



	public void setVitexPassword(String vitexPassword) {
		this.vitexPassword = vitexPassword;
	}



	@Override
	protected void prepareConnection(HttpURLConnection connection)
			throws IOException {
		
		BASE64Encoder enc = new sun.misc.BASE64Encoder();
		String userpassword = vitexUser+":"+vitexPassword;
		System.out.println("UP:"+userpassword);
		String encodedAuthorization = enc.encode( userpassword.getBytes() );
		connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);

		super.prepareConnection(connection);
	}
}
