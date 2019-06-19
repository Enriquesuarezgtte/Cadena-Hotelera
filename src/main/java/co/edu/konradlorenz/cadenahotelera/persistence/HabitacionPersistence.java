/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.HabitacionEntity;
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
public class HabitacionPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla habitacion
     *
     * @return Lista de datos de la tabla habitacion
     */
    public List<HabitacionEntity> findAll() {
        Query todos = em.createQuery("select e from HabitacionEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla habitacion
     *
     * @param id que se desea buscar
     * @return HabitacionEntity
     */
    public HabitacionEntity find(Long id) {
        HabitacionEntity habitacion = em.find(HabitacionEntity.class, id);
        return habitacion;
    }

    /**
     * Creacion de un nuevo habitacion
     *
     * @param habitacion
     * @return nuevo habitacion creado
     */
    public HabitacionEntity create(HabitacionEntity habitacion) {
        em.persist(habitacion);
        return habitacion;
    }

    /**
     * Actualizacion de una tupla de la tabla habitacion
     *
     * @param habitacionActualizar
     * @return habitacion actualizado
     */
    public HabitacionEntity update(HabitacionEntity habitacionActualizar) {
        return em.merge(habitacionActualizar);
    }

    /**
     * Elimina una tupla de la tabla habitacion
     *
     * @param id
     */
    public void delete(Long id) {
        HabitacionEntity habitacionDelete = em.find(HabitacionEntity.class, id);
        em.remove(habitacionDelete);
    }
}
