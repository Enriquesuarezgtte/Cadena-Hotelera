(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/usuarios',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                //Divisiones de  las filas
                var nom_usuario = $('<td>');
                nom_usuario.text(data[i].nom_usuario);
                var ape_usuario = $('<td>');
                ape_usuario.text(data[i].ape_usuario);
                var correo = $('<td>');
                correo.text(data[i].correo);
                var tiposUsuarioDTO = (data[i].tiposUsuarioDTO);
                var dat = data[i].tiposUsuarioDTO;
                var nom_t_usuario = $('<td>');
                nom_t_usuario.text(dat.nom_t_usuario);

                var ciudadDTO = (data[i].ciudadDTO);
                var nom_ciudad = $('<td>');
                nom_ciudad.text(ciudadDTO.nom_ciudad);
                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/entrega1/crearUsuario.html?id=' + data[i].id + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');
                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nom_usuario);
                tableRow.append(ape_usuario);
                tableRow.append(correo);
                tableRow.append(nom_t_usuario);
                tableRow.append(nom_ciudad);

                tableRow.append(acciones);

                $('#tablaUsuario table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        console.log($(this).attr('data-id'));
        $.ajax({
            url: '/entrega1/api/usuarios/' + $(this).attr('data-id'),

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

