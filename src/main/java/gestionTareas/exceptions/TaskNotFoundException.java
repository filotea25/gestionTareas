package gestionTareas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TaskNotFoundException extends ResponseStatusException {
    public TaskNotFoundException(String mensaje) {

        super(HttpStatus.NOT_FOUND,mensaje);
    }
}
