/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.HotelDTO;
import co.edu.konradlorenz.cadenahotelera.entities.HotelEntity;
import co.edu.konradlorenz.cadenahotelera.logic.HotelLogic;
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
@Path("/hoteles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HotelResource {

    @EJB
    private HotelLogic hotelLogic;

    @GET
    public List<HotelDTO> getHotelList() {
        List<HotelEntity> hoteles = hotelLogic.obtenerHoteles();
        HotelDTO hotel = new HotelDTO();
        return hotel.toHotelList(hoteles);
    }

    @GET
    @Path("{id: \\d+}")
    public HotelDTO getHotel(@PathParam("id") Long id) {
        HotelEntity hotel = hotelLogic.obtenerHotel(id);
        if (hotel == null) {
            throw new RuntimeException("El hotel solicitado no existe");
        }
        return new HotelDTO(hotel);
    }

    @POST
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        return new HotelDTO(hotelLogic.crearHotelEntity(hotelDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public HotelDTO updateHotel(@PathParam("id") Long id, HotelDTO hotelDTO) {
        HotelEntity entity = hotelLogic.obtenerHotel(id);
        if (entity == null) {
            throw new RuntimeException("El hotel solicitado no existe.");
        }
        return new HotelDTO(hotelLogic.actualizarHotel(id, hotelDTO.toEntity()));
    }

    @DELETE
    @Path("{hotelId: \\d+}")
    public void deleteHotel(@PathParam("hotelId") Long id) {
        HotelEntity entity = hotelLogic.obtenerHotel(id);
        if (entity == null) {
            throw new RuntimeException("El hotel solicitado no existe.");
        }
        hotelLogic.eliminarHotel(id);
    }
}
