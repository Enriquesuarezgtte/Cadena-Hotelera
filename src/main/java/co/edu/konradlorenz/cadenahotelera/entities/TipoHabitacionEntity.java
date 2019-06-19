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

/**
 *
 * @author jeison
 */
@Entity
public class TipoHabitacionEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * llave principal del tipo de habitacion
     */
    @Id
    @Column(name = "cod_t_habitacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * nombre del tipo de habitacion
     */
    @Column(name = "nom_t_habitacion", nullable = false)
    private String nom_t_habitacion;

    /**
     * precio del tipo de habitacion
     */
    @Column(name = "precio_t_habitacion")
    private double precio_t_habitacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
