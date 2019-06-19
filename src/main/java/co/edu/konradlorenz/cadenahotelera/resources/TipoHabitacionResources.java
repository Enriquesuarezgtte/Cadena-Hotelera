/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.TipoHabitacionDTO;
import co.edu.konradlorenz.cadenahotelera.entities.TipoHabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.logic.TipoHabitacionLogic;
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
@Path("/tipohabitacion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoHabitacionResources {

    @EJB
    private TipoHabitacionLogic thabitacionlogic;

    @GET
    public List<TipoHabitacionDTO> getthabiList() {
        List<TipoHabitacionEntity> thabi = thabitacionlogic.obtenerhabitacion();
        TipoHabitacionDTO thabit = new TipoHabitacionDTO();
        return thabit.toTipoHabitacionList(thabi);
    }

    @GET
    @Path("{id: \\d+}")
    public TipoHabitacionDTO getthabi(@PathParam("id") Long id) {
        TipoHabitacionEntity thabi = thabitacionlogic.obtenerthabitacion(id);
        if (thabi == null) {
            throw new RuntimeException("El tipo de habitacion SOlicitado no existe");
        }
        return new TipoHabitacionDTO(thabi);

    }

    @POST
    public TipoHabitacionDTO createthabi(TipoHabitacionDTO thabi) {
        return new TipoHabitacionDTO(thabitacionlogic.crearthabitacion(thabi.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public TipoHabitacionDTO updatethabi(@PathParam("id") Long id, TipoHabitacionDTO thabi) {
        TipoHabitacionEntity entity = thabitacionlogic.obtenerthabitacion(id);
        if (entity == null) {
            throw new RuntimeException("el tipo de habitacion solicitado no existe");
        }
        return new TipoHabitacionDTO(thabitacionlogic.actualizarthabi(thabi.toEntity(), id));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deletethabi(@PathParam("id") Long id) {
        TipoHabitacionEntity entity = thabitacionlogic.obtenerthabitacion(id);
        if (entity == null) {
            throw new RuntimeException("el tipo de habitacion solicitado no existe");
        }
        thabitacionlogic.eliminarthabi(id);
    }
}
