/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti2015time06.manterPerfilUsuario;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vinicius
 */
public interface PerfilDeAcessoRepository extends JpaRepository<PerfilDeAcesso, Long> {
    
}