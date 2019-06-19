(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/habitaciones',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                //Divisiones de  las filas
                var num_habitacion = $('<td>');
                num_habitacion.text(data[i].num_habitacion);

                var hotel = (data[i].hotel);
                var dat = data[i].hotel;
                var nom_hotel = $('<td>');
                nom_hotel.text(dat.nom_hotel);

                var tipoHabitacion = (data[i].tipoHabitacion);
                var nom_t_habitacion = $('<td>');
                nom_t_habitacion.text(tipoHabitacion.nom_t_habitacion);

                var estadoHabitacion = (data[i].estadoHabitacion);
                var nom_estado = $('<td>');
                nom_estado.text(estadoHabitacion.nom_estado);

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/entrega1/crearHabitacion.html?id=' + data[i].id + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');
                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(num_habitacion);
                tableRow.append(nom_hotel);
                tableRow.append(nom_t_habitacion);
                tableRow.append(nom_estado);

                tableRow.append(acciones);

                $('#tablaHabitacion table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        console.log($(this).attr('data-id'));
        $.ajax({
            url: '/entrega1/api/habitaciones/' + $(this).attr('data-id'),

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

