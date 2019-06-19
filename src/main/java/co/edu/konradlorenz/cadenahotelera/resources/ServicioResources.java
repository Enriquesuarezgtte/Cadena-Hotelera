/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.ServicioDTO;
import co.edu.konradlorenz.cadenahotelera.entities.ServicioEntity;
import co.edu.konradlorenz.cadenahotelera.logic.ServicioLogic;
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
 * @author jeison
 */
@Path("/servicios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioResources {

    @EJB
    private ServicioLogic serviciologic;

    @GET
    public List<ServicioDTO> getservicioList() {
        List<ServicioEntity> servicios = serviciologic.obtenerservicio();
        ServicioDTO servicio = new ServicioDTO();
        return servicio.toServicioList(servicios);
    }

    @GET
    @Path("{id: \\d+}")
    public ServicioDTO getservicio(@PathParam("id") Long id) {
        ServicioEntity servicio = serviciologic.obtenerservicio(id);
        if (servicio == null) {
            throw new RuntimeException("El servicio Solicitado no existe");
        }
        return new ServicioDTO(servicio);

    }

    @POST
    public ServicioDTO createservicio(ServicioDTO servicio) {
        return new ServicioDTO(serviciologic.crearservicio(servicio.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public ServicioDTO updateservicio(@PathParam("id") Long id, ServicioDTO servicio) {
        ServicioEntity entity = serviciologic.obtenerservicio(id);
        if (entity == null) {
            throw new RuntimeException("el servicio solicitado no existe");
        }
        return new ServicioDTO(serviciologic.ectualizarservicio(servicio.toEntity(), id));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteservicio(@PathParam("id") Long id) {
        ServicioEntity entity = serviciologic.obtenerservicio(id);
        if (entity == null) {
            throw new RuntimeException("el servicio solicitado no existe");
        }
        serviciologic.eliminarservicio(id);
    }
}
