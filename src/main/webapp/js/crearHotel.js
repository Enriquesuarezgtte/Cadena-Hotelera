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
            url: '/entrega1/api/hoteles/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var ciudad = data.ciudad;

            var nom_hotel = $('#nom_hotel').val(data.nom_hotel);
            var num_habitaciones = $('#num_habitaciones').val(data.num_habitaciones);
            var val_estrellas = $('#val_estrellas').val(data.val_estrellas);

            var ciu_usuario = $('#ci_usuario').val(data.ciudad.nom_ciudad);
            var id_ciu_usuario = data.ciudad.id;
            var idk = data.id;


            $('#botonCrear').text('Actualizar Estado').click(function (event) {

                var nom_hotel = $('#nom_hotel').val();
                var num_habitaciones = $('#num_habitaciones').val();
                var val_estrellas = $('#val_estrellas').val();
                var id_usuario = $('#ci_usuario').val();

                var id = data.id;
                ciudad.id = id_usuario;
                ciudad.nom_ciudad = $('#ci_usuario').text();


                $.ajax({
                    url: '/entrega1/api/hoteles/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nom_hotel: nom_hotel,
                        num_habitaciones: num_habitaciones,
                        val_estrellas: val_estrellas,
                        id: id,
                        ciudad: ciudad
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    console.log(data);

                    window.location.href = '/entrega1/mostrarHotel.html';
                }).fail(function (xhr, status, error) {
                    console.log(data);
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {

        $('#botonCrear').click(function (event) {
            var nom_hotel = $('#nom_hotel').val();
            var num_habitaciones = $('#num_habitaciones').val();
            var val_estrellas = $('#val_estrellas').val();
            var id_usuario = $('#ci_usuario').val();
            ciudad = new Object();

            ciudad.id = id_usuario;
            ciudad.nom_ciudad = $('#ci_usuario').text();

            $.ajax({

                url: '/entrega1/api/hoteles',
                contentType: 'application/json',
                data: JSON.stringify({

                    nom_hotel: nom_hotel,
                    num_habitaciones: num_habitaciones,
                    val_estrellas: val_estrellas,
                    ciudad: ciudad,
                    id: 1
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/entrega1/index.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);