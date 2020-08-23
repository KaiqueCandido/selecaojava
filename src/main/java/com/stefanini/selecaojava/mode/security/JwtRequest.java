package com.stefanini.selecaojava.mode.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -4341861725721484922L;
	
	private String username;
	private String password;

}
