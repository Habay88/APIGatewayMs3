package com.habay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.habay.model.Role;
import com.habay.security.jwt.JwtAuthorizationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder());
	}
     @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy
		(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
		.antMatchers("/api/authentication/**")
		.permitAll() //login and register pre-path
		.antMatchers(HttpMethod.GET, "/gateway/course").permitAll()
		.antMatchers("/gateway/course/**").hasRole(Role.ADMIN.name())
		.anyRequest().authenticated();
		
		http.addFilterBefore(jwtAuthorizationFilter(), 
				UsernamePasswordAuthenticationFilter.class);
	}
	
	// why dont we describe it as a component , because of scope
	@Bean
	public JwtAuthorizationFilter jwtAuthorizationFilter() {
		return new JwtAuthorizationFilter();
	}
	
	@Override
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	public WebMvcConfigurer corsConfigurer() 
	{
		return new WebMvcConfigurer() 
	{
		@Override
		public void addCorsMappings(CorsRegistry registry)
		{
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("*");
		}
		
	};
  
}}
