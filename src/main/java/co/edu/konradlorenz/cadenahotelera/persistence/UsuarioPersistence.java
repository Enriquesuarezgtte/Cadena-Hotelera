
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.UsuarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jeison
 */
@Stateless
public class UsuarioPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla usuario
     *
     * @return Lista de datos de la tabla usuario
     */
    public List<UsuarioEntity> findAll() {
        Query todos = em.createQuery("select e from UsuarioEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla usuario
     *
     * @param id que se desea buscar
     * @return cursoEntity
     */
    public UsuarioEntity find(Long id) {
        UsuarioEntity usuario = em.find(UsuarioEntity.class, id);
        return usuario;
    }

    /**
     * Creacion de un nuevo usuario
     *
     * @param usuario
     * @return nuevo usuario creado
     */
    public UsuarioEntity create(UsuarioEntity usuario) {
        em.persist(usuario);
        return usuario;
    }

    /**
     * Actualizacion de una tupla de la tabla servicio
     *
     * @param usuarioEntity
     * @return sercvicio actualizado
     */
    public UsuarioEntity update(UsuarioEntity usuarioEntity) {
        return em.merge(usuarioEntity);
    }

    /**
     * Elimina una tupla curso de la tabla servicio
     *
     * @param id
     */
    public void delete(Long id) {
        UsuarioEntity servicioDelete = em.find(UsuarioEntity.class, id);
        em.remove(servicioDelete);
    }
}
