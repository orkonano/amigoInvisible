/**
 * Created by orko on 13/02/14.
 */

$(function() {

    $("[data-action='aquienleregale']").click(function(e){
        e.preventDefault();
        if (!$(this).hasClass("ajaxRunning")){
            var url = $(this).data("url");
            var idPartida = $(this).data("id-partida");
            $.ajax({
                type: "POST",
                url: url,
                data:{"idPartida":idPartida},
                dataType: 'JSON',
                beforeSend: function(){
                    $(this).addClass("ajaxRunning");
                },
                success:function(data){
                   alert(data)
                },
                complete:function(){
                    $(this).removeClass("ajaxRunning");
                }
            });
        }
    });
});