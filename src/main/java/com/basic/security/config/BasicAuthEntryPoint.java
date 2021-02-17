package com.basic.security.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class BasicAuthEntryPoint implements AuthenticationEntryPoint, Serializable {

	 private static final long serialVersionUID = -5858869558953243875L;

	    UsernamePasswordAuthenticationFilter upaf = new UsernamePasswordAuthenticationFilter();
	    //SecurityContextHolder
	    //SecurityContextImpl
	   // BasicAuthEntryPoint baep = new BasicAuthEntryPoint();
	    @Override
	    public void commence(HttpServletRequest request, HttpServletResponse response,

	                         AuthenticationException authException) throws IOException {
	    	System.out.println("Password:-----> "+SecurityContextHolder.getContext().getAuthentication().getCredentials());
	    	System.out.println("Just testing...."+ request.getAuthType());
	    	System.out.println("Just testing....usernsme: "+ request.getParameter("username"));
	    	System.out.println("Just testing....password: "+ request.getParameter("password"));
	    	System.out.println("Entered UserName: "+obtainUsername(request));
	    	System.out.println("Entered PassWord: "+obtainPassword(request));
	    	System.out.println("Wrong user or password: "+authException.getCause());
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	        
	        
	        System.out.println("Exception by Rakesh: "+ authException.getLocalizedMessage());

	    }
	    
	    //@Override
	    protected String obtainPassword(HttpServletRequest request) {
			return request.getParameter(upaf.getPasswordParameter());
		}
	    
	    //@Override
	    protected String obtainUsername(HttpServletRequest request) {
			return request.getParameter(upaf.getUsernameParameter());
		}


}
