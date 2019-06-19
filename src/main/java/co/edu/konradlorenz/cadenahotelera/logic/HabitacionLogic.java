/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.HabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.HabitacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Bryan
 */
@Stateless
public class HabitacionLogic {

    @Inject
    private HabitacionPersistence habitacionPersistence;

    public List<HabitacionEntity> obtenerHabitaciones() {
        List<HabitacionEntity> habitaciones = habitacionPersistence.findAll();
        return habitaciones;
    }

    public HabitacionEntity obtenerHabitacion(Long id) {
        HabitacionEntity habitacion = habitacionPersistence.find(id);
        if (habitacion == null) {
            throw new IllegalArgumentException("La habitacion solicitada no existe.");
        }
        return habitacion;
    }

    public HabitacionEntity crearHabitacion(HabitacionEntity habitacionEntity) {
        habitacionPersistence.create(habitacionEntity);
        return habitacionEntity;
    }

    public HabitacionEntity actualizarHabitacion(Long id, HabitacionEntity habitacionEntity) {
        HabitacionEntity habitacion = habitacionPersistence.update(habitacionEntity);
        return habitacion;
    }

    public void eliminarHabitacion(Long id) {
        habitacionPersistence.delete(id);
    }

}
