package com.stefanini.selecaojava.endpoint.service.builder;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailBuilder {

	public static UserDetailBuilder mockUserDetailBuilder() {
		UserDetailBuilder builder = new UserDetailBuilder();
		return builder;
	}

	public UserDetails mockUserDetails() {
		return new User("selecaojava", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
				new ArrayList<>());
	}

}
