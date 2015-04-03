package br.unicesumar.escoladeti2015time06.manterPerfilUsuario;

import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcesso;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perfilusuario")

//Falta a implementação do atributo "UsuarioID"
public class PerfilDeUsuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nome;
 // private Permissao permissao;  
   //
    private PerfilDeAcesso PerfilDeAcesso;
    
    @ManyToMany(targetEntity = ItemDeAcesso.class,cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_acesso",
            joinColumns = {
                @JoinColumn(name = "perfildeusuario_id", referencedColumnName = "id")},
                inverseJoinColumns = {
                @JoinColumn(name = "perfildeacesso_id", referencedColumnName = "id")})
    public Set<PerfilDeAcesso> perfilAcesso = new HashSet<>();
    
    
    public PerfilDeUsuario() {
    }

    public PerfilDeUsuario(String nome, PerfilDeAcesso PerfilDeAcesso){
        this.nome = nome;
        this.PerfilDeAcesso = PerfilDeAcesso;
    }
    

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PerfilUsuario{" + "id=" + id + ", nome=" + nome + '}';
    }   
}