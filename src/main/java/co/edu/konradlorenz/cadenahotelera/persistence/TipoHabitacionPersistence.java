/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.TipoHabitacionEntity;
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
public class TipoHabitacionPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla tipohabitacion
     *
     * @return Lista de datos de la tabla usuario
     */
    public List<TipoHabitacionEntity> findAll() {
        Query todos = em.createQuery("select e from TipoHabitacionEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla tipohabitacion
     *
     * @param id que se desea buscar
     * @return tipohabitacionEntity
     */
    public TipoHabitacionEntity find(Long id) {
        TipoHabitacionEntity tipohabitacion = em.find(TipoHabitacionEntity.class, id);
        return tipohabitacion;
    }

    /**
     * Creacion de un nuevo tipohabitacion
     *
     * @param tipohabitacion
     * @return nuevo tipohabitacion creado
     */
    public TipoHabitacionEntity create(TipoHabitacionEntity tipohabitacion) {
        em.persist(tipohabitacion);
        return tipohabitacion;
    }

    /**
     * Actualizacion de una tupla de la tabla tipohabitacion
     *
     * @param tipohabitacionActualizar
     * @return tipohabitacion actualizado
     */
    public TipoHabitacionEntity update(TipoHabitacionEntity tipohabitacionActualizar) {
        return em.merge(tipohabitacionActualizar);
    }

    /**
     * Elimina una tupla curso de la tabla tipohabitacion
     *
     * @param id
     */
    public void delete(Long id) {
        TipoHabitacionEntity tipohabitacionDelete = em.find(TipoHabitacionEntity.class, id);
        em.remove(tipohabitacionDelete);
    }
}
