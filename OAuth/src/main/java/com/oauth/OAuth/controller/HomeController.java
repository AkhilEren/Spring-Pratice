package com.oauth.OAuth.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping("/hello")
	public String token(OAuth2AuthenticationToken token) {
		System.out.println(token.getPrincipal());
		System.out.println(token.getDetails());
		System.out.println(token.getName());
		
		return "Oauth is succesfully done";
	}
}
