package br.unicesumar.escoladeti2015time06.manterPerfilUsuario;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PerfilDeUsuarioRepository extends JpaRepository<PerfilDeUsuario, Serializable> {
    
}
