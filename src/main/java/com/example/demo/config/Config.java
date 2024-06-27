package com.example.demo.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class Config {

	@Value("${HttpMethods}")
	String[] httpMethods;

	@Value("${RequestHeaders}")
	String[] requestHeaders;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				.formLogin(config -> config
						.loginProcessingUrl("/loginProc")
						.defaultSuccessUrl("/", false)
						.usernameParameter("username")
						.passwordParameter("password")
						.successHandler((request, response, authentication) -> {
							System.out.print("authentication : " + authentication);
							response.sendRedirect("/home");
						}).failureHandler((request, response, exception) -> {
							System.out.print("exception : " + exception.getMessage());
							response.sendRedirect("/login");
						}).permitAll())
		
//				.cors(config -> config.configurationSource(corsConfigurationSource()))
				.csrf(config -> config.disable());

		return http.build();
	}

//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOriginPatterns(Arrays.asList("*"));
//		configuration.setAllowedMethods(Arrays.asList(httpMethods));
//		configuration.setAllowedHeaders(Arrays.asList(requestHeaders));
//		configuration.setAllowCredentials(true);
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return new defaultPass
//	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user = User.withUsername("user").password("{noop}1111").roles("USER").build();		
		
		return new InMemoryUserDetailsManager(user);
	}

}
