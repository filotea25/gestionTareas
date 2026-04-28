package gestionTareas.service;

import gestionTareas.dto.TareaDTO;
import gestionTareas.enums.Estado;
import gestionTareas.exceptions.TaskAlreadyAssignedException;
import gestionTareas.exceptions.UserNotFoundException;
import gestionTareas.model.Tarea;
import gestionTareas.model.Usuario;
import gestionTareas.repository.TareaRepository;
import gestionTareas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Tarea crearTarea(TareaDTO dto ){
        //1. busco el usuario
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new UserNotFoundException("El usuario no existe"));

        //2. creo la tarea
        Tarea tarea = new Tarea();
        if(tarea.getEstado().equals(Estado.IN_PROGRESS)){
            throw new TaskAlreadyAssignedException("La tarea ya fue asignada");
        }

        //3. modifico la tarea
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        //solo se puede asignar tarea si está en todo
        tarea.setEstado(Estado.TODO);
        tarea.setUsuario(usuario);

        //4. guardo la tarea
        return tareaRepository.save(tarea);
    }

    //listar todas las tareas
    public List<Tarea> listarTareas(){
        return tareaRepository.findAll();
    }

    //encontrar tarea por usuario
    public List<Tarea> encontrarPorUsuario(Usuario usuario){
       return  tareaRepository.findByUsuario(usuario);
    }
}
