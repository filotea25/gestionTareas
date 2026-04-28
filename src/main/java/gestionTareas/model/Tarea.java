package gestionTareas.model;


import gestionTareas.enums.Estado;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String titulo;

    @Column(nullable = false)
    @NotNull
    private String descripcion;

    @Column(nullable = false)
    @NotNull
    private Estado estado;



    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}
