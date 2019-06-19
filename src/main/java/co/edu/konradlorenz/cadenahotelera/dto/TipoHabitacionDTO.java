/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.TipoHabitacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeison
 */
public class TipoHabitacionDTO {

    private Long id;

    private String nom_t_habitacion;

    private double precio_t_habitacion;

    /**
     * Constructor por defecto
     */
    public TipoHabitacionDTO() {
    }

    public TipoHabitacionDTO(TipoHabitacionEntity tipoHabitacionEntity) {
        this.id = tipoHabitacionEntity.getId();
        this.nom_t_habitacion = tipoHabitacionEntity.getNom_t_habitacion();
        this.precio_t_habitacion = tipoHabitacionEntity.getPrecio_t_habitacion();

    }

    /**
     * Metodo que realiza la conversión de objeto a entidad
     *
     * @return entidad
     */
    public TipoHabitacionEntity toEntity() {
        TipoHabitacionEntity tipoHabitacionEntity = new TipoHabitacionEntity();
        tipoHabitacionEntity.setId(this.id);
        tipoHabitacionEntity.setNom_t_habitacion(this.nom_t_habitacion);
        tipoHabitacionEntity.setPrecio_t_habitacion(this.precio_t_habitacion);
        return tipoHabitacionEntity;
    }

    public List<TipoHabitacionDTO> toTipoHabitacionList(List<TipoHabitacionEntity> tipoHabitacionList) {

        List<TipoHabitacionDTO> listaTipoHabitacionDTO = new ArrayList<>();

        for (int i = 0; i < tipoHabitacionList.size(); i++) {
            listaTipoHabitacionDTO.add(new TipoHabitacionDTO(tipoHabitacionList.get(i)));

        }
        return listaTipoHabitacionDTO;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_t_habitacion() {
        return nom_t_habitacion;
    }

    public void setNom_t_habitacion(String nom_t_habitacion) {
        this.nom_t_habitacion = nom_t_habitacion;
    }

    public double getPrecio_t_habitacion() {
        return precio_t_habitacion;
    }

    public void setPrecio_t_habitacion(double precio_t_habitacion) {
        this.precio_t_habitacion = precio_t_habitacion;
    }

}
