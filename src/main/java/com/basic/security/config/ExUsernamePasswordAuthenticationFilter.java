package com.basic.security.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.basic.security.service.UserService;
import com.basic.security.service.UsersDetailsRetrieval;

public class ExUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
	 @Autowired
     UserService userService;
	
	 @Override
	 @Autowired
	 public void setAuthenticationManager(AuthenticationManager authenticationManager) {
	     super.setAuthenticationManager(authenticationManager);
	 }
	 
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        
        System.out.println("username:-------> "+username+"password:----------> "+password);       

        UserDetails userDetails = userService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		SecurityContextHolder.getContext().setAuthentication(authentication);
        
        System.out.println("======> username:-------> "+username+"password:----------> "+password);
        
        return super.attemptAuthentication(request, response); 
    } 
}
