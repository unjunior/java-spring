package br.com.desafio.dscliente.service.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String msg) {
        super(msg);
    }
}
