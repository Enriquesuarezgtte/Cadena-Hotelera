/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.EstadoHabitacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CISCO
 */
public class EstadoHabitacionDTO {

    private Long id;

    private String nom_estado;

    public EstadoHabitacionDTO() {
    }

    public EstadoHabitacionDTO(EstadoHabitacionEntity estadoHabitacionEntity) {
        this.id = estadoHabitacionEntity.getId();
        this.nom_estado = estadoHabitacionEntity.getNom_estado();

    }

    public EstadoHabitacionEntity toEntity() {
        EstadoHabitacionEntity estadoHabitacionEntity = new EstadoHabitacionEntity();
        estadoHabitacionEntity.setId(this.id);
        estadoHabitacionEntity.setNom_estado(this.nom_estado);

        return estadoHabitacionEntity;

    }

    public List<EstadoHabitacionDTO> toEstudianteHabitacionList(List<EstadoHabitacionEntity> estudianteEstadoList) {
        List<EstadoHabitacionDTO> listaEstadoHabitacionDTOs = new ArrayList<>();

        for (int i = 0; i < estudianteEstadoList.size(); i++) {

            listaEstadoHabitacionDTOs.add(new EstadoHabitacionDTO(estudianteEstadoList.get(i)));

        }
        return listaEstadoHabitacionDTOs;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_estado() {
        return nom_estado;
    }

    public void setNom_estado(String nom_estado) {
        this.nom_estado = nom_estado;
    }

}
