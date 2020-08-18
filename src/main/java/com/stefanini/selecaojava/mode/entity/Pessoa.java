package com.stefanini.selecaojava.mode.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.stefanini.selecaojava.mode.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pessoa")
public class Pessoa implements AbstractEntity {

	private static final long serialVersionUID = 4444746577144500775L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "sexo", length = 9)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dt_nascimento;

	@Column(name = "naturalidade", length = 30)
	private String naturalidade;

	@Column(name = "nacionalidade", length = 30)
	private String nacionalidade;

	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	@Column(name = "dt_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dt_cadastro;

	@Column(name = "dt_atualizacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dt_atualizacao;

}
