package com.envios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.envios.service.MyAppUserDetailsService;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/entregarPaquete").hasAnyRole("ADMIN","USER")
		.and().formLogin()  //login configuration
                .loginPage("/customLogin.jsp")	//en la carpeta publica
                .loginProcessingUrl("/appLogin")
                .usernameParameter("app_username")	//en el jsp
                .passwordParameter("app_password")	//en el jsp
                .defaultSuccessUrl("/entregarPaquete")	
		.and().logout()    //logout configuration
		.logoutUrl("/appLogout") 
		.logoutSuccessUrl("/customLogin.jsp")
		.and().exceptionHandling() //exception handling configuration
		.accessDeniedPage("/error");
	} 
	
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
}   
