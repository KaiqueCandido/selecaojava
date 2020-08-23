package com.stefanini.selecaojava.endpoint.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stefanini.selecaojava.endpoint.service.builder.UserDetailBuilder;

public class JwtUserDetailsServiceTest {
	
	
	@InjectMocks
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = UsernameNotFoundException.class)
	public void loadUserByUsernameTest() {
		String username = "selecaoJava";
		when(jwtUserDetailsService.loadUserByUsername(username)).thenReturn(UserDetailBuilder.mockUserDetailBuilder().mockUserDetails());
		jwtUserDetailsService.loadUserByUsername(username);
	}

}
