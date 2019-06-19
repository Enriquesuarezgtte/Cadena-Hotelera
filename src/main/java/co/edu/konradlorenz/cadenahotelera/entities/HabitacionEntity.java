/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jeison
 */
/**
 * Modificado por:
 *
 * @author Bryan el dia 22/05/2018
 */
@Entity
public class HabitacionEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * Llave principal de la entidad habitacion
     */
    @Id
    @Column(name = "cod_habitacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo_habitacion;

    /**
     * Variable que almacena el número de la habitacion
     */
    @Column(name = "num_habitacion", nullable = false)
    private long num_habitacion;

    /**
     * Atributo que maneja la relación con la entidad Hotel.
     */
    @ManyToOne
    @JoinColumn(name = "cod_hotel")
    private HotelEntity hotelEntity;

    /**
     * Atributo que maneja la relación con la entidad Tipo_Habitación.
     */
    @ManyToOne
    @JoinColumn(name = "cod_t_habitacion")
    private TipoHabitacionEntity tipoHabitacionEntity;

    /**
     * Atributo que maneja la relación con la entidad Estado_Habitacion
     */
    @ManyToOne
    @JoinColumn(name = "cod_estado")
    private EstadoHabitacionEntity estadoHabitacionEntity;

    public long getCodigo_habitacion() {
        return codigo_habitacion;
    }

    public void setCodigo_habitacion(long codigo_habitacion) {
        this.codigo_habitacion = codigo_habitacion;
    }

    public long getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(long num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public TipoHabitacionEntity getTipoHabitacionEntity() {
        return tipoHabitacionEntity;
    }

    public void setTipoHabitacionEntity(TipoHabitacionEntity tipoHabitacionEntity) {
        this.tipoHabitacionEntity = tipoHabitacionEntity;
    }

    public EstadoHabitacionEntity getEstadoHabitacionEntity() {
        return estadoHabitacionEntity;
    }

    public void setEstadoHabitacionEntity(EstadoHabitacionEntity estadoHabitacionEntity) {
        this.estadoHabitacionEntity = estadoHabitacionEntity;
    }

}
