<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <r:require module="partida" />
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
        <th>A quien le regalaste?</th>
        <th>Quiene Participaron?</th>
    </tr>
    </thead>
    <tbody>
    <g:if test="${!partidas.isEmpty()}">
        <g:each in="${partidas}" var="partida">
            <tr>
                <td>
                    ${partida.name}
                </td>
                <td>
                    ${partida.code}
                </td>
                <td>
                    <g:link data-action="aquienleregale"  data-url="${createLink(controller:'regalo',action: 'regaloPartida')}" data-id-partida="${partida.id}">Apretá acá</g:link>
                </td>
                <td>
                </td>
            </tr>
        </g:each>
    </g:if>
    </tbody>
</table>

</body>
</html>
