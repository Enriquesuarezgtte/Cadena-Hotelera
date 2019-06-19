/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.ServicioDadoEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.ServicioDadoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author EnriqueS
 */
@Stateless
public class ServicioDadoLogic {

    /**
     * Inyeccion del persistence de ServicioDado
     */
    @Inject
    private ServicioDadoPersistence servicioDadoPersistence;

    /**
     * Metodo para obtener los serviciosDados
     *
     * @return
     */
    public List<ServicioDadoEntity> obtenerServicios() {
        List<ServicioDadoEntity> serviciosDados = servicioDadoPersistence.findAll();
        return serviciosDados;
    }

    /**
     * Metodo para obtener un servicio dado
     *
     * @param id
     * @return servicioDado encontrado
     */
    public ServicioDadoEntity obtenerServicioDado(Long id) {
        ServicioDadoEntity servicioDado = servicioDadoPersistence.find(id);
        if (servicioDado == null) {
            throw new IllegalArgumentException("Servicio dado no encontrado");
        }
        return servicioDado;
    }

    /*
    Metodo para crear un Servicio dado
     */
    public ServicioDadoEntity crearServicioDado(ServicioDadoEntity servicioDadoEntity) {
        servicioDadoPersistence.create(servicioDadoEntity);
        return servicioDadoEntity;
    }

    /**
     * Actualizar un servicioDado
     *
     * @param id
     * @param servicioDadoEntity
     * @return
     */
    public ServicioDadoEntity actualizarServicioDado(Long id, ServicioDadoEntity servicioDadoEntity) {
        ServicioDadoEntity servicioDdo = servicioDadoPersistence.update(servicioDadoEntity);
        return servicioDadoEntity;
    }

    /**
     * Metodo para eliminar un servicioDado
     *
     * @param id
     */
    public void eliminarServicioDado(Long id) {
        servicioDadoPersistence.delete(id);
    }
}
