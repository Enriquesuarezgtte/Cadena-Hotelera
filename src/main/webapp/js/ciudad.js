(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/ciudades',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                //Divisiones de  las filas
                var nom_ciudad = $('<td>');
                nom_ciudad.text(data[i].nom_ciudad);

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/entrega1/crearCiudad.html?id=' + data[i].id + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');
                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nom_ciudad);

                tableRow.append(acciones);

                $('#tablaCiudad table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        console.log($(this).attr('data-id'));
        $.ajax({
            url: '/entrega1/api/ciudades/' + $(this).attr('data-id'),

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

