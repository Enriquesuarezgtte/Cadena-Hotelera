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
            url: '/entrega1/api/estados/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nom_estado = $('#nom_estado').val(data.nom_estado);
            var id = data.id;
            $('#botonCrear').text('Actualizar Estado').click(function (event) {
                var nom_estado = $('#nom_estado').val();

                $.ajax({
                    url: '/entrega1/api/estados/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nom_estado: nom_estado,
                        id: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/entrega1/mostrarEstado.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nom_estado = $('#nom_estado').val();
            $.ajax({

                url: '/entrega1/api/estados',
                contentType: 'application/json',
                data: JSON.stringify({

                    nom_estado: nom_estado,
                    id: 1
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/entrega1/mostrarEstado.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);