/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.EstadoHabitacionDTO;
import co.edu.konradlorenz.cadenahotelera.entities.EstadoHabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.logic.EstadoHabitacionLogic;
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
@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoHabitacionResource {

    @EJB
    private EstadoHabitacionLogic estadoHabitacionLogic;

    @GET
    public List<EstadoHabitacionDTO> getEstadoHabitacionList() {
        List<EstadoHabitacionEntity> estados = estadoHabitacionLogic.obtenerEstadosHabitaciones();
        EstadoHabitacionDTO habitacion = new EstadoHabitacionDTO();
        return habitacion.toEstudianteHabitacionList(estados);
    }

    @GET
    @Path("{id: \\d+}")
    public EstadoHabitacionDTO getEstadoHabitacion(@PathParam("id") Long id) {
        EstadoHabitacionEntity estadoHabitacion = estadoHabitacionLogic.obtenerEstadoHabitacion(id);
        if (estadoHabitacion == null) {
            throw new RuntimeException("El estado solicitado no existe.");
        }
        return new EstadoHabitacionDTO(estadoHabitacion);
    }

    @POST
    public EstadoHabitacionDTO createEstadoHabitacion(EstadoHabitacionDTO estadoHabitacionDTO) {
        return new EstadoHabitacionDTO(estadoHabitacionLogic.crearEstadoHabitacion(estadoHabitacionDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public EstadoHabitacionDTO updateEstadoHabitacion(@PathParam("id") Long id, EstadoHabitacionDTO estadoHabitacionDTO) {
        EstadoHabitacionEntity entity = estadoHabitacionLogic.obtenerEstadoHabitacion(id);
        if (entity == null) {
            throw new RuntimeException("El estado solicitado no existe.");
        }
        return new EstadoHabitacionDTO(estadoHabitacionLogic.actualizarEstadoHabitacion(id, estadoHabitacionDTO.toEntity()));
    }

    @DELETE
    @Path("{estadoHabitacionId: \\d+}")
    public void deleteEstadoHabitacion(@PathParam("estadoHabitacionId") Long id) {
        EstadoHabitacionEntity entity = estadoHabitacionLogic.obtenerEstadoHabitacion(id);
        if (entity == null) {
            throw new RuntimeException("El estado solicitado no existe.");
        }
        estadoHabitacionLogic.eliminarEstadoHabitacion(id);
    }
}
