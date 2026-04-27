package psu.edu.FinalProject.security;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public UserDetailsManager userDetailsManger(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		jdbcUserDetailsManager.setUsersByUsernameQuery(
			"SELECT username, password_hash, is_active FROM users WHERE username = ?");

		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
			"SELECT u.username, r.role_name FROM users u " +
			"JOIN roles r ON u.username = r.employee_user WHERE u.username = ?");

		return jdbcUserDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new DelegatingPasswordEncoder("bcrypt", Map.of("bcrypt", new BCryptPasswordEncoder()));
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http.authorizeHttpRequests(configurer ->
    	configurer
    				.requestMatchers("/").permitAll()
    				.requestMatchers("/emplrec/save").hasAnyRole("MANAGER","ADMIN")
    				.requestMatchers("/emplrec/delete").hasRole("ADMIN") 
    				.requestMatchers("/emplrec/list").hasAnyRole("MANAGER","EMPLOYEE","ADMIN")
    				.anyRequest().authenticated()
    			)
    			.formLogin(form ->
    					form
    						.loginPage("/showMyLoginPage")
    						.loginProcessingUrl("/authenticateTheUser")
    						.defaultSuccessUrl("/emplrec/list", true)
    						.failureUrl("/showMyLoginPage?error=true")
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
