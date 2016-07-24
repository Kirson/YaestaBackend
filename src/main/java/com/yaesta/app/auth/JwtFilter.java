package com.yaesta.app.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.yaesta.app.util.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		/*
		final HttpServletRequest request = (HttpServletRequest) req;
		
		final String authHeader = request.getHeader("Autorizacion");
		
		System.out.println("A-00000 ");
		
		if (authHeader==null || !authHeader.startsWith("Portador ")){
			throw new ServletException("No autorizado"); 
		}
		
		System.out.println("B-00000 ");
			final String token = authHeader.substring(9);
			System.out.println("Token " + token);
			try {
				System.out.println("C-00000 ");
				final Claims claims = Jwts.parser().setSigningKey(Constantes.superSecreto).parseClaimsJws(token).getBody();
				request.setAttribute("claims", claims);
				System.out.println("claims" + claims);
			} catch (Exception e) {
				System.out.println("D-00000 ");
				//throw  new ServletException("Token invalido " + e.getMessage());
			}
			*/
		HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		chain.doFilter(req, res);
		
	}
}
