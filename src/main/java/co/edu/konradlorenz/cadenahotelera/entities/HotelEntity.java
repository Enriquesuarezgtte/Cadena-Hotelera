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
public class HotelEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * Llave primaria de la entidad hotel
     */
    @Id
    @Column(name = "cod_hotel", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Variable que almacena el nombre del hotel
     */
    @Column(name = "nom_hotel", nullable = false)
    private String nom_hotel;

    /**
     * Variable que contiene el numero de habitaciones
     */
    @Column(name = "num_habitaciones", nullable = false)
    private long num_habitaciones;

    /**
     * Variable que guarda la calificacion del hotel
     */
    @Column(name = "val_estrellas", nullable = false)
    private long val_estrellas;

    /**
     * Atributo que maneja la relación con la entidad Ciudad.
     */
    @ManyToOne
    @JoinColumn(name = "cod_ciudad")
    private CiudadEntity ciudadEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getVal_estrellas() {
        return val_estrellas;
    }

    public void setVal_estrellas(long val_estrellas) {
        this.val_estrellas = val_estrellas;
    }

    public CiudadEntity getCiudadEntity() {
        return ciudadEntity;
    }

    public void setCiudadEntity(CiudadEntity ciudadEntity) {
        this.ciudadEntity = ciudadEntity;
    }

}
