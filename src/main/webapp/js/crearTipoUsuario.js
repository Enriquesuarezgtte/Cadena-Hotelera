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
            url: '/entrega1/api/tipousuarios/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nom_t_usuario = $('#nom_t_usuario').val(data.nom_t_usuario);

            var id = data.id;
            $('#botonCrear').text('Actualizar Tipos de Usuario').click(function (event) {
                var nom_t_usuario = $('#nom_t_usuario').val();
                $.ajax({
                    url: '/entrega1/api/tipousuarios/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nom_t_usuario: nom_t_usuario,
                        id: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/entrega1/mostrarTipoUsuario.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nom_t_usuario = $('#nom_t_usuario').val();


            $.ajax({
                url: '/entrega1/api/tipousuarios',
                contentType: 'application/json',
                data: JSON.stringify({
                    nom_t_usuario: nom_t_usuario,
                    id: 1
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/entrega1/mostrarTipoUsuario.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);