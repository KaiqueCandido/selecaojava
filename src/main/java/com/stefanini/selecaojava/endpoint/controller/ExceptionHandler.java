package com.stefanini.selecaojava.endpoint.controller;

import com.stefanini.selecaojava.valueobject.ResponseObjectError;

public class ExceptionHandler {

	ResponseObjectError notFound(Exception e) {
		return new ResponseObjectError(404, e.getMessage());
	}

}
