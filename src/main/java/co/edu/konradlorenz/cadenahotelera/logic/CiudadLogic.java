/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.CiudadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Bryan
 */
@Stateless
public class CiudadLogic {

    @Inject
    private CiudadPersistence ciudadPersistence;

    public List<CiudadEntity> obtenerCiudades() {
        List<CiudadEntity> ciudades = ciudadPersistence.findAll();
        return ciudades;
    }

    public CiudadEntity obtenerCiudad(Long id) {
        CiudadEntity ciudad = ciudadPersistence.find(id);
        if (ciudad == null) {
            throw new IllegalArgumentException("La ciudad solicitada no existe.");
        }
        return ciudad;
    }

    public CiudadEntity crearCiudad(CiudadEntity ciudadEntity) {
        ciudadPersistence.create(ciudadEntity);
        return ciudadEntity;
    }

    public CiudadEntity actualizarCiudad(Long id, CiudadEntity ciudadEntity) {
        CiudadEntity ciudad = ciudadPersistence.update(ciudadEntity);
        return ciudad;
    }

    public void eliminarCiudad(Long id) {
        ciudadPersistence.delete(id);
    }

}
