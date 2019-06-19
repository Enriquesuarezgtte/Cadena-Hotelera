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
            url: '/entrega1/api/ciudades/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nom_ciudad = $('#nom_ciudad').val(data.nom_ciudad);
            var id = data.id;
            $('#botonCrear').text('Actualizar Estado').click(function (event) {
                var nom_ciudad = $('#nom_ciudad').val();

                $.ajax({
                    url: '/entrega1/api/ciudades/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nom_ciudad: nom_ciudad,
                        id: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/entrega1/mostrarCiudad.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nom_ciudad = $('#nom_ciudad').val();

            $.ajax({

                url: '/entrega1/api/ciudades',
                contentType: 'application/json',
                data: JSON.stringify({

                    nom_ciudad: nom_ciudad,
                    id: 1
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/entrega1/mostrarCiudad.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);