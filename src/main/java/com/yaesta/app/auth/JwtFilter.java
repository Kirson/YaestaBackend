package com.yaesta.app.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import com.yaesta.app.util.Constantes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
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
		chain.doFilter(req, res);
		
	}
}
