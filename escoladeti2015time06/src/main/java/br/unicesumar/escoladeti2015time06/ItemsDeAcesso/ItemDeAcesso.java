package br.unicesumar.escoladeti2015time06.ItemsDeAcesso;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemdeacesso")
public class ItemDeAcesso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String nome;
    
    @OneToOne
    private ItemDeAcesso superior;

    public ItemDeAcesso() {
        
    }

    public ItemDeAcesso(String descricao, ItemDeAcesso superior) {
        this.nome = descricao;
        this.superior = superior;
    }

    public ItemDeAcesso(String descricao) {
        
        this.nome = descricao;
        this.superior = this;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ItemDeAcesso getSuperior() {
        return superior;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSuperior(ItemDeAcesso superior) {
        this.superior = superior;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ItemDeAcesso other = (ItemDeAcesso) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemDeAcesso{" + "id=" + id + ", descricao=" + nome + ", superior=" + superior + '}';
    }
    
    
    
}
