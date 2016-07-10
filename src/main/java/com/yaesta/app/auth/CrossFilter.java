package com.yaesta.app.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CrossFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
				
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "Autorizacion, Content-Type");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    
	    if(!request.getMethod().equals("OPTIONS")){
	    	System.out.println("11111");
	    	chain.doFilter(req, res);
	    }else{
	    	System.out.println("22222");
	    }
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
