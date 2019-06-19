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
 * @author G1
 */
/**
 */
@Entity
public class ReservaEntity implements Serializable {

    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private final static long serialVersionUID = 1L;

    /**
     * Llave primaria de la entidad Reserva
     */
    @Id
    @Column(name = "cod_reserva", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Atributo que maneja la relación con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private UsuarioEntity usuarioEntity;

    /**
     * Atributo que maneja la relación con la entidad Ciudad.
     */
    @ManyToOne
    @JoinColumn(name = "cod_ciudad")
    private CiudadEntity ciudadEntity;

    /**
     * Atributo que maneja la relación con la entidad Hotel.
     */
    @ManyToOne
    @JoinColumn(name = "cod_hotel")
    private HotelEntity hotelEntity;

    /**
     * Atributo que maneja la relación con la entidad Habitación.
     */
    @ManyToOne
    @JoinColumn(name = "cod_habitacion")
    private HabitacionEntity habitacionEntity;

    /**
     * Atributo que maneja la relación con la entidad Método_Pago.
     */
    @ManyToOne
    @JoinColumn(name = "cod_f_pago")
    private MetodoPagoEntity metodoPagoEntity;

    /**
     * Variable que almacena la fecha de entrada del usuario.
     */
    @Column(name = "f_entrada", nullable = false)
    private String f_entrada;

    /**
     * Variable que almacena la fecha de salida del usuario.
     */
    @Column(name = "f_salida", nullable = false)
    private String f_salida;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getF_entrada() {
        return f_entrada;
    }

    public void setF_entrada(String f_entrada) {
        this.f_entrada = f_entrada;
    }

    public String getF_salida() {
        return f_salida;
    }

    public void setF_salida(String f_salida) {
        this.f_salida = f_salida;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CiudadEntity getCiudadEntity() {
        return ciudadEntity;
    }

    public void setCiudadEntity(CiudadEntity ciudadEntity) {
        this.ciudadEntity = ciudadEntity;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public HabitacionEntity getHabitacionEntity() {
        return habitacionEntity;
    }

    public void setHabitacionEntity(HabitacionEntity habitacionEntity) {
        this.habitacionEntity = habitacionEntity;
    }

    public MetodoPagoEntity getMetodoPagoEntity() {
        return metodoPagoEntity;
    }

    public void setMetodoPagoEntity(MetodoPagoEntity metodoPagoEntity) {
        this.metodoPagoEntity = metodoPagoEntity;
    }

}
