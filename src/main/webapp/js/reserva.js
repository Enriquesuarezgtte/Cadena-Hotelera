(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/reserva',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                //Divisiones de  las filas
                /**
                 <th>Usuario</th>   
                 <th>Ciudad</th>   
                 <th>Hotel</th>   
                 <th>Habitacion</th>   
                 <th>Metodo de pago</th>
                 <th>fecha de reserva</th>  
                 <th>fecha de finalización</th>  
                 **/
                var usuario = data[i].usuario;
                var nom_usuario = $('<td>');
                nom_usuario.text(usuario.nom_usuario);
                var ciudad = (data[i].ciudad);
                var dat = data[i].hotel;
                var nom_ciudad = $('<td>');
                nom_ciudad.text(ciudad.nom_ciudad);

                var hotel = (data[i].hotel);
                var dat = data[i].hotel;
                var nom_hotel = $('<td>');
                nom_hotel.text(dat.nom_hotel);

                var habitacion = (data[i].habitacion);
                var num_habitacion = $('<td>');
                num_habitacion.text(habitacion.num_habitacion);

                var metodoPago = (data[i].metodoPago);
                var nom_f_pago = $('<td>');
                nom_f_pago.text(metodoPago.nom_f_pago);

                var f_entrada = $('<td>');
                f_entrada.text(data[i].f_entrada);

                var f_salida = $('<td>');
                f_salida.text(data[i].f_salida);

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/entrega1/crearReserva.html?id=' + data[i].id + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');
                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nom_usuario);
                tableRow.append(nom_ciudad);


                tableRow.append(nom_hotel);
                tableRow.append(num_habitacion);
                tableRow.append(nom_f_pago);
                tableRow.append(f_entrada);
                tableRow.append(f_salida);
                
                
                tableRow.append(acciones);

                $('#tablaReserva table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        console.log($(this).attr('data-id'));
        $.ajax({
            url: '/entrega1/api/reserva/' + $(this).attr('data-id'),

            method: ('DELETE'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log('eliminado correctamente');
            window.location.reload();
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    }
})(jQuery);




