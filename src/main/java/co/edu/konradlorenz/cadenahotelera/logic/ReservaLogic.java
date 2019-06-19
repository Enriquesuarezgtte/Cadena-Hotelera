/*

* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.ReservaEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.ReservaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author EnriqueS
 */
@Stateless
public class ReservaLogic {

    /**
     * Inyeccion del persistence de reserva
     */
    @Inject
    private ReservaPersistence reservaPersistence;

    /**
     * Obtener todas las reservas
     *
     * @return
     */
    public List<ReservaEntity> obtenerReservas() {
        List<ReservaEntity> reservas = reservaPersistence.findAll();
        return reservas;
    }

    /**
     * Metodo para obtener una reserva por id
     *
     * @param id
     * @return reserva encontrada
     */
    public ReservaEntity obtenerReserva(Long id) {
        ReservaEntity reservaEntity = reservaPersistence.find(id);
        if (reservaEntity == null) {
            throw new IllegalArgumentException("La reserva solicitada no existe");
        }

        return reservaEntity;

    }

    /**
     * Metodo para crear una reserva
     *
     * @param reservaEntity
     * @return reserva creada
     */
    public ReservaEntity crearReserva(ReservaEntity reservaEntity) {
        reservaPersistence.create(reservaEntity);
        return reservaEntity;

    }

    /**
     * Actualizar reserva
     *
     * @param reservaEntity
     * @return
     */
    public ReservaEntity actualizarReserva(ReservaEntity reservaEntity) {
        ReservaEntity reserva = reservaPersistence.update(reservaEntity);
        return reserva;
    }

    public void eliminarReserva(Long id) {
        reservaPersistence.delete(id);
    }

}
