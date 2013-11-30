/**
 * Created with IntelliJ IDEA.
 * User: orko
 * Date: 30/11/13
 * Time: 12:08
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function(){

    $(document).on("click",".eliminarBoton",function(e){
        e.preventDefault();
        var count = $("#tablaAmigoInvisible tbody").children().size();
        if (count == 1){
            alert("No se puede eliminar, hay solo uno");
            return;
        }else{
            $(this).parent().parent().remove();
        }
    });

    $("#agregarBoton").on("click",function(e){
    	var template = $('#nuevas-filas').html();
    	var html = Mustache.render(template, null);
        $("#tablaAmigoInvisible tbody").append(html);
    });

    $("form").submit(function(){
        var form = $(this);
        var count = 0;
        $("input[name='nombre']").each(function(){
            var value = $(this).val();
            $(this).attr("name",'amigosACalcular['+count+'].nombre');
            count++;
        });
        count = 0;
        $("input[name='email']").each(function(){
            var value = $(this).val();
            $(this).attr("name",'amigosACalcular['+count+'].email');
            count++
        });
    })

});
