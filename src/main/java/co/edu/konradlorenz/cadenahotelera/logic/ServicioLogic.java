/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.ServicioEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.ServicioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jeison
 */
@Stateless
public class ServicioLogic {

    @Inject
    private ServicioPersistence serviciopersistence;

    public List<ServicioEntity> obtenerservicio() {
        List<ServicioEntity> servicio = serviciopersistence.findAll();
        return servicio;
    }

    public ServicioEntity obtenerservicio(long id) {
        ServicioEntity servicio = serviciopersistence.find(id);
        if (servicio == null) {
            throw new IllegalArgumentException("servicio solicitado no existe.");
        }
        return servicio;
    }

    public ServicioEntity crearservicio(ServicioEntity servEntity) {
        serviciopersistence.create(servEntity);
        return servEntity;
    }

    public ServicioEntity ectualizarservicio(ServicioEntity servEntity, long id) {
        ServicioEntity servicio = serviciopersistence.update(servEntity);
        return servicio;
    }

    public void eliminarservicio(long id) {
        serviciopersistence.delete(id);
    }
}
