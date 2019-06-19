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
 * @author G1
 */
@Entity
public class CiudadEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * llave primaria del entity ciudad variable que captura el codigo de ciudad
     */
    @Id
    @Column(name = "cod_ciudad", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * variable que guarda el nombre de ciudad
     */
    @Column(name = "nom_ciudad", nullable = false)
    private String nom_ciudad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_ciudad() {
        return nom_ciudad;
    }

    public void setNom_ciudad(String nom_ciudad) {
        this.nom_ciudad = nom_ciudad;
    }

}
