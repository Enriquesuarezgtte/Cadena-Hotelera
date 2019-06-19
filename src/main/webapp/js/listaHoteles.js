(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/hoteles',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var carro = data;
                var hotel = $('<option>');
                hotel.attr('value', data[i].id).text(data[i].nom_hotel);
                console.log(carro[i]);
                $('#listaHoteles select').append(hotel);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
})(jQuery);


