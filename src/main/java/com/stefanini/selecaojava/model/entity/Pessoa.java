package com.stefanini.selecaojava.model.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.stefanini.selecaojava.model.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "pessoa")
public class Pessoa implements AbstractEntity {

	private static final long serialVersionUID = 4444746577144500775L;

	@Id
	@EqualsAndHashCode.Include
	private String id;

	private String nome;
	private Sexo sexo;
	private String email;
	private Date dt_nascimento;
	private String naturalidade;
	private String nacionalidade;
	private String cpf;
	private String endereco;
	private Date dt_cadastro;
	private Date dt_atualizacao;

}
