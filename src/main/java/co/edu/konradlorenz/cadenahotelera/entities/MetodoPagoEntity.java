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
public class MetodoPagoEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * llave primaria de la entidad metododepago
     */
    @Id
    @Column(name = "cod_f_pago", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * variable con el nombre de la forma de pago
     */
    @Column(name = "nom_f_pago", nullable = false)
    private String nom_f_pago;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_f_pago() {
        return nom_f_pago;
    }

    public void setNom_f_pago(String nom_f_pago) {
        this.nom_f_pago = nom_f_pago;
    }

}
