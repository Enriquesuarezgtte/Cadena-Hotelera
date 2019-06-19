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
            url: '/entrega1/api/usuarios/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var ciudadDO = data.ciudadDTO;
            var tiposUsuarioDT = data.tiposUsuarioDTO;

            var nom_usuario = $('#nom_usuario').val(data.nom_usuario);
            var correo = $('#correo').val(data.correo);
            var ape_usuario = $('#ape_usuario').val(data.ape_usuario);
            var tip_usuario = $('#tip_usuario').val(data.tiposUsuarioDTO.nom_t_usuario);
            var id_tipo_usuario = data.tiposUsuarioDTO.id;
            var ciu_usuario = $('#ciu_usuario').val(data.ciudadDTO.nom_ciudad);
            var id_ciu_usuario = data.ciudadDTO.id;
            var idk = data.id;


            $('#botonCrear').text('Actualizar Usuario').click(function (event) {



                var nom_usuario = $('#nom_usuario').val();

                var ape_usuario = $('#ape_usuario').val();
                var correo = $('#correo').val();
                var tip_usuario = $('#ti_usuario').val();
                var id_usuario = $('#ci_usuario').val();

                var id = data.id;
                ciudadDO.id = id_usuario;
                ciudadDO.nom_ciudad = $('#ci_usuario').text();

                tiposUsuarioDT.id = tip_usuario;
                tiposUsuarioDT.nom_t_usuario = $('#ti_usuario').text();

                $.ajax({
                    url: '/entrega1/api/usuarios/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        ape_usuario: ape_usuario,
                        ciudadDTO: ciudadDO,
                        correo: correo,
                        id: idk,
                        nom_usuario: nom_usuario,
                        tiposUsuarioDTO: tiposUsuarioDT
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {

                    window.location.href = '/entrega1/mostrarUsuario.html';
                }).fail(function (xhr, status, error) {

                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {

        $('#botonCrear').click(function (event) {
            var nom_usuario = $('#nom_usuario').val();

            var ape_usuario = $('#ape_usuario').val();
            var correo = $('#correo').val();
            var tip_usuario = $('#ti_usuario').val();
            var id_usuario = $('#ci_usuario').val();
            ciudadDO = new Object();

            ciudadDO.id = id_usuario;
            ciudadDO.nom_ciudad = $('#ci_usuario').text();
            tiposUsuarioDT = new Object();
            tiposUsuarioDT.id = tip_usuario;
            tiposUsuarioDT.nom_t_usuario = $('#ti_usuario').text();

            $.ajax({

                url: '/entrega1/api/usuarios',
                contentType: 'application/json',
                data: JSON.stringify({

                    ape_usuario: ape_usuario,
                    ciudadDTO: ciudadDO,
                    correo: correo,
                    nom_usuario: nom_usuario,
                    tiposUsuarioDTO: tiposUsuarioDT,
                    id: 1
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/entrega1/mostrarUsuario.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);