/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.MetodoPagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G1
 */
public class MetodoPagoDTO {

    private Long id;
    private String nom_f_pago;

    public MetodoPagoDTO() {
    }

    public MetodoPagoDTO(MetodoPagoEntity metodoPagoEntity) {

        this.id = metodoPagoEntity.getId();
        this.nom_f_pago = metodoPagoEntity.getNom_f_pago();

    }

    public MetodoPagoEntity toEntity() {
        MetodoPagoEntity metodoPagoEntity = new MetodoPagoEntity();
        metodoPagoEntity.setId(id);
        metodoPagoEntity.setNom_f_pago(nom_f_pago);
        return metodoPagoEntity;

    }

    public static List<MetodoPagoDTO> toMetodoPagoList(List<MetodoPagoEntity> metodoPagoEntitys) {
        List<MetodoPagoDTO> metodoPagoDTOs = new ArrayList<>();
        for (int i = 0; i < metodoPagoEntitys.size(); i++) {
            metodoPagoDTOs.add(new MetodoPagoDTO(metodoPagoEntitys.get(i)));
        }
        return metodoPagoDTOs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_f_pago() {
        return nom_f_pago;
    }

    public void setNom_f_pago(String nom_f_pago) {
        this.nom_f_pago = nom_f_pago;
    }

}
