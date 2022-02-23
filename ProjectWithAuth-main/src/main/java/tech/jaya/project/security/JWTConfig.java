
package tech.jaya.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import tech.jaya.project.service.UserDetailServiceImpl;

@EnableWebSecurity
public class JWTConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailServiceImpl userService;

	private final PasswordEncoder passwordEncoder;

	public JWTConfig(UserDetailServiceImpl userService, PasswordEncoder passwordEncoder) {

		this.userService = userService;
		this.passwordEncoder = passwordEncoder;

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/swagger-ui/**");
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().addFilter(new JWTAuthFilter(authenticationManager()))
				.addFilter(new JWTValidFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests()
				.antMatchers("/login","/api/user", "/h2-console", "/swagger-ui/**", "/swagger-ui", "/swagger-ui.html", "/swagger-resources/**", "/configuration/security","/v2/api-docs" )
				.permitAll().anyRequest()
				.authenticated();
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}
