/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.ServicioEntity;
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
public class ServicioPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Servicio
     *
     * @return Lista de datos de la tabla servicio
     */
    public List<ServicioEntity> findAll() {
        Query todos = em.createQuery("select e from ServicioEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla Servicio
     *
     * @param id que se desea buscar
     * @return servicioEntity
     */
    public ServicioEntity find(Long id) {
        ServicioEntity servicio = em.find(ServicioEntity.class, id);
        return servicio;
    }

    /**
     * Creacion de un nuevo Servicio
     *
     * @param servicio
     * @return nuevo curso creado
     */
    public ServicioEntity create(ServicioEntity servicio) {
        em.persist(servicio);
        return servicio;
    }

    /**
     * Actualizacion de una tupla de la tabla Servicio
     *
     * @param servicioActualizar
     * @return servicio actualizado
     */
    public ServicioEntity update(ServicioEntity servicioActualizar) {
        return em.merge(servicioActualizar);
    }

    /**
     * Elimina una tupla curso de la tabla Servicio
     *
     * @param id
     */
    public void delete(Long id) {
        ServicioEntity servicioDelete = em.find(ServicioEntity.class, id);
        em.remove(servicioDelete);
    }
}
