package com.stefanini.selecaojava.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.selecaojava.endpoint.service.PessoaServiceV2;
import com.stefanini.selecaojava.exception.PessoaException;
import com.stefanini.selecaojava.model.entity.Pessoa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/v2/pessoa")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaControllerV2 extends ExceptionHandler {

	private final PessoaServiceV2 pessoaService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Pessoa>> list() {
		return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> get(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<>(pessoaService.get(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(this.notFound(e), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody Pessoa pessoa) {
		try {
			return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(this.conflict(e), HttpStatus.CONFLICT);
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Pessoa pessoa) {
		try {
			return new ResponseEntity<>(pessoaService.update(pessoa), HttpStatus.OK);
		} catch (PessoaException e) {
			log.info("Saving people");
			return new ResponseEntity<>(this.notAccepttable(e), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<>(pessoaService.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(this.notFound(e), HttpStatus.NOT_FOUND);
		}
	}
}
