/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konradlorenz.cadenahotelera.resources;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Registra el inventario de todos los recursos de la aplicacion
 *
 * @author Enrique Suarez
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.CiudadResource.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.EstadoHabitacionResource.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.HabitacionResource.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.HotelResource.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.MetodoPagoResources.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.ReservaResource.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.ServicioDadoResources.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.ServicioResources.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.TipoHabitacionResources.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.TipoUsuarioResources.class);
        resources.add(co.edu.konradlorenz.cadenahotelera.resources.UsuarioResources.class);
    }
}
