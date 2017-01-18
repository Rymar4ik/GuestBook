//Валидация проходит с помощью встроенных возможностей HTML5 и оформляется с помощью Bootstrap
//При неудачной валидации заменяй значек и цвет рамки на красный, при удачной на зеленый.

$(function() {
    $('#send').click(function(e) {
        var formValid = true;
        $('input').each(function() {
            var formGroup = $(this).parents('.form-group');
            var glyphicon = formGroup.find('.form-control-feedback');
            if (this.checkValidity()) {
                formGroup.addClass('has-success').removeClass('has-error');
                glyphicon.addClass('glyphicon-ok').removeClass('glyphicon-remove');
            } else {
                formGroup.addClass('has-error').removeClass('has-success');
                glyphicon.addClass('glyphicon-remove').removeClass('glyphicon-ok');
                formValid = false;
            }
        });
        if (formValid) {
            $('#success-alert').removeClass('hidden');
            e.preventDefault();

            setTimeout(function () {
                $('#main-form').submit(); //
            }, 2500);
        }
    });
});
