/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author G1
 */
@Stateless
public class CiudadPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Ciudad
     *
     * @return Lista de datos de la tabla Ciudad
     */
    public List<CiudadEntity> findAll() {
        Query todos = em.createQuery("select e from CiudadEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla Ciudad
     *
     * @param id que se desea buscar
     * @return ciudadEntity
     */
    public CiudadEntity find(Long id) {
        CiudadEntity ciudad = em.find(CiudadEntity.class, id);
        return ciudad;
    }

    /**
     * Creacion de un nuevo Ciudad
     *
     * @param ciudad
     * @return nueva ciudad creada
     */
    public CiudadEntity create(CiudadEntity ciudad) {
        em.persist(ciudad);
        return ciudad;
    }

    /**
     * Actualizacion de una tupla de la tabla Ciudad
     *
     * @param ciudadActualizar
     * @return ciudad actualizado
     */
    public CiudadEntity update(CiudadEntity ciudadActualizar) {
        return em.merge(ciudadActualizar);
    }

    /**
     * Elimina una tupla curso de la tabla ciudad
     *
     * @param id
     */
    public void delete(Long id) {
        CiudadEntity ciudadDelete = em.find(CiudadEntity.class, id);
        em.remove(ciudadDelete);
    }
}
