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
            url: '/entrega1/api/reserva/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);

            var usuario = data.usuario;
            var usuari = $('#usuarios').val(data.usuario.nom_usuario);
            var id_usuario = data.usuario.id;

            var ciudad = data.ciudad;
            var ciuda = $('#ci_usuario').val(data.ciudad.nom_ciudad);
            var id_ciudad = data.ciuadd.id;

            var hotel = data.hotel;
            var hote = $('#hotel').val(data.hotel.nom_hotel);
            var id_hotel = data.hotel.id;
            
            var habitacion = data.habitacion;
            var habitacio= $('#habitacion').val(data.habitacion.num_habitacion);
            var id_habitacion= data.habitacion.id;
            
            var metodoPago=data.metodoPago;
            var metodoPag = $('#metodoPago').val(data.metodoPago.nom_f_pago);
            var id_metodoPago = data.metodoPago.id;

            var f_entrada = data.f_entrada;
            var f_entrada =$('#f_entrada').val(data.f_entrada);
            var f_salida = data.f_salida;
            var f_salida =$('#f_salida').val(data.f_salida);
            

            var tipoHabitacion = data.tipoHabitacion;
            console.log(hotel);
            var num_habitacion = $('#num_habitacion').val(data.num_habitacion);

            var estadoHabitacin = $('#estadoHabitacion').val(data.estadoHabitacion.nom_estado);
            var id_estado_habitacion = data.estadoHabitacion.id;
            var tipoHabitacin = $('#tipoHabitacion').val(data.tipoHabitacion.nom_t_habitacion);
            var id_t_habitacion = data.tipoHabitacion.id;
            var idk = data.id;
            $('#botonCrear').text('Actualizar Habitacion').click(function (event) {
            
            var f_entrada =$('#f_entrada').val();
            var f_salida =$('#f_salida').val();
            var hote = $('#hotel').val();
            hotel.id = hote;
            hotel.nom_hotel = $('#hotel').text();
            var habitacio= $('#habitacion').val();
            var metodoPag = $('#metodoPago').val();
            var ciuda = $('#ci_usuario').val();
            var metodoPag = $('#metodoPago').val();
            habitacion.id=habitacio;
            habitacion.num_habitacion=$('#habitacion').text();
            ciudad.id=ciuda;
            ciudad.nom_ciudad= $('#ci_usuario').text();
            id=data.id;
            metodoPago.id=metodoPag;
            metodoPago.nom_f_pago = $('#metodoPago').text();
               
                $.ajax({
                    url: '/entrega1/api/reserva/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        f_entrada: f_entrada,
                        f_salida:f_salida,
                        usuario:usuario,
                        ciudad:ciudad,
                        habitacion:habitacion,
                        hotel: hotel,
                        id: id,
                        metodoPago: metodoPago
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {

                    window.location.href = '/entrega1/mostrarReserva.html';
                }).fail(function (xhr, status, error) {

                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {

        $.ajax({
            url: '/entrega1/api/reserva',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {


                $('#botonCrear').click(function (event) {
                    

                    $.ajax({

                        url: '/entrega1/api/reserva',
                        contentType: 'application/json',
                        data: JSON.stringify({
                            f_entrada: f_entrada,
                        f_salida:f_salida,
                        usuario:usuario,
                        ciudad:ciudad,
                        habitacion:habitacion,
                        hotel: hotel,
                        id: id,
                        metodoPago: metodoPago

                        }),
                        method: 'POST',
                        dataType: 'json'
                    }).done(function (data) {
                        window.location.href = '/entrega1/mostrarReserva.html';
                    }).fail(function (xhr, status, error) {
                        console.log(error);
                    });
                }

                );
            }
        
        ).fail(function (xhr, status, error) {
            console.log(error);
        });
    }
})(jQuery);

