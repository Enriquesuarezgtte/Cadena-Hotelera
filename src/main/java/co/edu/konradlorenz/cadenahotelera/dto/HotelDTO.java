/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import co.edu.konradlorenz.cadenahotelera.entities.HotelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CISCO
 */
public class HotelDTO {

    private Long id;
    private String nom_hotel;
    private long num_habitaciones;
    private CiudadDTO ciudad;
    private long val_estrellas;

    public HotelDTO() {
    }

    public HotelDTO(HotelEntity hotelEntity) {
        this.id = hotelEntity.getId();
        this.nom_hotel = hotelEntity.getNom_hotel();
        this.num_habitaciones = hotelEntity.getNum_habitaciones();
        this.val_estrellas = hotelEntity.getVal_estrellas();

        if (hotelEntity.getCiudadEntity() != null) {
            this.ciudad = new CiudadDTO(hotelEntity.getCiudadEntity());
        }
    }

    public HotelEntity toEntity() {

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId(this.id);
        hotelEntity.setNom_hotel(this.nom_hotel);
        hotelEntity.setNum_habitaciones(this.num_habitaciones);
        hotelEntity.setVal_estrellas(this.val_estrellas);

        if (this.ciudad != null) {
            CiudadEntity ciudadEntidad = new CiudadEntity();
            ciudadEntidad.setId(this.ciudad.getId());
            ciudadEntidad.setNom_ciudad(this.ciudad.getNom_ciudad());

            hotelEntity.setCiudadEntity(ciudadEntidad);
        }

        return hotelEntity;

    }

    public List<HotelDTO> toHotelList(List<HotelEntity> hotelList) {

        List<HotelDTO> listaHotelDTO = new ArrayList<>();

        for (int i = 0; i < hotelList.size(); i++) {
            listaHotelDTO.add(new HotelDTO(hotelList.get(i)));
        }

        return listaHotelDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public long getNum_habitaciones() {
        return num_habitaciones;
    }

    public void setNum_habitaciones(long num_habitaciones) {
        this.num_habitaciones = num_habitaciones;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    public long getVal_estrellas() {
        return val_estrellas;
    }

    public void setVal_estrellas(long val_estrellas) {
        this.val_estrellas = val_estrellas;
    }

}
