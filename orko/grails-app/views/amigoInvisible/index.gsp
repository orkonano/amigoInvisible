<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'amigoInvisible.label', default: 'AmigoInvisible')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>



<g:form name="amigoInvisibleForm" url="[esource:amigoInvisibleCommandInstance ,controller:'amigoInvisible',action:'generarAmigoInvisible']">
    <table id="tablaAmigoInvisible" class="table table-striped">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>email</th>
                <th><button type="button" class="btn btn-link" id="agregarBoton"><span class="glyphicon glyphicon-plus"></span> Agregar</button></th>
            </tr>
        </thead>
         <tbody>
            <g:if test="${amigoInvisible.amigosACalcular != null && !amigoInvisible.amigosACalcular.isEmpty()}">
                  <g:each in="${amigoInvisible.amigosACalcular}" var="amigo">
                      <tr>
                          <td>
                              <g:textField name="nombre" required="" value="${amigo.nombre}"/>
                          </td>
                          <td>
                             <g:field type="email" name="email" required=""  value="${amigo.email}"/>
                          </td>
                          <td><button type="button" class="btn btn-danger eliminarBoton"><span class="glyphicon glyphicon-trash"></span> Eliminar</button></td>
                      </tr>
                  </g:each>
            </g:if>
             <g:else>
                 <tr>
                     <td><input type="text" name="nombre" class="form-control" required="" value="" id="nombre"></td>
					<td><input type="email" name="email" class="form-control" required="" value="" id="email"></td>
                     <td><button type="button" class="btn btn-danger eliminarBoton"><span class="glyphicon glyphicon-trash"></span>&nbsp;Eliminar</button></td>
                 </tr>
             </g:else>
         </tbody>
        <tfoot>
            <tr>
                <td COLSPAN="3">
                	<input type="submit" name="btn" value="Generar" class="btn btn-primary btn-block" >
                </td>
            </tr>
        </tfoot>
    </table>
</g:form>
<script id="nuevas-filas" type="text/html">
	<tr>
		<td><input type="text" name="nombre" class="form-control" required="" value="" id="nombre"></td>
		<td><input type="email" name="email" class="form-control" required="" value="" id="email"></td>
		<td><button type="button" class="btn btn-danger eliminarBoton"><span class="glyphicon glyphicon-trash"></span>&nbsp;Eliminar</button></td>
	</tr>
</script>
</body>

</html>
