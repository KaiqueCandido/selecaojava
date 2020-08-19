package com.stefanini.selecaojava.endpoint.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.selecaojava.exception.PessoaException;
import com.stefanini.selecaojava.mode.entity.Pessoa;
import com.stefanini.selecaojava.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
	private final PessoaRepository pessoaRepository;

	public Iterable<Pessoa> list() {
		log.info("Listing all people");
		return pessoaRepository.findAll();
	}

	public Pessoa get(String id) throws PessoaException {
		log.info("Geting one people");
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (optional.isEmpty()) {
			throw new PessoaException("No value present");
		}
		return optional.get();
	}

	public Pessoa save(Pessoa pessoa) {
		log.info("Saving people");
		return pessoaRepository.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		log.info("Updating people");
		return pessoaRepository.save(pessoa);
	}

	public Pessoa deleteById(Pessoa pessoa) {
		log.info("Deleting people");
		pessoaRepository.deleteById(pessoa.getId());
		return pessoa;
	}

	public Long count() {
		log.info("Counting people");
		return pessoaRepository.count();
	}

}
