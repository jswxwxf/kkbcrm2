/**
 * 
 */
package com.lichengbao.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * @author jwang
 *
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {
	
	private AuthService authService;
	
	/**
	 * 
	 */
	public StatelessAuthenticationFilter(AuthService authService) {
		this.authService = authService;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		try  {
	        Authentication authentication = authService.getAuthentication(httpRequest);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (ExpiredJwtException e) {
			SecurityContextHolder.clearContext();
		}
        chain.doFilter(request, response);
		
	}

}
