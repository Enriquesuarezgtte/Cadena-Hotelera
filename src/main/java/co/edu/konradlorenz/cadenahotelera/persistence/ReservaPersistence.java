/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.ReservaEntity;
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
public class ReservaPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla reserva
     *
     * @return Lista de datos de la tabla reserva
     */
    public List<ReservaEntity> findAll() {
        Query todos = em.createQuery("select e from ReservaEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla reserva
     *
     * @param id que se desea buscar
     * @return reservaEntity
     */
    public ReservaEntity find(Long id) {
        ReservaEntity reserva = em.find(ReservaEntity.class, id);
        return reserva;
    }

    /**
     * Creacion de un nuevo reserva
     *
     * @param reserva
     * @return nuevo reserva creado
     */
    public ReservaEntity create(ReservaEntity reserva) {
        em.persist(reserva);
        return reserva;
    }

    /**
     * Actualizacion de una tupla de la tabla reserva
     *
     * @param reservaActualizar
     * @return reserva actualizado
     */
    public ReservaEntity update(ReservaEntity reservaActualizar) {
        return em.merge(reservaActualizar);
    }

    /**
     * Elimina una tupla de la tabla reserva
     *
     * @param id
     */
    public void delete(Long id) {
        ReservaEntity reservaDelete = em.find(ReservaEntity.class, id);
        em.remove(reservaDelete);
    }
}
