/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. crrgir
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import co.edu.konradlorenz.cadenahotelera.entities.EstadoHabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.entities.HabitacionEntity;
import co.edu.konradlorenz.cadenahotelera.entities.HotelEntity;
import co.edu.konradlorenz.cadenahotelera.entities.ServicioDadoEntity;
import co.edu.konradlorenz.cadenahotelera.entities.ServicioEntity;
import co.edu.konradlorenz.cadenahotelera.entities.TipoHabitacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueS
 */
public class ServicioDadoDTO {

    private Long id;
    private HabitacionDTO habitacionDTO;
    private ServicioDTO servicioDTO;

    public ServicioDadoDTO() {
    }

    public ServicioDadoDTO(ServicioDadoEntity servicioDadoEntity) {
        this.id = servicioDadoEntity.getId();
        if (servicioDadoEntity.getHabitacionEntity() != null) {
            this.habitacionDTO = new HabitacionDTO(servicioDadoEntity.getHabitacionEntity());

        }
        if (servicioDadoEntity.getServicioEntity() != null) {
            this.servicioDTO = new ServicioDTO(servicioDadoEntity.getServicioEntity());
        }

    }

    public ServicioDadoEntity toEntity() {
        ServicioDadoEntity servicioDadoEntity = new ServicioDadoEntity();
        servicioDadoEntity.setId(id);
        if (habitacionDTO != null) {

            HabitacionEntity he = new HabitacionEntity();
            he.setCodigo_habitacion(this.habitacionDTO.getId());
            he.setNum_habitacion(this.habitacionDTO.getNum_habitacion());

            HotelEntity he1 = new HotelEntity();
            he1.setId(this.habitacionDTO.getHotel().getId());
            he1.setNom_hotel(this.habitacionDTO.getHotel().getNom_hotel());
            he1.setNum_habitaciones(this.habitacionDTO.getHotel().getNum_habitaciones());
            he1.setVal_estrellas(this.habitacionDTO.getHotel().getVal_estrellas());
            CiudadEntity ce = new CiudadEntity();
            ce.setId(this.habitacionDTO.getHotel().getCiudad().getId());
            ce.setNom_ciudad(this.habitacionDTO.getHotel().getCiudad().getNom_ciudad());
            he1.setCiudadEntity(ce);

            he.setHotelEntity(he1);

            TipoHabitacionEntity the = new TipoHabitacionEntity();
            the.setId(this.habitacionDTO.getTipoHabitacion().getId());
            the.setNom_t_habitacion(this.habitacionDTO.getTipoHabitacion().getNom_t_habitacion());
            the.setPrecio_t_habitacion(this.habitacionDTO.getTipoHabitacion().getPrecio_t_habitacion());

            he.setTipoHabitacionEntity(the);

            EstadoHabitacionEntity habitacionEntity = new EstadoHabitacionEntity();
            habitacionEntity.setId(this.habitacionDTO.getEstadoHabitacion().getId());
            habitacionEntity.setNom_estado(this.habitacionDTO.getEstadoHabitacion().getNom_estado());
            he.setEstadoHabitacionEntity(habitacionEntity);
            servicioDadoEntity.setHabitacionEntity(he);

        }
        if (servicioDTO != null) {
            ServicioEntity servicioEntity = new ServicioEntity();
            servicioEntity.setId(this.servicioDTO.getId());
            servicioEntity.setNom_servicio(this.servicioDTO.getNom_servicio());
            servicioEntity.setCosto(this.servicioDTO.getCosto());
            servicioDadoEntity.setServicioEntity(servicioEntity);

        }
        return servicioDadoEntity;
    }

    public static List<ServicioDadoDTO> toServicioDadoList(List<ServicioDadoEntity> servicioDadoEntitys) {
        List<ServicioDadoDTO> servicioDTOs = new ArrayList<>();
        for (int i = 0; i < servicioDadoEntitys.size(); i++) {
            servicioDTOs.add(new ServicioDadoDTO(servicioDadoEntitys.get(i)));
        }
        return servicioDTOs;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HabitacionDTO getHabitacionDTO() {
        return habitacionDTO;
    }

    public void setHabitacionDTO(HabitacionDTO habitacionDTO) {
        this.habitacionDTO = habitacionDTO;
    }

    public ServicioDTO getServicioDTO() {
        return servicioDTO;
    }

    public void setServicioDTO(ServicioDTO servicioDTO) {
        this.servicioDTO = servicioDTO;
    }

}
