(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/hoteles',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                //Divisiones de  las filas
                var ciudad = (data[i].ciudad);
                var nom_hotel = $('<td>');
                nom_hotel.text(data[i].nom_hotel);

                var num_habitaciones = $('<td>');
                num_habitaciones.text(data[i].num_habitaciones);
                var val_estrellas = $('<td>');
                val_estrellas.text(data[i].val_estrellas);



                var nom_ciudad = $('<td>');
                nom_ciudad.text(ciudad.nom_ciudad);
                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/entrega1/crearHotel.html?id=' + data[i].id + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');
                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nom_hotel);
                tableRow.append(num_habitaciones);
                tableRow.append(nom_ciudad);
                tableRow.append(val_estrellas);

                tableRow.append(acciones);

                $('#tablaHotel table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        console.log($(this).attr('data-id'));
        $.ajax({
            url: '/entrega1/api/hoteles/' + $(this).attr('data-id'),

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

