/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.HabitacionDTO;
import co.edu.konradlorenz.cadenahotelera.entities.HabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.logic.HabitacionLogic;
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
 * @author Bryan
 */
@Path("/habitaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabitacionResource {

    @EJB
    private HabitacionLogic habitacionLogic;

    @GET
    public List<HabitacionDTO> getHabitacionList() {
        List<HabitacionEntity> habitaciones = habitacionLogic.obtenerHabitaciones();
        HabitacionDTO habitacion = new HabitacionDTO();
        return habitacion.toHabitacionList(habitaciones);
    }

    @GET
    @Path("{id: \\d+}")
    public HabitacionDTO getHabitacion(@PathParam("id") Long id) {
        HabitacionEntity habitacion = habitacionLogic.obtenerHabitacion(id);
        if (habitacion == null) {
            throw new RuntimeException("La habitacion solicitada no existe.");
        }
        return new HabitacionDTO(habitacion);
    }

    @POST
    public HabitacionDTO createHabitacion(HabitacionDTO habitacionDTO) {
        return new HabitacionDTO(habitacionLogic.crearHabitacion(habitacionDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public HabitacionDTO updateHabitacion(@PathParam("id") Long id, HabitacionDTO habitacionDTO) {
        HabitacionEntity entity = habitacionLogic.obtenerHabitacion(id);
        if (entity == null) {
            throw new RuntimeException("La habitacion deseada no existe.");
        }
        return new HabitacionDTO(habitacionLogic.actualizarHabitacion(id, habitacionDTO.toEntity()));
    }

    @DELETE
    @Path("{habitacionId: \\d+}")
    public void deleteHabitacion(@PathParam("habitacionId") Long id) {
        HabitacionEntity entity = habitacionLogic.obtenerHabitacion(id);
        if (entity == null) {
            throw new RuntimeException("La habitacion solicitada no existe.");
        }
        habitacionLogic.eliminarHabitacion(id);
    }

}
