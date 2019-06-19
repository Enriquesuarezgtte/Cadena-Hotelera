/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.persistence;

import co.edu.konradlorenz.cadenahotelera.entities.TipoUsuarioEntity;
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
public class TipoUsuarioPersistence {

    @PersistenceContext(unitName = "reservasPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla tipoUsuario
     *
     * @return Lista de datos de la tabla tipoUsuario
     */
    public List<TipoUsuarioEntity> findAll() {
        Query todos = em.createQuery("select e from TipoUsuarioEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla tipoUsuario
     *
     * @param id que se desea buscar
     * @return tipoUsuario
     */
    public TipoUsuarioEntity find(Long id) {
        TipoUsuarioEntity tusuario = em.find(TipoUsuarioEntity.class, id);
        return tusuario;
    }

    /**
     * Creacion de un nuevo tipoUsuario
     *
     * @param tusuario
     * @return nuevo tipoUsuario creado
     */
    public TipoUsuarioEntity create(TipoUsuarioEntity tusuario) {
        em.persist(tusuario);
        return tusuario;
    }

    /**
     * Actualizacion de una tupla de la tabla tipoUsuario
     *
     * @param tusuarioActualizar
     * @return tipoUsuario actualizado
     */
    public TipoUsuarioEntity update(TipoUsuarioEntity tusuarioActualizar) {
        return em.merge(tusuarioActualizar);
    }

    /**
     * Elimina una tupla curso de la tabla tipoUsuario
     *
     * @param id
     */
    public void delete(Long id) {
        TipoUsuarioEntity tusuarioDelete = em.find(TipoUsuarioEntity.class, id);
        em.remove(tusuarioDelete);
    }
}
