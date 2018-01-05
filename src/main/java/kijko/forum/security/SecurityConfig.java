package kijko.forum.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/createforum").hasAnyRole("ADMIN")
		.antMatchers("/groups/**", "/forums/**/createthema", "/groups/**").hasAnyRole("USER")
		.antMatchers("/", "/register").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.usernameParameter("login")
        .passwordParameter("password")
        .and()
        .logout()
            .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
	    }
	 
	 

	 
}
