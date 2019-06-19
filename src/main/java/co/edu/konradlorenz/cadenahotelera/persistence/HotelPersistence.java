/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.HotelEntity;
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
public class HotelPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Hotel
     *
     * @return Lista de datos de la tabla hotel
     */
    public List<HotelEntity> findAll() {
        Query todos = em.createQuery("select e from HotelEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla Hotel
     *
     * @param id que se desea buscar
     * @return hotelEntity
     */
    public HotelEntity find(Long id) {
        HotelEntity hotel = em.find(HotelEntity.class, id);
        return hotel;
    }

    /**
     * Creacion de un nuevo Hotel
     *
     * @param hotel
     * @return nuevo hotel creado
     */
    public HotelEntity create(HotelEntity hotel) {
        em.persist(hotel);
        return hotel;
    }

    /**
     * Actualizacion de una tupla de la tabla Hotel
     *
     *
     */
    public HotelEntity update(HotelEntity hotelActualizar) {
        return em.merge(hotelActualizar);
    }

    /**
     * Elimina una tupla del Hotel
     *
     * @param id
     */
    public void delete(Long id) {
        HotelEntity hotelDelete = em.find(HotelEntity.class, id);
        em.remove(hotelDelete);
    }
}
