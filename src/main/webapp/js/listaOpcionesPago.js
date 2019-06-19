(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/metodopago',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var nom_f_pago = $('<option>');
                nom_f_pago.attr('value', data[i].id).text(data[i].nom_f_pago);

                $('#listaOpcionesPago select').append(nom_f_pago);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

})(jQuery);

