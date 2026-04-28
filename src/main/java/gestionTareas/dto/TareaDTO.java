package gestionTareas.dto;

import gestionTareas.enums.Estado;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TareaDTO {

    @NotNull
    private String titulo;


    private String descripcion;


    private Estado estado;




    private Long UsuarioId;
}
