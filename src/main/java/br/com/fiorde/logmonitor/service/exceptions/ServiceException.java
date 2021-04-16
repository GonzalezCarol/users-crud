package br.com.fiorde.logmonitor.service.exceptions;

import br.com.fiorde.logmonitor.repository.UserRepository;

public class ServiceException  extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
