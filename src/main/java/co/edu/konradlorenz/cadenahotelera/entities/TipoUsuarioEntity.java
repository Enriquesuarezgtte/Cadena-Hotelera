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
public class TipoUsuarioEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * llave primaria de la entidad tipo de usuario
     */
    @Id
    @Column(name = "cod_t_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * variable que almacena el nombre del tipo de usuario
     */
    @Column(name = "nom_t_usuario", nullable = false)
    private String nom_t_usuario;

    public long getId() {
        return id;
    }

    public void setCodido_tipo_usuario(long codido_tipo_usuario) {
        this.id = codido_tipo_usuario;
    }

    public String getNom_t_usuario() {
        return nom_t_usuario;
    }

    public void setNom_t_usuario(String nom_t_usuario) {
        this.nom_t_usuario = nom_t_usuario;
    }

}
