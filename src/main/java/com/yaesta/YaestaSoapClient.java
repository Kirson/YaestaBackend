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
public class YaestaSoapClient extends BaseConfig{

	private @Value("${vitex.user}") String vitexUser;
	private @Value("${vitex.password}") String vitexPassword;
	private @Value("${vitex.default.uri}") String vitexDefaultUri;
	private @Value("${vitex.context.path}") String vitexContextPath;
	
	protected @Value("${laarcourier.service.url}") String laarCourierServiceUrl;
	protected @Value("${laarcourier.service.user}") String laarCourierServiceUser;
	protected @Value("${laarcourier.service.password}") String laarCourierServicePassword;
	protected @Value("${laarcourier.service.context.path}") String laarCourierServiceContextPath;
	
	protected @Value("${tcc.service.url}") String tccServiceUrl;
	protected @Value("${tcc.service.user}") String tccServiceUser;
	protected @Value("${tcc.service.password}") String tccServicePassword;
	protected @Value("${tcc.service.context.path}") String tccServiceContextPath;
	

    @Bean
    public Jaxb2Marshaller getMarshallerVtex() throws Exception{
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(vitexContextPath);
        marshaller.afterPropertiesSet();
        return marshaller;
     }
    
    @Bean
    public Jaxb2Marshaller getMarshallerLaarCourier() throws Exception{
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(laarCourierServiceContextPath);
        marshaller.afterPropertiesSet();
        return marshaller;
     }

    @Bean
    public Jaxb2Marshaller getMarshallerTCC() throws Exception{
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(tccServiceContextPath);
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
        webServiceTemplate.setMarshaller(getMarshallerVtex());
        webServiceTemplate.setUnmarshaller(getMarshallerVtex());
        webServiceTemplate.setMessageSender(new WebServiceMessageSenderWithAuth(vitexUser,vitexPassword));
        webServiceTemplate.afterPropertiesSet();
        return webServiceTemplate;
    }
    
    @Bean
    public WebServiceTemplate webServiceTemplateLaarCourier() throws Exception {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
        webServiceTemplate.setDefaultUri(laarCourierServiceUrl);
        webServiceTemplate.setMarshaller(getMarshallerLaarCourier());
        webServiceTemplate.setUnmarshaller(getMarshallerLaarCourier());
        webServiceTemplate.afterPropertiesSet();
        return webServiceTemplate;
    }
    
    @Bean
    public WebServiceTemplate webServiceTemplateTCC() throws Exception {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
        webServiceTemplate.setDefaultUri(tccServiceUrl);
        webServiceTemplate.setMarshaller(getMarshallerTCC());
        webServiceTemplate.setUnmarshaller(getMarshallerTCC());
        webServiceTemplate.afterPropertiesSet();
        return webServiceTemplate;
    }


}
