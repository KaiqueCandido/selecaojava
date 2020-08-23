package com.stefanini.selecaojava.endpoint.service.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.stefanini.selecaojava.model.entity.Pessoa;
import com.stefanini.selecaojava.model.enums.Sexo;

public class PessoaServiceBuilder {
	
	public static PessoaServiceBuilder mockPessoaServiceBuilder() {
		PessoaServiceBuilder builder = new PessoaServiceBuilder();
		return builder;
	}
	
	public Pessoa mockPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId("5f3edb50de186a0acf8f3ad0");
		pessoa.setNome("Kaique Oliveira");
		pessoa.setSexo(Sexo.MASCULINO);
		pessoa.setEmail("kcoliveira2@stefanini.com");
		pessoa.setDt_nascimento(new Date());
		pessoa.setNaturalidade("São Paulo");
		pessoa.setNacionalidade("Brasileira");
		pessoa.setCpf("99543522014");
		pessoa.setDt_cadastro(new Date());
		pessoa.setDt_atualizacao(new Date());
		return pessoa;
	}
	
	public Pessoa mockPessoaWitchEndereco() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId("5f3edb50de186a0acf8f3ad0");
		pessoa.setNome("Kaique Oliveira");
		pessoa.setSexo(Sexo.MASCULINO);
		pessoa.setEmail("kcoliveira2@stefanini.com");
		pessoa.setDt_nascimento(new Date());
		pessoa.setNaturalidade("São Paulo");
		pessoa.setNacionalidade("Brasileira");
		pessoa.setCpf("99543522014");
		pessoa.setEndereco("Endereco");
		pessoa.setDt_cadastro(new Date());
		pessoa.setDt_atualizacao(new Date());
		return pessoa;
	}
	
	public List<Pessoa> mockLstPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId("5f3edb50de186a0acf8f3ad0");
		pessoa.setNome("Kaique Oliveira");
		pessoa.setSexo(Sexo.MASCULINO);
		pessoa.setEmail("kcoliveira2@stefanini.com");
		pessoa.setDt_nascimento(new Date());
		pessoa.setNaturalidade("São Paulo");
		pessoa.setNacionalidade("Brasileira");
		pessoa.setCpf("99543522014");
		pessoa.setDt_cadastro(new Date());
		pessoa.setDt_atualizacao(new Date());
		List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
		lstPessoa.add(pessoa);
		return lstPessoa;
	}
	
	public Optional<Pessoa> mockOptionalPessoa() {
		Optional<Pessoa> opt = Optional.of(new Pessoa());
		return opt;
	}
}
