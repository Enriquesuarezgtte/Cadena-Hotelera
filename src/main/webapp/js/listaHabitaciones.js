(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/habitaciones',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var num_habitacion = $('<option>');
                num_habitacion.attr('value', data[i].id).text(data[i].num_habitacion);

                $('#listaHabitaciones select').append(num_habitacion);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

})(jQuery);



