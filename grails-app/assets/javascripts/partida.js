/**
 * Created by orko on 13/02/14.
 */

$(function() {

    $("[data-action='aquienleregale']").click(function(e){
        e.preventDefault();
        if (!$(this).hasClass("ajaxRunning")){
            var url = $(this).data("url");
            var idPartida = $(this).data("id-partida");
            var index = $(this).data("index");
                $.ajax({
                    type: "POST",
                    url: url,
                    data:{"idPartida":idPartida},
                    dataType: 'JSON',
                    beforeSend: function(){
                        $(this).addClass("ajaxRunning");
                    },
                    success:function(data){
                        //$(this).data('title',data.amigoTo);
                        $("#tooltip_"+index).tooltip({ placement: 'right',title:data.amigoTo});
                        $("#tooltip_"+index).tooltip('show');
                       // $('#myModal').modal('show');
                    },
                    complete:function(){
                        $(this).removeClass("ajaxRunning");
                    }
                });
        }
    });
});