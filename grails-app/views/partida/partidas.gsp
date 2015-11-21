<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>

<div class="alert">
    <h3>Listado de todas las partidas en las que participó</h3>
</div>

<table id="tablaAmigoInvisible" class="table table-striped">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Código</th>
        <th>A qui&eacute;n le regalaste?</th>
    </tr>
    </thead>
    <tbody>
    <g:if test="${!partidas.isEmpty()}">
        <g:each  status="i" in="${partidas}" var="partida">
            <tr>
                <td>
                    ${partida.name}
                </td>
                <td>
                    ${partida.code}
                </td>
                <td>
                    <span data-action="aquienleregale" data-index="${i}"  data-url="${createLink(controller:'regalo',action: 'regaloPartida')}" data-id-partida="${partida.id}" class="glyphicon glyphicon-user" id="tooltip_${i}"></span>
                </td>
            </tr>
        </g:each>
    </g:if>
    </tbody>
</table>


<div  class="tooltip top">
        <div class="tooltip-inner">
          Some tooltip text!
        </div>
        <div class="tooltip-arrow"></div>
   </div>

</body>
</html>
