package com.metacube.training.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private CustomAuthentication authProvider;
	
	/**
	 * To provide in memory different user's with different roles
	 */
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(authProvider);
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
				.logoutSuccessUrl("/../logout")
				.and()
				.exceptionHandling().accessDeniedPage("/403")
				.and()
				.csrf();
		http.csrf().disable();

	}
}
