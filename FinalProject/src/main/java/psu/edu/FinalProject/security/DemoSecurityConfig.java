package psu.edu.FinalProject.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public UserDetailsManager userDetailsManger(DataSource dataSource)
	{
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		jdbcUserDetailsManager.setUsersByUsernameQuery("select username,password_hash,is_active from users where username =?");
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select employee_user, role_name from roles where employee_user =?");
		
		return jdbcUserDetailsManager;
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http.authorizeHttpRequests(configurer ->
    	configurer
    				.requestMatchers("/").hasAnyRole("MANAGER","EMPLOYEE","ADMIN")
    				.requestMatchers("/save").hasAnyRole("MANAGER","ADMIN")
    				.requestMatchers("/delete").hasRole("ADMIN") 
    				.anyRequest().authenticated()
    			)
    			.formLogin(form ->
    					form
    						.loginPage("/showMyLoginPage")
    						.loginProcessingUrl("/authenticateTheUser")
    						.permitAll()
    			)
    			.logout(logout -> logout.permitAll()    					
    			)
    			.exceptionHandling(configurer ->
    						configurer.accessDeniedPage("/access-denied")		
    					
    					);
    	
    	return http.build();
    }
}
