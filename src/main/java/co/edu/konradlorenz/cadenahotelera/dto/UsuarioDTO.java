/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.dto;

import co.edu.konradlorenz.cadenahotelera.entities.CiudadEntity;
import co.edu.konradlorenz.cadenahotelera.entities.TipoUsuarioEntity;
import co.edu.konradlorenz.cadenahotelera.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeison
 */
public class UsuarioDTO {

    private Long id;

    private TiposUsuarioDTO tiposUsuarioDTO;

    private CiudadDTO ciudadDTO;

    private String nom_usuario;

    private String ape_usuario;

    private String correo;

    /**
     * Constructor por defecto
     */
    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        if (usuarioEntity.getCiudadEntity() != null) {
            this.ciudadDTO = new CiudadDTO(usuarioEntity.getCiudadEntity());
        }
        if (usuarioEntity.getTipoUsuarioEntity() != null) {
            this.tiposUsuarioDTO = new TiposUsuarioDTO(usuarioEntity.getTipoUsuarioEntity());
        }
        this.nom_usuario = usuarioEntity.getNom_usuario();
        this.ape_usuario = usuarioEntity.getApe_usuario();

        this.correo = usuarioEntity.getCorreo();
    }

    /**
     * Metodo que realiza la conversión de objeto a entidad
     *
     * @return entidad
     */
    public UsuarioEntity toEntity() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(this.id);
        if (this.tiposUsuarioDTO != null) {
            TipoUsuarioEntity tue = new TipoUsuarioEntity();
            tue.setCodido_tipo_usuario(this.tiposUsuarioDTO.getId());
            tue.setNom_t_usuario(tiposUsuarioDTO.getNom_t_usuario());
            usuarioEntity.setTipoUsuarioEntity(tue);
        }
        if (this.ciudadDTO != null) {
            CiudadEntity ce = new CiudadEntity();
            ce.setId(this.ciudadDTO.getId());
            ce.setNom_ciudad(this.ciudadDTO.getNom_ciudad());
            usuarioEntity.setCiudadEntity(ce);
        }
        usuarioEntity.setNom_usuario(this.nom_usuario);
        usuarioEntity.setApe_usuario(this.ape_usuario);
        usuarioEntity.setCorreo(this.correo);

        return usuarioEntity;
    }

    public List<UsuarioDTO> toUsuarioList(List<UsuarioEntity> usuarioEntitys) {
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (int i = 0; i < usuarioEntitys.size(); i++) {
            usuarioDTOs.add(new UsuarioDTO(usuarioEntitys.get(i)));

        }

        return usuarioDTOs;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setApe_usuario(String ApellidoUsuario) {
        this.ape_usuario = ApellidoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TiposUsuarioDTO getTiposUsuarioDTO() {
        return tiposUsuarioDTO;
    }

    public void setTiposUsuarioDTO(TiposUsuarioDTO tiposUsuarioDTO) {
        this.tiposUsuarioDTO = tiposUsuarioDTO;
    }

    public CiudadDTO getCiudadDTO() {
        return ciudadDTO;
    }

    public void setCiudadDTO(CiudadDTO ciudadDTO) {
        this.ciudadDTO = ciudadDTO;
    }

}
