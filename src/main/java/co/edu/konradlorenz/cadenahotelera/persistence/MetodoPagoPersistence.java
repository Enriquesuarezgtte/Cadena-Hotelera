/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.MetodoPagoEntity;
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
public class MetodoPagoPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla metododepago
     *
     * @return Lista de datos de la tabla metododepago
     */
    public List<MetodoPagoEntity> findAll() {
        Query todos = em.createQuery("select e from MetodoPagoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla metododepago
     *
     * @param id que se desea buscar
     * @return metododepagoEntity
     */
    public MetodoPagoEntity find(Long id) {
        MetodoPagoEntity mpago = em.find(MetodoPagoEntity.class, id);
        return mpago;
    }

    /**
     * Creacion de un nuevo metododepago
     *
     * @param mpago
     * @return nuevo metododepago creado
     */
    public MetodoPagoEntity create(MetodoPagoEntity mpago) {
        em.persist(mpago);
        return mpago;
    }

    /**
     * Actualizacion de una tupla de la tabla metododepago
     *
     * @param mpagoActualizar
     * @return metododepago actualizado
     */
    public MetodoPagoEntity update(MetodoPagoEntity mpagoActualizar) {
        return em.merge(mpagoActualizar);
    }

    /**
     * Elimina una tupla de la tabla metododepago
     *
     * @param id
     */
    public void delete(Long id) {
        MetodoPagoEntity mpagoDelete = em.find(MetodoPagoEntity.class, id);
        em.remove(mpagoDelete);
    }
}
