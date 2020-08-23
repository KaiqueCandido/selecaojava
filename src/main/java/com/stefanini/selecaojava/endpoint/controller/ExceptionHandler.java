package com.stefanini.selecaojava.endpoint.controller;

import com.stefanini.selecaojava.valueobject.ResponseObjectError;

public class ExceptionHandler {

	ResponseObjectError notFound(Exception e) {
		return new ResponseObjectError(404, e.getMessage());
	}

	ResponseObjectError conflict(Exception e) {
		return new ResponseObjectError(409, e.getMessage());
	}

	ResponseObjectError notAccepttable(Exception e) {
		return new ResponseObjectError(406, e.getMessage());
	}
}
