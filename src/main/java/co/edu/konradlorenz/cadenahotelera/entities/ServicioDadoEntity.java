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
@Entity
public class ServicioDadoEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_servicio_dado", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cod_habitacion")
    private HabitacionEntity habitacionEntity;

    @ManyToOne
    @JoinColumn(name = "cod_servicio")
    private ServicioEntity servicioEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HabitacionEntity getHabitacionEntity() {
        return habitacionEntity;
    }

    public void setHabitacionEntity(HabitacionEntity habitacionEntity) {
        this.habitacionEntity = habitacionEntity;
    }

    public ServicioEntity getServicioEntity() {
        return servicioEntity;
    }

    public void setServicioEntity(ServicioEntity servicioEntity) {
        this.servicioEntity = servicioEntity;
    }

}
