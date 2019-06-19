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
            url: '/entrega1/api/habitaciones/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            var estadoHabitacion = data.estadoHabitacion;
            var hotel = data.hotel;
            var tipoHabitacion = data.tipoHabitacion;
            console.log(hotel);
            var num_habitacion = $('#num_habitacion').val(data.num_habitacion);
            var hotl = $('#hotel').val(data.hotel.nom_hotel);
            var id_hotel = data.hotel.id;
            var estadoHabitacin = $('#estadoHabitacion').val(data.estadoHabitacion.nom_estado);
            var id_estado_habitacion = data.estadoHabitacion.id;
            var tipoHabitacin = $('#tipoHabitacion').val(data.tipoHabitacion.nom_t_habitacion);
            var id_t_habitacion = data.tipoHabitacion.id;
            var idk = data.id;
            $('#botonCrear').text('Actualizar Habitacion').click(function (event) {
                var num_habitacion = $('#num_habitacion').val();
                var hote = $('#hotel').val();
                var estadoHabitacio = $('#estadoHabitacion').val();
                var tipoHabitacio = $('#tipoHabitacion').val();
                var id = data.id;
                estadoHabitacion.id = estadoHabitacio;
                estadoHabitacion.nom_estado = $('#estadoHabitacion').text();
                console.log(estadoHabitacion.nom_estado);
                hotel.id = hote;
                hotel.nom_hotel = $('#hotel').text();
                tipoHabitacion.id = tipoHabitacio;
                tipoHabitacion.nom_t_habitacion = $('#tipoHabitacion').text();
                $.ajax({
                    url: '/entrega1/api/habitaciones/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        num_habitacion: num_habitacion,
                        hotel: hotel,
                        estadoHabitacion: estadoHabitacion,
                        id: id,
                        tipoHabitacion: tipoHabitacion
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {

                    window.location.href = '/entrega1/mostrarHabitacion.html';
                }).fail(function (xhr, status, error) {

                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {

        $.ajax({
            url: '/entrega1/api/hoteles',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {

            for (var i = 0; i < data.length; i++)
            {
                //------------------------------------------

                $('#botonCrear').click(function (event) {
                    var num_habitacion = $('#num_habitacion').val();
                    uno = i;
                    var hote = data[0].id;
                    hote:$('#hotel').val();
                    console.log(hote);
                    var estadoHabitacio = $('#estadoHabitacion').val();
                    var tipoHabitacio = $('#tipoHabitacion').val();
                    var estadoHabitacion = new Object();
                    estadoHabitacion.id = estadoHabitacio;
                    estadoHabitacion.nom_estado = $('#estadoHabitacion').text();
                    var hotel = new Object();
                    var hot = new Object();

                    hotel.id = $('#hotel').val();
                    hotel.nom_hotel = $('#hotel').text();
                    ////////////////////////////////////////////////////////////////
                    var ciu = new Object();
                    console.log(data[0].id);
                    console.log(i);
                    var j = 0;
                    if (data[j].id === hote) {
                        hotel.ciudad = data[j].ciudad;
                        i = data[j].length + 1;
                        console.log(i);
                    }
                    j = j + 1;

                    var tipoHabitacion = new Object();
                    tipoHabitacion.id = tipoHabitacio;
                    tipoHabitacion.nom_t_habitacion = $('#tipoHabitacion').text();
                    ///*****************************
                    //
                    $.ajax({
                        url: '/entrega1/api/tipohabitacion',
                        method: 'GET',
                        contentType: 'application/json',
                        dataType: 'json'
                    }).done(function (da) {
                        for (var l = 0; l < da.length; l++) {
                            if (da[l].id == tipoHabitacio) {
                                tipoHabitacion.precio_t_habitacion = da[l].precio_t_habitacion;
                            }
                        }
                    }).fail(function (xhr, status, error) {
                        console.log(error);
                    });
                    console.log(tipoHabitacion);
                    ///**************************************************************************
                    $.ajax({
                        url: '/entrega1/api/estados',
                        method: 'GET',
                        contentType: 'application/json',
                        dataType: 'json'
                    }).done(function (data) {
                        for (var i = 0; i < data.length; i++) {

                            if (data[i].id == estadoHabitacio) {
                                estadoHabitacion = data[i];
                            }
                        }
                    }).fail(function (xhr, status, error) {
                        console.log(error);
                    });

                    ////*/*/*/*/*/*///*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/

                    console.log(estadoHabitacion);
                    console.log(hotel);
                    console.log(hotel.ciudad);
                    console.log(num_habitacion);
                    console.log(tipoHabitacion);

                    $.ajax({

                        url: '/entrega1/api/habitaciones',
                        contentType: 'application/json',
                        data: JSON.stringify({
                            estadoHabitacion: estadoHabitacion,
                            hotel: hotel,
                            id: 5,
                            num_habitacion: num_habitacion,
                            tipoHabitacion: tipoHabitacion

                        }),
                        method: 'POST',
                        dataType: 'json'
                    }).done(function (data) {
                        window.location.href = '/entrega1/mostrarHabitacion.html';
                    }).fail(function (xhr, status, error) {
                        console.log(error);
                    });
                }

                );
            }
        }
        ).fail(function (xhr, status, error) {
            console.log(error);
        });
    }
})(jQuery);


