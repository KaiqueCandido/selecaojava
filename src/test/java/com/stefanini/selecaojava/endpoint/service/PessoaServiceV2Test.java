package com.stefanini.selecaojava.endpoint.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.misusing.WrongTypeOfReturnValue;

import com.stefanini.selecaojava.endpoint.service.builder.PessoaServiceBuilder;
import com.stefanini.selecaojava.exception.PessoaException;
import com.stefanini.selecaojava.model.entity.Pessoa;
import com.stefanini.selecaojava.repository.PessoaRepository;

public class PessoaServiceV2Test {

	@InjectMocks
	private PessoaServiceV2 pessoaService;

	@Mock
	private PessoaRepository pessoaRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testList() {
		when(pessoaService.list()).thenReturn(PessoaServiceBuilder.mockPessoaServiceBuilder().mockLstPessoa());
		pessoaService.list();
	}

	@Test(expected = WrongTypeOfReturnValue.class)
	public void testGet() {
		try {
			Pessoa pessoa = PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa();
			Optional<Pessoa> opt = PessoaServiceBuilder.mockPessoaServiceBuilder().mockOptionalPessoa();
			when(pessoaRepository.findById(pessoa.getId())).thenReturn(opt);
			when(pessoaService.get(pessoa.getId()))
					.thenReturn(PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa());
			pessoaService.get(pessoa.getId());
		} catch (PessoaException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = PessoaException.class)
	public void testGetException() throws PessoaException {
		Pessoa pessoa = PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa();
		when(pessoaService.get(pessoa.getId()))
				.thenReturn(PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa());
		when(pessoaRepository.findById(pessoa.getId()))
				.thenReturn(PessoaServiceBuilder.mockPessoaServiceBuilder().mockOptionalPessoa());
		pessoaService.get(PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa().getId());
	}

	@Test
	public void testSave() {
		try {
			Pessoa pessoa = PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa();
			when(pessoaService.save(pessoa)).thenReturn(pessoa);
			pessoaService.save(pessoa);
		} catch (PessoaException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = PessoaException.class)
	public void testUpdate() throws PessoaException {
		Pessoa pessoa = PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa();
		when(pessoaService.update(pessoa)).thenReturn(pessoa);
		pessoaService.update(pessoa);
	}

	@Test
	public void testUpdateEndereco() throws PessoaException {
		Pessoa pessoa = PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoaWitchEndereco();
		when(pessoaService.update(pessoa)).thenReturn(pessoa);
		pessoaService.update(pessoa);
	}

	@Test(expected = PessoaException.class)
	public void testDelete() throws PessoaException {
		Pessoa pessoa = PessoaServiceBuilder.mockPessoaServiceBuilder().mockPessoa();
		when(pessoaService.delete(pessoa.getId())).thenReturn(pessoa);
		pessoaService.delete(pessoa.getId());
	}

}
