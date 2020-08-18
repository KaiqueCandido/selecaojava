package com.stefanini.selecaojava.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.stefanini.selecaojava.mode.entity.Pessoa;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

}
