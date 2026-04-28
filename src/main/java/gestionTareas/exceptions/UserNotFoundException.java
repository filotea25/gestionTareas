package gestionTareas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    public UserNotFoundException(String mensaje) {

        super(HttpStatus.NOT_FOUND,mensaje);
    }
}
