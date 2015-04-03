package br.unicesumar.escoladeti2015time06.manterPerfilUsuario;
    
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "perfildeacesso")
public class PerfilDeAcesso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public PerfilDeAcesso() {
    }
    
}
