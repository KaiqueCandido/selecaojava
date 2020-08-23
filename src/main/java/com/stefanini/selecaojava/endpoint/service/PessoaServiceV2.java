package com.stefanini.selecaojava.endpoint.service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.selecaojava.exception.PessoaException;
import com.stefanini.selecaojava.model.entity.Pessoa;
import com.stefanini.selecaojava.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaServiceV2 {
	private final PessoaRepository pessoaRepository;

	public Iterable<Pessoa> list() {
		log.info("Listing all people");
		return pessoaRepository.findAll();
	}

	public Pessoa get(String id) throws PessoaException {
		log.info("Geting one people");
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (optional.isEmpty()) {
			throw new PessoaException("Nenhum valor presente");
		}
		return optional.get();
	}

	public Pessoa save(Pessoa pessoa) throws PessoaException {
		log.info("Saving people");
		if (!pessoaRepository.findByCpf(pessoa.getCpf()).isEmpty()) {
			throw new PessoaException("CPF já cadastrado");
		}
		if (Objects.isNull(pessoa.getEndereco())) {
			throw new PessoaException("Endereço é campo obrigatorio");
		}
		pessoa.setDt_cadastro(new Date());
		return pessoaRepository.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa) throws PessoaException {
		log.info("Updating people");
		pessoa.setDt_atualizacao(new Date());
		if (Objects.isNull(pessoa.getEndereco())) {
			throw new PessoaException("Endereço é campo obrigatorio");
		}
		return pessoaRepository.save(pessoa);
	}

	public Pessoa delete(String id) throws PessoaException {
		log.info("Deleting people");
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (optional.isEmpty()) {
			throw new PessoaException("Nenhum valor presente");
		}
		pessoaRepository.deleteById(optional.get().getId());
		return optional.get();
	}
}
