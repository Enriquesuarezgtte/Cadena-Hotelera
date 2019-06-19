/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeison
 */
public class ServicioDTO {

    private Long id;

    private String nom_servicio;

    private Long costo;

    /**
     * Constructor por defecto
     */
    public ServicioDTO() {
    }

    public ServicioDTO(ServicioEntity servicioEntity) {
        this.id = servicioEntity.getId();
        this.nom_servicio = servicioEntity.getNom_servicio();
        this.costo = servicioEntity.getCosto();

    }

    /**
     * Metodo que realiza la conversión de objeto a entidad
     *
     * @return entidad
     */
    public ServicioEntity toEntity() {
        ServicioEntity servicioEntity = new ServicioEntity();
        servicioEntity.setId(this.id);
        servicioEntity.setNom_servicio(this.nom_servicio);
        servicioEntity.setCosto(this.costo);
        return servicioEntity;
    }

    public List<ServicioDTO> toServicioList(List<ServicioEntity> servicioEntitys) {

        List<ServicioDTO> servicioDTOs = new ArrayList<>();
        for (int i = 0; i < servicioEntitys.size(); i++) {
            servicioDTOs.add(new ServicioDTO(servicioEntitys.get(i)));
        }
        return servicioDTOs;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_servicio() {
        return nom_servicio;
    }

    public void setNom_servicio(String nom_servicio) {
        this.nom_servicio = nom_servicio;
    }

    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }

}
