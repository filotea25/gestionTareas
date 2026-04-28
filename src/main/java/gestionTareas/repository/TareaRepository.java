package gestionTareas.repository;

import gestionTareas.model.Tarea;
import gestionTareas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByUsuario (Usuario usuario);
}
