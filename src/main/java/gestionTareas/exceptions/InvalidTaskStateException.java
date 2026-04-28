package gestionTareas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidTaskStateException extends ResponseStatusException {
    public InvalidTaskStateException(String mensaje) {

        super(HttpStatus.BAD_REQUEST,mensaje);
    }
}
