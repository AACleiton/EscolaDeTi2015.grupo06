package br.unicesumar.escoladeti2015time06.Usuario;

import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcesso;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario implements AcessosUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true)
    private Status status;


    private Set<ItemDeAcesso> itens = new HashSet<>();

    //private Set<PerfilDeAcesso> perfis = new HashSet<>();


    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, String email, Status status, Set<ItemDeAcesso> itens) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.status = status;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }

    public Set<ItemDeAcesso> getItens() {
        return itens;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setItens(Set<ItemDeAcesso> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!id.equals(usuario.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", itens=" + itens +
                '}';
    }

    @Override
    public void add(AcessosUsuario novoAcesso) {

    }

    @Override
    public void remove(AcessosUsuario novoAcesso) {

    }
}
