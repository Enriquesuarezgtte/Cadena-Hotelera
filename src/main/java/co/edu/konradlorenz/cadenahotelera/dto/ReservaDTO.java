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
import co.edu.konradlorenz.cadenahotelera.entities.MetodoPagoEntity;
import co.edu.konradlorenz.cadenahotelera.entities.ReservaEntity;
import co.edu.konradlorenz.cadenahotelera.entities.TipoHabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.entities.TipoUsuarioEntity;
import co.edu.konradlorenz.cadenahotelera.entities.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CISCO
 */
public class ReservaDTO {

    private Long id;
    private String f_entrada;
    private String f_salida;
    private UsuarioDTO usuario;
    private CiudadDTO ciudad;
    private HotelDTO hotel;
    private HabitacionDTO habitacion;
    private MetodoPagoDTO metodoPago;

    public ReservaDTO() {
    }

    public ReservaDTO(ReservaEntity reservaEntity) {

        this.id = reservaEntity.getId();
        this.f_entrada = reservaEntity.getF_entrada();
        this.f_salida = reservaEntity.getF_salida();

        if (reservaEntity.getUsuarioEntity() != null) {
            this.usuario = new UsuarioDTO(reservaEntity.getUsuarioEntity());
        }
        if (reservaEntity.getCiudadEntity() != null) {
            this.ciudad = new CiudadDTO(reservaEntity.getCiudadEntity());
        }
        if (reservaEntity.getHotelEntity() != null) {
            this.hotel = new HotelDTO(reservaEntity.getHotelEntity());
        }
        if (reservaEntity.getHabitacionEntity() != null) {
            this.habitacion = new HabitacionDTO(reservaEntity.getHabitacionEntity());
        }
        if (reservaEntity.getMetodoPagoEntity() != null) {
            this.metodoPago = new MetodoPagoDTO(reservaEntity.getMetodoPagoEntity());
        }
    }

    public ReservaEntity toEntity() {

        ReservaEntity reservaEntity = new ReservaEntity();

        reservaEntity.setId(id);
        reservaEntity.setF_entrada(this.f_entrada);
        reservaEntity.setF_salida(this.f_salida);

        if (this.usuario != null) {
            UsuarioEntity usuarioEntidad = new UsuarioEntity();

            usuarioEntidad.setId(this.usuario.getId());
            usuarioEntidad.setNom_usuario(this.usuario.getNom_usuario());
            usuarioEntidad.setApe_usuario(this.usuario.getApe_usuario());
            usuarioEntidad.setCorreo(this.usuario.getCorreo());

            TipoUsuarioEntity tipoUsuEntidad = new TipoUsuarioEntity();
            tipoUsuEntidad.setCodido_tipo_usuario(this.usuario.getTiposUsuarioDTO().getId());
            tipoUsuEntidad.setNom_t_usuario(this.usuario.getTiposUsuarioDTO().getNom_t_usuario());
            usuarioEntidad.setTipoUsuarioEntity(tipoUsuEntidad);

            reservaEntity.setUsuarioEntity(usuarioEntidad);
        }

        if (this.ciudad != null) {
            CiudadEntity ciudadEntidad = new CiudadEntity();

            ciudadEntidad.setId(this.ciudad.getId());
            ciudadEntidad.setNom_ciudad(this.ciudad.getNom_ciudad());

            reservaEntity.setCiudadEntity(ciudadEntidad);
        }

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

            reservaEntity.setHotelEntity(hotelEntidad);
        }

        if (this.habitacion != null) {

            HabitacionEntity habitacionEntidad = new HabitacionEntity();

            habitacionEntidad.setCodigo_habitacion(this.habitacion.getId());
            habitacionEntidad.setNum_habitacion(this.habitacion.getNum_habitacion());

            HotelEntity hotelEntidad = new HotelEntity();
            hotelEntidad.setId(this.habitacion.getHotel().getId());
            hotelEntidad.setNom_hotel(this.habitacion.getHotel().getNom_hotel());
            hotelEntidad.setNum_habitaciones(this.habitacion.getHotel().getNum_habitaciones());
            hotelEntidad.setVal_estrellas(this.habitacion.getHotel().getVal_estrellas());
            CiudadEntity ce = new CiudadEntity();
            ce.setId(this.habitacion.getHotel().getCiudad().getId());
            ce.setNom_ciudad(this.habitacion.getHotel().getCiudad().getNom_ciudad());
            hotelEntidad.setCiudadEntity(ce);

            habitacionEntidad.setHotelEntity(hotelEntidad);

            TipoHabitacionEntity tipoHabitacionEntidad = new TipoHabitacionEntity();
            tipoHabitacionEntidad.setId(this.habitacion.getTipoHabitacion().getId());
            tipoHabitacionEntidad.setNom_t_habitacion(this.habitacion.getTipoHabitacion().getNom_t_habitacion());
            tipoHabitacionEntidad.setPrecio_t_habitacion(this.habitacion.getTipoHabitacion().getPrecio_t_habitacion());

            habitacionEntidad.setTipoHabitacionEntity(tipoHabitacionEntidad);

            EstadoHabitacionEntity habitacionEntity = new EstadoHabitacionEntity();
            habitacionEntity.setId(this.habitacion.getEstadoHabitacion().getId());
            habitacionEntity.setNom_estado(this.habitacion.getEstadoHabitacion().getNom_estado());
            habitacionEntidad.setEstadoHabitacionEntity(habitacionEntity);

            reservaEntity.setHabitacionEntity(habitacionEntidad);

        }

        if (this.metodoPago != null) {

            MetodoPagoEntity metodoEntidad = new MetodoPagoEntity();

            metodoEntidad.setId(this.metodoPago.getId());
            metodoEntidad.setNom_f_pago(this.metodoPago.getNom_f_pago());

            reservaEntity.setMetodoPagoEntity(metodoEntidad);
        }

        return reservaEntity;
    }

    public static List<ReservaDTO> toReservaList(List<ReservaEntity> reservaEntitys) {
        List<ReservaDTO> reservaDTOs = new ArrayList<>();
        for (int i = 0; i < reservaEntitys.size(); i++) {
            reservaDTOs.add(new ReservaDTO(reservaEntitys.get(i)));
        }
        return reservaDTOs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getF_entrada() {
        return f_entrada;
    }

    public void setF_entrada(String f_entrada) {
        this.f_entrada = f_entrada;
    }

    public String getF_salida() {
        return f_salida;
    }

    public void setF_salida(String f_salida) {
        this.f_salida = f_salida;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public HabitacionDTO getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionDTO habitacion) {
        this.habitacion = habitacion;
    }

    public MetodoPagoDTO getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoDTO metodoPago) {
        this.metodoPago = metodoPago;
    }

}
