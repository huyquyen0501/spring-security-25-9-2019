package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("userDetailsService")
	org.springframework.security.core.userdetails.UserDetailsService userDetailsService;
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/register/**").permitAll()
		.antMatchers("/admin/**")
		.access("hasRole('ROLE_ADMIN')")
		.antMatchers("/teacher/**")
		.access("hasRole('ROLE_TEACHER')")
		.antMatchers("/student/**")
		.access("hasRole('ROLE_STUDENT')")
		.and()
		.formLogin()
		.loginPage("/login").failureUrl("/login?error")
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/403");
//		http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);
		return encoder;
	}
	
}
