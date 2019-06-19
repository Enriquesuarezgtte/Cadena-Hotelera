(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/servicios',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var nom_servicio = $('<option>');
                nom_servicio.attr('value', data[i].id).text(data[i].nom_servicio);

                $('#listaServicios select').append(nom_servicio);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

})(jQuery);


