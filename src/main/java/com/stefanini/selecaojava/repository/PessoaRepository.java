package com.stefanini.selecaojava.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.stefanini.selecaojava.model.entity.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {
	
	@Query("{'cpf': ?#{[0]} }")
	List<Pessoa> findByCpf(String param0);

}
