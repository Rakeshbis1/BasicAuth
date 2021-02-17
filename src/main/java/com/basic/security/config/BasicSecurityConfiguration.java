package com.basic.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.basic.security.service.UserService;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	Environment env;
	
	@Autowired
	UserService userDetailsService;
	
	@Bean
	public ExUsernamePasswordAuthenticationFilter authenticationFilter() {
		return new ExUsernamePasswordAuthenticationFilter();
	}
	
	public BasicSecurityConfiguration() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
			.antMatcher("/**")
			
			.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			
			.authorizeRequests()
			.antMatchers("/login")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.httpBasic()
			.authenticationEntryPoint(getAuthEntryPoint());
		
		//http.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
			
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//String user = env.getProperty("spring.security.user.name");
		//String password = env.getProperty("spring.security.user.password");
		
		//UsernamePasswordAuthenticationToken userPass = new UsernamePasswordAuthenticationToken(user, password);
		//System.out.println("Get Credentials: ----------------> "+userPass.getCredentials());
		
		//auth.inMemoryAuthentication()
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
			//.withUser(user)
			//.password(passwordEncoder().encode("password")).roles("ADMIN");
			//.password(password)
			//.roles("USER");
		
		//UsernamePasswordAuthenticationToken userPass2 = new UsernamePasswordAuthenticationToken(user, password);
		//System.out.println("Get Credentials 2: ----------------> "+userPass.getCredentials());
		
		//DaoAuthenticationProvider dap;
	}
	
	@Bean
	public BasicAuthEntryPoint getAuthEntryPoint() {
		return new BasicAuthEntryPoint();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	   // return new BCryptPasswordEncoder(); 
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
