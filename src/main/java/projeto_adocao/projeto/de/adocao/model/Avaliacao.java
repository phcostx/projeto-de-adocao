package projeto_adocao.projeto.de.adocao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacoes")
@Getter
@Setter
public class Avaliacao {

    @Id
    @GeneratedValue
    private Long id;

    private Integer nota;

    private String comentario;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Usuario avaliado;

    private LocalDate dataAvaliacao;
}
