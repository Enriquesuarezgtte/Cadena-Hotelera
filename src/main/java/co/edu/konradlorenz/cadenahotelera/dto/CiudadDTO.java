/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G1
 *
 */
public class CiudadDTO {

    private Long id;
    private String nom_ciudad;

    public CiudadDTO() {
    }

    public CiudadDTO(CiudadEntity ciudadEntity) {
        this.id = ciudadEntity.getId();
        this.nom_ciudad = ciudadEntity.getNom_ciudad();
    }

    public CiudadEntity toEntity() {
        CiudadEntity ciudadEntity = new CiudadEntity();
        ciudadEntity.setId(this.id);
        ciudadEntity.setNom_ciudad(this.nom_ciudad);
        return ciudadEntity;
    }

    public List<CiudadDTO> toCiudadList(List<CiudadEntity> ciudadList) {
        List<CiudadDTO> listaCiudadDTO = new ArrayList<>();
        for (int i = 0; i < ciudadList.size(); i++) {
            listaCiudadDTO.add(new CiudadDTO(ciudadList.get(i)));
        }
        return listaCiudadDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_ciudad() {
        return nom_ciudad;
    }

    public void setNom_ciudad(String nom_ciudad) {
        this.nom_ciudad = nom_ciudad;
    }

}
