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
public class EstadoHabitacionEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * llave principal de la entidad estadohabitacion
     */
    @Id
    @Column(name = "cod_estado", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * variable con nombre del estado
     */
    @Column(name = "nom_estado", nullable = false)
    private String nom_estado;

    public long getId() {
        return id;
    }

    public void setId(long codigo_estado) {
        this.id = codigo_estado;
    }

    public String getNom_estado() {
        return nom_estado;
    }

    public void setNom_estado(String nom_estado) {
        this.nom_estado = nom_estado;
    }

}
