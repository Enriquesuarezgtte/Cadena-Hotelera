/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.logic;

import co.edu.konradlorenz.cadenahotelera.entities.MetodoPagoEntity;
import co.edu.konradlorenz.cadenahotelera.persistence.MetodoPagoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author EnriqueS
 */
@Stateless
public class MetodoPagoLogic {

    /**
     * Inyeccion del persistence del metodo de pago
     */
    @Inject
    private MetodoPagoPersistence metodoPagoPersistence;

    /**
     * Obtener lista de metodos de pago
     *
     * @return
     */
    public List<MetodoPagoEntity> obtenerMetodosPago() {
        List<MetodoPagoEntity> metodos = metodoPagoPersistence.findAll();
        return metodos;
    }

    /**
     * Obtener metodo de pago por id
     *
     * @param id
     * @return metodo de pago encontrado
     */
    public MetodoPagoEntity obtenerMetodoPago(Long id) {
        MetodoPagoEntity metodoPagoEntity = metodoPagoPersistence.find(id);
        if (metodoPagoEntity == null) {
            throw new IllegalArgumentException("Metodo de pago solicitado no existe");
        }

        return metodoPagoEntity;
    }

    /**
     * Metodo para crear un nuevo metodo de pago
     *
     * @param metodoPagoEntity
     * @return metodo de pago creado
     */
    public MetodoPagoEntity crearMetodoPago(MetodoPagoEntity metodoPagoEntity) {
        metodoPagoPersistence.create(metodoPagoEntity);
        return metodoPagoEntity;
    }

    /**
     * Metodo para actualizar un metodo de pago
     *
     * @param id
     * @param metodoPagoEntity
     * @return
     */
    public MetodoPagoEntity actualizarMetodoPago(Long id, MetodoPagoEntity metodoPagoEntity) {

        MetodoPagoEntity pagoEntity = metodoPagoPersistence.update(metodoPagoEntity);
        return pagoEntity;
    }

    /**
     * Elimina un metodo de pago
     *
     * @param id
     */
    public void eliminarMetodoPago(Long id) {
        metodoPagoPersistence.delete(id);
    }

}
