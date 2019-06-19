(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/entrega1/api/tipousuarios',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {

                //    <option value="audi">Audi</option>
                var nom_t_usuario = $('<option>');
                nom_t_usuario.attr('value', data[i].id).text(data[i].nom_t_usuario);

                $('#listaTipos select').append(nom_t_usuario);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
})(jQuery);

