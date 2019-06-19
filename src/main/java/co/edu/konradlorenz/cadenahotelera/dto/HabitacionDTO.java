/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import co.edu.konradlorenz.cadenahotelera.entities.EstadoHabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.entities.HabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.entities.HotelEntity;
import co.edu.konradlorenz.cadenahotelera.entities.TipoHabitacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CISCO
 */
public class HabitacionDTO {

    private Long id;
    private Long num_habitacion;
    private HotelDTO hotel;
    private TipoHabitacionDTO tipoHabitacion;
    private EstadoHabitacionDTO estadoHabitacion;

    public HabitacionDTO() {
    }

    public HabitacionDTO(HabitacionEntity habitacionEntity) {
        this.id = habitacionEntity.getCodigo_habitacion();
        this.num_habitacion = habitacionEntity.getNum_habitacion();

        if (habitacionEntity.getHotelEntity() != null) {
            this.hotel = new HotelDTO(habitacionEntity.getHotelEntity());
        }
        if (habitacionEntity.getEstadoHabitacionEntity() != null) {
            this.estadoHabitacion = new EstadoHabitacionDTO(habitacionEntity.getEstadoHabitacionEntity());
        }
        if (habitacionEntity.getTipoHabitacionEntity() != null) {
            this.tipoHabitacion = new TipoHabitacionDTO(habitacionEntity.getTipoHabitacionEntity());
        }
    }

    public HabitacionEntity toEntity() {
        HabitacionEntity habitacionEntity = new HabitacionEntity();

        habitacionEntity.setCodigo_habitacion(this.id);
        habitacionEntity.setNum_habitacion(this.num_habitacion);

        if (this.hotel != null) {
            HotelEntity hotelEntidad = new HotelEntity();

            hotelEntidad.setId(this.hotel.getId());
            hotelEntidad.setNom_hotel(this.hotel.getNom_hotel());
            hotelEntidad.setNum_habitaciones(this.hotel.getNum_habitaciones());
            hotelEntidad.setVal_estrellas(this.hotel.getVal_estrellas());

            CiudadEntity ciudadEntidad = new CiudadEntity();
            ciudadEntidad.setId(this.hotel.getCiudad().getId());
            ciudadEntidad.setNom_ciudad(this.hotel.getCiudad().getNom_ciudad());

            hotelEntidad.setCiudadEntity(ciudadEntidad);

            habitacionEntity.setHotelEntity(hotelEntidad);

        }
        if (this.tipoHabitacion != null) {
            TipoHabitacionEntity tipoHabitacionEntidad = new TipoHabitacionEntity();

            tipoHabitacionEntidad.setId(this.tipoHabitacion.getId());
            tipoHabitacionEntidad.setNom_t_habitacion(this.tipoHabitacion.getNom_t_habitacion());
            tipoHabitacionEntidad.setPrecio_t_habitacion(this.tipoHabitacion.getPrecio_t_habitacion());

            habitacionEntity.setTipoHabitacionEntity(tipoHabitacionEntidad);
        }
        if (this.estadoHabitacion != null) {
            EstadoHabitacionEntity estadoHabitacionEntidad = new EstadoHabitacionEntity();

            estadoHabitacionEntidad.setId(this.estadoHabitacion.getId());
            estadoHabitacionEntidad.setNom_estado(this.estadoHabitacion.getNom_estado());

            habitacionEntity.setEstadoHabitacionEntity(estadoHabitacionEntidad);
        }

        return habitacionEntity;

    }

    public List<HabitacionDTO> toHabitacionList(List<HabitacionEntity> habitacionList) {

        List<HabitacionDTO> listaHabitacionDTO = new ArrayList<>();

        for (int i = 0; i < habitacionList.size(); i++) {

            listaHabitacionDTO.add(new HabitacionDTO(habitacionList.get(i)));
        }

        return listaHabitacionDTO;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(Long num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public TipoHabitacionDTO getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacionDTO tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public EstadoHabitacionDTO getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacionDTO estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

}
