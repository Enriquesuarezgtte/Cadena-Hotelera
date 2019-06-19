(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/usuarios',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var nom_usuario = $('<option>');
                nom_usuario.attr('value', data[i].id).text(data[i].nom_usuario);

                $('#listaUsuarios select').append(nom_usuario);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

})(jQuery);