package com.oauth.OAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class OAuthConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilter(HttpSecurity httpRequest) throws Exception{
		httpRequest.authorizeHttpRequests().anyRequest().authenticated().and().oauth2Login();
		return httpRequest.build();
	}
	

	@Bean
	public ClientRegistrationRepository clientRepo() {
		ClientRegistration clientRegistration = clientRegistration();
		return new InMemoryClientRegistrationRepository(clientRegistration);
	}
	
	private ClientRegistration clientRegistration() {
		return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("c924c04329bf60be3451").clientSecret("dcfb46825b0d2d4512d83eae593080a61981ff58").build();
	}
}
