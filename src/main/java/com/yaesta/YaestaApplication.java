package com.yaesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yaesta.app.auth.JwtFilter;
import com.yaesta.app.controller.AppErrorController;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.yaesta")
@Configuration
public class YaestaApplication extends VitexSoapClient {

	
	@Autowired
	private ErrorAttributes errorAttributes;

	@Bean
	public AppErrorController appErrorController(){
		return new AppErrorController(errorAttributes);
	}
	
	
	@Bean
	public FilterRegistrationBean jwstFilter() {
		
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");		
		return registrationBean;		
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(YaestaApplication.class, args);
	}
}
