/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.TipoUsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeison
 */
public class TiposUsuarioDTO {

    private Long id;

    private String nom_t_usuario;

    /**
     * Constructor por defecto
     */
    public TiposUsuarioDTO() {
    }

    public TiposUsuarioDTO(TipoUsuarioEntity tipoUsuarioEntity) {
        this.id = tipoUsuarioEntity.getId();
        this.nom_t_usuario = tipoUsuarioEntity.getNom_t_usuario();

    }

    /**
     * Metodo que realiza la conversión de objeto a entidad
     *
     * @return entidad
     */
    public TipoUsuarioEntity toEntity() {
        TipoUsuarioEntity tipoUsuarioEntity = new TipoUsuarioEntity();
        tipoUsuarioEntity.setCodido_tipo_usuario(this.id);
        tipoUsuarioEntity.setNom_t_usuario(this.nom_t_usuario);
        return tipoUsuarioEntity;
    }

    public List<TiposUsuarioDTO> toTipoUsuarioList(List<TipoUsuarioEntity> tipoUsuarioEntitys) {
        List<TiposUsuarioDTO> tiposUsuarioDTOs = new ArrayList<>();

        for (int i = 0; i < tipoUsuarioEntitys.size(); i++) {

            tiposUsuarioDTOs.add(new TiposUsuarioDTO(tipoUsuarioEntitys.get(i)));

        }
        return tiposUsuarioDTOs;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_t_usuario() {
        return nom_t_usuario;
    }

    public void setNom_t_usuario(String nom_t_usuario) {
        this.nom_t_usuario = nom_t_usuario;
    }

}
