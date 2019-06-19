/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.ReservaDTO;
import co.edu.konradlorenz.cadenahotelera.entities.ReservaEntity;
import co.edu.konradlorenz.cadenahotelera.logic.ReservaLogic;
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
@Path("/reserva")
public class ReservaResource {

    @EJB
    private ReservaLogic reservaLogic;

    /*
    Metodo HHTTP GET para obtener todas las reservas
     */
    @GET
    public List<ReservaDTO> getReserva() {
        List<ReservaEntity> reser = reservaLogic.obtenerReservas();
        return ReservaDTO.toReservaList(reser);
    }

    @GET
    @Path("{id: \\d+}")
    public ReservaDTO getReserva(@PathParam("id") Long id) {
        ReservaEntity reser = reservaLogic.obtenerReserva(id);
        if (reser == null) {
            throw new RuntimeException("La reserva solicitada no existe");
        }
        return new ReservaDTO(reser);
    }

    /**
     * Metodo HTTP POST para crear un nuevo objeto Reserva
     *
     * @param reservaDTO
     * @return objeto creado
     */
    @POST
    public ReservaDTO createReserva(ReservaDTO reservaDTO) {
        return new ReservaDTO(reservaLogic.crearReserva(reservaDTO.toEntity()));
    }

    /**
     * Metodo HTTp put para actualizar un objeto Reserva
     *
     * @param id
     * @param reservaDTO
     * @return objeto actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public ReservaDTO updateReserva(@PathParam("id") Long id, ReservaDTO reservaDTO) {
        ReservaEntity reser = reservaLogic.obtenerReserva(id);
        if (reser == null) {
            throw new RuntimeException("La reserva solicitada no existe");
        }
        return new ReservaDTO(reservaLogic.actualizarReserva(reservaDTO.toEntity()));
    }

    /**
     * Metodo HTTP-DELETE para eliminar un objeto de Reserva
     *
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("id") Long id) {
        ReservaEntity reser = reservaLogic.obtenerReserva(id);
        if (reser == null) {
            throw new RuntimeException("La reserva solicitada no existe");
        }
        reservaLogic.eliminarReserva(id);
    }

}
