/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.ServicioDadoDTO;
import co.edu.konradlorenz.cadenahotelera.entities.ServicioDadoEntity;
import co.edu.konradlorenz.cadenahotelera.logic.ServicioDadoLogic;
import java.util.List;
import javax.ejb.EJB;
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
 * @author EnriqueS
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/serviciodado")

public class ServicioDadoResources {

    @EJB
    private ServicioDadoLogic servicioDadoLogic;

    /**
     * METODO HTTP-GET para obtener la lista de todos los servicios dados
     *
     * @return
     */
    @GET
    public List<ServicioDadoDTO> gerServicioDado() {
        List<ServicioDadoEntity> servicios = servicioDadoLogic.obtenerServicios();
        return ServicioDadoDTO.toServicioDadoList(servicios);
    }

    @GET
    @Path("{id: \\d+}")
    public ServicioDadoDTO obtenerServiciosDados(@PathParam("id") Long id) {
        ServicioDadoEntity servicios = servicioDadoLogic.obtenerServicioDado(id);
        if (servicios == null) {
            throw new RuntimeException("El servicio dado solicitado no existe");
        }
        return new ServicioDadoDTO(servicios);

    }

    /**
     * Metodo HTTP-POST para crear un objeto ServicioDado
     *
     * @param servicioDadoDTO
     * @return
     */
    @POST
    public ServicioDadoDTO createServicioDado(ServicioDadoDTO servicioDadoDTO) {
        return new ServicioDadoDTO(servicioDadoLogic.crearServicioDado(servicioDadoDTO.toEntity()));
    }

    /**
     * Metodo HTTP PUT para actualizar objeto ServicioDado
     *
     * @param id
     * @param servicioDadoDTO
     * @return
     */
    @PUT
    @Path("{id: \\d+}")
    public ServicioDadoDTO updateServicioDado(@PathParam("id") Long id, ServicioDadoDTO servicioDadoDTO) {
        ServicioDadoEntity servicios = servicioDadoLogic.obtenerServicioDado(id);
        if (servicios == null) {
            throw new RuntimeException("El servicio dado solicitado no existe");
        }
        return new ServicioDadoDTO(servicioDadoLogic.actualizarServicioDado(id, servicioDadoDTO.toEntity()));
    }

    /**
     * Metodo HTTP-DELETE para eliminar ServicioDado
     *
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteServicioDado(@PathParam("id") Long id) {
        servicioDadoLogic.eliminarServicioDado(id);
    }
}
