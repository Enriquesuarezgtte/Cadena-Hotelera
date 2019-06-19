/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.ServicioDadoEntity;
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
public class ServicioDadoPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Darservicio
     *
     * @return Lista de datos de la tabla DarServicio
     */
    public List<ServicioDadoEntity> findAll() {
        Query todos = em.createQuery("select e from ServicioDadoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla Darservicio
     *
     * @param id que se desea buscar
     * @return darservicioEntity
     */
    public ServicioDadoEntity find(Long id) {
        ServicioDadoEntity drservicio = em.find(ServicioDadoEntity.class, id);
        return drservicio;
    }

    /**
     * Creacion de un nuevo Darservicio
     *
     * @param drservicio
     * @return nuevo drservicio creado
     */
    public ServicioDadoEntity create(ServicioDadoEntity drservicio) {
        em.persist(drservicio);
        return drservicio;
    }

    /**
     * Actualizacion de una tupla de la tabla Darservicio
     *
     * @param drservicioActualizar
     * @return darservicio actualizado
     */
    public ServicioDadoEntity update(ServicioDadoEntity drservicioActualizar) {
        return em.merge(drservicioActualizar);
    }

    /**
     * Elimina una tupla de la tabla Darservicio
     *
     * @param id
     */
    public void delete(Long id) {
        ServicioDadoEntity drservicioDelete = em.find(ServicioDadoEntity.class, id);
        em.remove(drservicioDelete);
    }
}
