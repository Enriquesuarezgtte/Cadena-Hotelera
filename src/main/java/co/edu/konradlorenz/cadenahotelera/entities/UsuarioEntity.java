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
public class UsuarioEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * llave primaria del entity usuario variable que almacena el codigo del
     * usuario
     */
    @Id
    @Column(name = "cod_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cod_t_usuario")
    private TipoUsuarioEntity tipoUsuarioEntity;

    @ManyToOne
    @JoinColumn(name = "cod_ciudad")
    private CiudadEntity ciudadEntity;
    /**
     * variable que captura el nombre del usuario
     */
    @Column(name = "nom_usuario", nullable = false)
    private String nom_usuario;

    /**
     * variable que captura el apellido del usuario
     */
    @Column(name = "ape_usuario", nullable = false)
    private String ape_usuario;

    /**
     * variable que captura el correo del usuario
     */
    @Column(name = "correo", nullable = false)
    private String correo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getApe_usuario() {
        return ape_usuario;
    }

    public void setApe_usuario(String ape_usuario) {
        this.ape_usuario = ape_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoUsuarioEntity getTipoUsuarioEntity() {
        return tipoUsuarioEntity;
    }

    public void setTipoUsuarioEntity(TipoUsuarioEntity tipoUsuarioEntity) {
        this.tipoUsuarioEntity = tipoUsuarioEntity;
    }

    public CiudadEntity getCiudadEntity() {
        return ciudadEntity;
    }

    public void setCiudadEntity(CiudadEntity ciudadEntity) {
        this.ciudadEntity = ciudadEntity;
    }

}
/**
 * nom_usuario ape_usuario correo tip_usuario ciu_usuario
 */
