/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.EstadoHabitacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jeison
 */
@Stateless
public class EstadoHabitacionPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager ema;

    /**
     * Obtener la lista con los datos de la tabla estadohabitacion
     *
     * @return Lista de datos de la tabla estadohabitacion
     */
    public List<EstadoHabitacionEntity> findAll() {
        Query todos = ema.createQuery("select e from EstadoHabitacionEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla estadohabitacion
     *
     * @param id que se desea buscar
     * @return EstadoHabitacionEntity
     */
    public EstadoHabitacionEntity find(Long id) {
        EstadoHabitacionEntity eshabitacion = ema.find(EstadoHabitacionEntity.class, id);
        return eshabitacion;
    }

    /**
     * Creacion de un nuevo estadohabitacion
     *
     * @param eshabitacion
     * @return nuevo estadohabitacion creado
     */
    public EstadoHabitacionEntity create(EstadoHabitacionEntity eshabitacion) {
        ema.persist(eshabitacion);
        return eshabitacion;
    }

    /**
     * Actualizacion de una tupla de la tabla estadohabitacion
     *
     * @param eshabitacionActualizar
     * @return estadohabitacion actualizado
     */
    public EstadoHabitacionEntity update(EstadoHabitacionEntity eshabitacionActualizar) {
        return ema.merge(eshabitacionActualizar);
    }

    /**
     * Elimina una tupla de la tabla estadohabitacion
     *
     * @param id
     */
    public void delete(Long id) {
        EstadoHabitacionEntity eshabitacionDelete = ema.find(EstadoHabitacionEntity.class, id);
        ema.remove(eshabitacionDelete);
    }
}
