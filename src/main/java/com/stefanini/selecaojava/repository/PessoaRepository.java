package com.stefanini.selecaojava.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stefanini.selecaojava.mode.entity.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}
