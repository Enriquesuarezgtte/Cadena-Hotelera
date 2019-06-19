/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.EstadoHabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.EstadoHabitacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Bryan
 */
@Stateless
public class EstadoHabitacionLogic {

    @Inject
    private EstadoHabitacionPersistence estadoHabitacionPersistence;

    public List<EstadoHabitacionEntity> obtenerEstadosHabitaciones() {
        List<EstadoHabitacionEntity> estadosHabitaciones = estadoHabitacionPersistence.findAll();
        return estadosHabitaciones;
    }

    public EstadoHabitacionEntity obtenerEstadoHabitacion(Long id) {
        EstadoHabitacionEntity estadoH = estadoHabitacionPersistence.find(id);
        if (estadoH == null) {
            throw new IllegalArgumentException("El estado solicitado no existe.");
        }
        return estadoH;
    }

    public EstadoHabitacionEntity crearEstadoHabitacion(EstadoHabitacionEntity estadoHabitacionEntity) {
        estadoHabitacionPersistence.create(estadoHabitacionEntity);
        return estadoHabitacionEntity;
    }

    public EstadoHabitacionEntity actualizarEstadoHabitacion(Long id, EstadoHabitacionEntity estadoHabitacionEntity) {
        EstadoHabitacionEntity estadoH = estadoHabitacionPersistence.update(estadoHabitacionEntity);
        return estadoH;
    }

    public void eliminarEstadoHabitacion(Long id) {
        estadoHabitacionPersistence.delete(id);
    }
}
