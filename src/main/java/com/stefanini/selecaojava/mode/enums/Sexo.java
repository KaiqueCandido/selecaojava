package com.stefanini.selecaojava.mode.enums;

public enum Sexo {
	MASCULINO("Masculino"), FEMININO("Feminino");

	private String descricao;

	Sexo(String descicao) {
		this.descricao = descicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
