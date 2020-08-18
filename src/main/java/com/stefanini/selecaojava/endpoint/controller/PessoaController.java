package com.stefanini.selecaojava.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.selecaojava.endpoint.service.PessoaService;
import com.stefanini.selecaojava.mode.entity.Pessoa;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/pessoa")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController extends ExceptionHandler {

	private final PessoaService pessoaService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Pessoa>> list(Pageable pageable) {
		return new ResponseEntity<>(pessoaService.list(pageable), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> get(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(pessoaService.get(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(this.notFound(e), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.OK);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.update(pessoa), HttpStatus.OK);
	}
}
