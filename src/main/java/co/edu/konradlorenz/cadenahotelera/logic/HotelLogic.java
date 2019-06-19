/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.HotelEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.HotelPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author EnriqueS
 */
@Stateless
public class HotelLogic {

    /**
     * Inyeccion del persistence de Hotel
     */
    @Inject
    private HotelPersistence hotelPersistence;

    /**
     * Obtener todos los hoteles
     *
     * @return
     */
    public List<HotelEntity> obtenerHoteles() {
        List<HotelEntity> hoteles = hotelPersistence.findAll();
        return hoteles;
    }

    /**
     * Obtener un hotel por id
     *
     * @param id
     * @return hotel encontrado
     */
    public HotelEntity obtenerHotel(Long id) {
        HotelEntity hotelEntity = hotelPersistence.find(id);
        if (hotelEntity == null) {
            throw new IllegalArgumentException("Hotel solicitado no existe");
        }
        return hotelEntity;
    }

    /*
    metodo para crear un nuevo estudiante
     */
    public HotelEntity crearHotelEntity(HotelEntity hotelEntity) {
        hotelPersistence.create(hotelEntity);
        return hotelEntity;
    }

    /**
     * Actualiza un hotel
     *
     * @param id
     * @param hotelEntity
     * @return hotel actualizado
     */
    public HotelEntity actualizarHotel(Long id, HotelEntity hotelEntity) {
        HotelEntity hotel = hotelPersistence.update(hotelEntity);
        return hotel;
    }

    /**
     * Elimina un hotel
     *
     * @param id
     */
    public void eliminarHotel(Long id) {
        hotelPersistence.delete(id);
    }

}
