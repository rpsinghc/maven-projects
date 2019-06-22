package com.mvc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().disable()
		.headers().
			xssProtection().disable()
			.frameOptions().disable()
.and()
	.authorizeRequests()
	.antMatchers("/*").authenticated()
    // .authorizeRequests()
      //  .anyRequest().hasAnyRole("ADMIN", "USER")
//    .and()
//    	.formLogin()
    //.and()
     //   .logout().permitAll().logoutSuccessUrl("/login")
   // .and()
        //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		;
	}
	
	
	 @Bean
	  public UserDetailsService userDetailsService() {
	    return new UserDetailsServiceImp();
	  };
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  };
	
   // @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("test")
//                    .password("{noop}pass")
//                    .roles("USER")
//            .and()
//                .withUser("manager")
//                    .password("{noop}password")
//                    .credentialsExpired(true)
//                    .accountExpired(true)
//                    .accountLocked(true)
//                    .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
//                    .roles("MANAGER");
    	
    	auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    
    

}