package br.unicesumar.escoladeti2015time06.perfilDeAcesso;

import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcesso;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perfildeacesso")
public class PerfilDeAcesso {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "perfildeacesso_itemdeacesso",
            joinColumns = {
                @JoinColumn(name = " perfildeacesso_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "itemdeacesso_id", referencedColumnName = "id")})
    private Set<ItemDeAcesso> itens = new HashSet<>();

    public PerfilDeAcesso() {
    }

    public PerfilDeAcesso(String nome, Set<ItemDeAcesso> itens) {
        this.nome = nome;
        this.itens = itens;
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

    public Set<ItemDeAcesso> getItens() {
        return itens;
    }

    public void setItens(Set<ItemDeAcesso> itens) {
        this.itens = itens;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PerfilDeAcesso other = (PerfilDeAcesso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PerfilDeAcesso{" + "id=" + id + ", nome=" + nome + ", itens=" + itens + '}';
    }

}
