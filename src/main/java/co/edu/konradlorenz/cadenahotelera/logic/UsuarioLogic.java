/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.UsuarioEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jeison
 */
@Stateless
public class UsuarioLogic {

    @Inject
    private UsuarioPersistence usuariopersistence;

    public List<UsuarioEntity> obtenerusuarios() {
        List<UsuarioEntity> usuario = usuariopersistence.findAll();
        return usuario;
    }

    public UsuarioEntity obtenerusuario(long id) {
        UsuarioEntity usuario = usuariopersistence.find(id);
        if (usuario == null) {
            throw new IllegalArgumentException("usuario solicitado no existe.");
        }
        return usuario;
    }

    public UsuarioEntity crearusuario(UsuarioEntity usuEntity) {
        usuariopersistence.create(usuEntity);
        return usuEntity;
    }

    public UsuarioEntity ectualizarusuario(UsuarioEntity estEntity, long id) {
        UsuarioEntity usuario = usuariopersistence.update(estEntity);
        return usuario;
    }

    public void eliminarusuario(long id) {
        usuariopersistence.delete(id);
    }
}
