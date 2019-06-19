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

    /**
     * nombre_servicio
     * costo
     */
    if (getUrlParameter('id')) {
        $.ajax({
            url: '/entrega1/api/servicios/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nom_servicio = $('#nombre_servicio').val(data.nom_servicio);
            var costo = $('#costo').val(data.costo);

            var id = data.id;
            $('#botonCrear').text('Actualizar Servicios').click(function (event) {
                var nom_servicio = $('#nom_servicio').val();
                var costo = $('#costo').val();

                $.ajax({
                    url: '/entrega1/api/servicios/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nom_servicio: nom_servicio,
                        costo: costo,
                        id: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/entrega1/mostrarServicio.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nom_servicio = $('#nom_servicio').val();
            var costo = $('#costo').val();

            $.ajax({
                url: '/entrega1/api/servicios',
                contentType: 'application/json',
                data: JSON.stringify({

                    nom_servicio: nom_servicio,
                    costo: costo,
                    id: 1
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/entrega1/mostrarServicio.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);