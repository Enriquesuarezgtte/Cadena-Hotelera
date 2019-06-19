(function ($) {
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageUrl = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageUrl.split('&'),
                sParameterName,
                i;
        for (var i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };

    if (getUrlParameter('id')) {
        $.ajax({
            url: '/entrega1/api/metodopago/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nom_f_pago = $('#nom_f_pago').val(data.nom_f_pago);

            var id = data.id;
            $('#botonCrear').text('Actualizar Metodo Pago').click(function (event) {
                var nom_f_pago = $('#nom_f_pago').val();
                $.ajax({
                    url: '/entrega1/api/metodopago/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nom_f_pago: nom_f_pago,
                        id: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/entrega1/mostrarMetodoPago.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nom_f_pago = $('#nom_f_pago').val();

            $.ajax({
                url: '/entrega1/api/metodopago',
                contentType: 'application/json',
                data: JSON.stringify({

                    nom_f_pago: nom_f_pago,
                    id: 1
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/entrega1/mostrarMetodoPago.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);