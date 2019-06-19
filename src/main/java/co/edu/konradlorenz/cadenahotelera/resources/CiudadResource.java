/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import co.edu.konradlorenz.cadenahotelera.dto.CiudadDTO;
import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import co.edu.konradlorenz.cadenahotelera.logic.CiudadLogic;
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
@Path("/ciudades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CiudadResource {

    @EJB
    private CiudadLogic ciudadLogic;

    @GET
    public List<CiudadDTO> getCiudadList() {
        List<CiudadEntity> ciudades = ciudadLogic.obtenerCiudades();
        CiudadDTO ciudad = new CiudadDTO();
        return ciudad.toCiudadList(ciudades);
    }

    @GET
    @Path("{id: \\d+}")
    public CiudadDTO getCiudad(@PathParam("id") Long id) {
        CiudadEntity ciudad = ciudadLogic.obtenerCiudad(id);
        if (ciudad == null) {
            throw new RuntimeException("La ciudad solicitada no existe.");
        }
        return new CiudadDTO(ciudad);
    }

    @POST
    public CiudadDTO createCiudad(CiudadDTO ciudadDTO) {
        return new CiudadDTO(ciudadLogic.crearCiudad(ciudadDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateCiudad(@PathParam("id") Long id, CiudadDTO ciudadDTO) {
        CiudadEntity entity = ciudadLogic.obtenerCiudad(id);
        if (entity == null) {
            throw new RuntimeException("La ciudad solicitada no existe.");
        }
        return new CiudadDTO(ciudadLogic.actualizarCiudad(id, ciudadDTO.toEntity()));
    }

    @DELETE
    @Path("{ciudadId: \\d+}")
    public void deleteCiudad(@PathParam("ciudadId") Long id) {
        CiudadEntity entity = ciudadLogic.obtenerCiudad(id);
        if (entity == null) {
            throw new RuntimeException("La ciudad solicitada no existe.");
        }
        ciudadLogic.eliminarCiudad(id);
    }
}
