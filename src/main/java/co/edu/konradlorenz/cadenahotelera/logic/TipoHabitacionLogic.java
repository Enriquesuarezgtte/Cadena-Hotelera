/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.TipoHabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.TipoHabitacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jeison
 */
@Stateless
public class TipoHabitacionLogic {

    @Inject
    private TipoHabitacionPersistence tipohabitacionpersistence;

    public List<TipoHabitacionEntity> obtenerhabitacion() {
        List<TipoHabitacionEntity> thabi = tipohabitacionpersistence.findAll();
        return thabi;
    }

    public TipoHabitacionEntity obtenerthabitacion(long id) {
        TipoHabitacionEntity thabi = tipohabitacionpersistence.find(id);
        if (thabi == null) {
            throw new IllegalArgumentException("tipo de habitacion solicitado no existe.");
        }
        return thabi;
    }

    public TipoHabitacionEntity crearthabitacion(TipoHabitacionEntity thabiEntity) {
        tipohabitacionpersistence.create(thabiEntity);
        return thabiEntity;
    }

    public TipoHabitacionEntity actualizarthabi(TipoHabitacionEntity thabiEntity, long id) {
        TipoHabitacionEntity thabi = tipohabitacionpersistence.update(thabiEntity);
        return thabi;
    }

    public void eliminarthabi(long id) {
        tipohabitacionpersistence.delete(id);
    }
}
