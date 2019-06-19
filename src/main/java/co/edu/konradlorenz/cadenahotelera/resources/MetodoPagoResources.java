/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.MetodoPagoDTO;
import co.edu.konradlorenz.cadenahotelera.entities.MetodoPagoEntity;
import co.edu.konradlorenz.cadenahotelera.logic.MetodoPagoLogic;
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
@Path("/metodopago")

public class MetodoPagoResources {

    @EJB
    private MetodoPagoLogic metodoPagoLogic;

    /*
    Metodo HTTP GET para obtener todos los metodos de pago
     */
    @GET
    public List<MetodoPagoDTO> getMetodosPago() {
        List<MetodoPagoEntity> metodos = metodoPagoLogic.obtenerMetodosPago();
        return MetodoPagoDTO.toMetodoPagoList(metodos);
    }

    @GET
    @Path("{id: \\d+}")
    public MetodoPagoDTO getMetodoPago(@PathParam("id") Long id) {
        MetodoPagoEntity metodo = metodoPagoLogic.obtenerMetodoPago(id);
        if (metodo == null) {
            throw new RuntimeException("El metodo de pago solicitado no existe");
        }
        return new MetodoPagoDTO(metodo);

    }

    /**
     * Metodo HTTP POST usado para crear un nuevo objeto MetodoPago
     */
    @POST
    public MetodoPagoDTO createMetodo(MetodoPagoDTO metodoPagoDTO) {
        return new MetodoPagoDTO(metodoPagoLogic.crearMetodoPago(metodoPagoDTO.toEntity()));
    }

    /**
     * METODO HTTTP-PUT permite actualizar un objetodo MetodoPago
     *
     * @param id
     * @param metodoPagoDTO
     * @return
     */
    @PUT
    @Path("{id: \\d+}")
    public MetodoPagoDTO updateMetodoPago(@PathParam("id") Long id, MetodoPagoDTO metodoPagoDTO) {
        MetodoPagoEntity metodo = metodoPagoLogic.obtenerMetodoPago(id);
        if (metodo == null) {
            throw new RuntimeException("El metodo solicitado no existe");
        }
        return new MetodoPagoDTO(metodoPagoLogic.actualizarMetodoPago(id, metodoPagoDTO.toEntity()));

    }

    /**
     * Metodo HTTP-delete usado para eliminar un objetodo de MetodoPago
     *
     * @param id
     */
    @DELETE
    @Path("{MetodoId: \\d+}")
    public void deleteMetodoPago(@PathParam("MetodoId") Long id) {
        MetodoPagoEntity metodoPagoEntity = metodoPagoLogic.obtenerMetodoPago(id);
        if (metodoPagoEntity == null) {
            throw new RuntimeException("El metodo solicitado no existe");
        }
        metodoPagoLogic.eliminarMetodoPago(id);

    }
}
