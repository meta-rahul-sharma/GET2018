package com.metacube.training.SpringSecurity.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * used for spring security in memory form based
 * custom authentication
 * @author RAHUL SHARMA
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	/**
	 * To provide in memory different user's with different roles
	 */
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}adm")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}user")
				.roles("EMPLOYEE");
	}

	/**
	 * To authenticate admin and employee by roles
	 */
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')")
				.antMatchers("/employee/*")
				.access("hasRole('ROLE_EMPLOYEE')")
				.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/error")
				.loginProcessingUrl("/login")
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(
							HttpServletRequest request,
							HttpServletResponse response, Authentication auth)
							throws IOException, ServletException {
						if (auth.getAuthorities().toString()
								.contains("ROLE_EMPLOYEE")) {
							response.sendRedirect("employee/dashboard");
						} else {
							response.sendRedirect("admin/dashboard");
						}
					}
				}).and().logout().logoutUrl("/../logout")
				.logoutSuccessUrl("/../logout");
		http.csrf().disable();

	}
}
