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
		
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,password_hash,is_active from users where user_id =?");
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select role_name, role_id from roles where role_name =?");
		
		return jdbcUserDetailsManager;
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http.authorizeHttpRequests(configurer ->
    	configurer
    				.requestMatchers("/").hasRole("3")/**EMPLOYEE*/
    				.requestMatchers("/leaders/**").hasRole("2")/**MANAGER*/
    				.requestMatchers("/systems/**").hasRole("1")/**ADMIN*/ 			
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
