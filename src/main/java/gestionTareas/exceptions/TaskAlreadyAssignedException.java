package gestionTareas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TaskAlreadyAssignedException extends ResponseStatusException {
    public TaskAlreadyAssignedException(String mensaje) {

        super(HttpStatus.BAD_REQUEST,mensaje);
    }
}
