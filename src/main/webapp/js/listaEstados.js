(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/estados',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {

                var nom_estado = $('<option>');
                nom_estado.attr('value', data[i].id).text(data[i].nom_estado);

                $('#listaEstados select').append(nom_estado);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
})(jQuery);

