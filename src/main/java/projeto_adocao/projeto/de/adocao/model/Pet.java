package projeto_adocao.projeto.de.adocao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;
    private String tipo;
    private String raca;
    private String porte;
    private String descricao;
    private String imagemUrl;
    private String localizacao;
    private Boolean disponivel;

    @ManyToOne
    private Usuario criadoPor;
}
