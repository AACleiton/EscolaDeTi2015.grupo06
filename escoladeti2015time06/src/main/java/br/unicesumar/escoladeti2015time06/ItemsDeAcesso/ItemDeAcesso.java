package br.unicesumar.escoladeti2015time06.ItemsDeAcesso;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemDeAcesso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String descricao;
    
    @OneToOne
    private ItemDeAcesso superior;

    public ItemDeAcesso() {
    }

    public ItemDeAcesso(Long id, String descricao, ItemDeAcesso superior) {
        this.id = id;
        this.descricao = descricao;
        this.superior = superior;
    }

    public ItemDeAcesso(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public ItemDeAcesso getSuperior() {
        return superior;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        return "ItemDeAcesso{" + "id=" + id + ", descricao=" + descricao + ", superior=" + superior + '}';
    }
    
    
    
}
