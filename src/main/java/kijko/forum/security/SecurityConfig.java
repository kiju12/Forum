package kijko.forum.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;

import kijko.forum.services.impl.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AccessDeniedHandler accessDenied;
	
	@Bean
	public UserDetailsService customUserDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/createforum", "/adminpanel/**").hasAnyRole("ADMIN")
		.antMatchers("/groups/**", "/forums/**/createthema").hasAnyRole("USER")
		.antMatchers("/", "/register", "/forums/**" ).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.usernameParameter("login")
        .passwordParameter("password")
        .failureUrl("/login-error")
        .and()
        .logout()
            .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
		.and()
        .exceptionHandling().accessDeniedHandler(accessDenied);
	    }
	 
	 

	 
}
