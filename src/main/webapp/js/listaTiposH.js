(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/tipohabitacion',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {

                var nom_t_habitacion = $('<option>');
                nom_t_habitacion.attr('value', data[i].id).text(data[i].nom_t_habitacion);

                $('#listaTiposH select').append(nom_t_habitacion);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
})(jQuery);

