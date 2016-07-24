package com.yaesta;


import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import com.yaesta.app.util.ws.WebServiceMessageSenderWithAuth;

@Configuration
public class VitexSoapClient extends BaseConfig{

	private @Value("${vitex.user}") String vitexUser;
	private @Value("${vitex.password}") String vitexPassword;
	private @Value("${vitex.default.uri}") String vitexDefaultUri;
	private @Value("${vitex.context.path}") String vitexContextPath;
	

    @Bean
    public Jaxb2Marshaller getMarshaller() throws Exception{
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(vitexContextPath);
        marshaller.afterPropertiesSet();
        return marshaller;
     }
    
    @Bean
    public SaajSoapMessageFactory messageFactory() throws SOAPException {
    	SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(
                MessageFactory.newInstance());
        messageFactory.afterPropertiesSet();
        return messageFactory;
    }

    
    
    
    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
        webServiceTemplate.setDefaultUri(vitexDefaultUri);
        webServiceTemplate.setMarshaller(getMarshaller());
        webServiceTemplate.setUnmarshaller(getMarshaller());
        webServiceTemplate.setMessageSender(new WebServiceMessageSenderWithAuth(vitexUser,vitexPassword));
        webServiceTemplate.afterPropertiesSet();
        return webServiceTemplate;
    }

}
