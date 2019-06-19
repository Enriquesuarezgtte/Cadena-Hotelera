/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.UsuarioDTO;
import co.edu.konradlorenz.cadenahotelera.entities.UsuarioEntity;
import co.edu.konradlorenz.cadenahotelera.logic.UsuarioLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Grupo1
 *
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResources {

    @EJB
    private UsuarioLogic usuariologic;

    @GET
    public List<UsuarioDTO> getusuarioList() {
        List<UsuarioEntity> estudiantes = usuariologic.obtenerusuarios();
        UsuarioDTO usuario = new UsuarioDTO();
        return usuario.toUsuarioList(estudiantes);
    }

    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO getusuario(@PathParam("id") Long id) {
        UsuarioEntity usuario = usuariologic.obtenerusuario(id);
        if (usuario == null) {
            throw new RuntimeException("El usuario Solicitado no existe");
        }
        return new UsuarioDTO(usuario);

    }

    @POST
    public UsuarioDTO createusuario(UsuarioDTO usuario) {
        return new UsuarioDTO(usuariologic.crearusuario(usuario.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateusuario(@PathParam("id") Long id, UsuarioDTO usuario) {
        UsuarioEntity entity = usuariologic.obtenerusuario(id);
        if (entity == null) {
            throw new RuntimeException("El usuario solicitado no existe");
        }
        return new UsuarioDTO(usuariologic.ectualizarusuario(usuario.toEntity(), id));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteusuario(@PathParam("id") Long id) {
        UsuarioEntity entity = usuariologic.obtenerusuario(id);
        if (entity == null) {
            throw new RuntimeException("El usuario solicitado no existe");
        }
        usuariologic.eliminarusuario(id);
    }
}
