(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/ciudades',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var nom_ciudad = $('<option>');
                nom_ciudad.attr('value', data[i].id).text(data[i].nom_ciudad);

                $('#listaCiudades select').append(nom_ciudad);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

})(jQuery);

