<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'amigoInvisible.label', default: 'AmigoInvisible')}"/>
    <r:require module="amigoInvisible" />
</head>

<body>

<g:hasErrors bean="${amigoInvisible}">
	<div class="alert alert-danger">
		<g:renderErrors bean="${amigoInvisible}" />
	</div>
</g:hasErrors>

<g:form  name="amigoInvisibleForm" url="[resource:amigoInvisibleCommandInstance ,controller:'amigoInvisible',action:'generarAmigoInvisible']" >
	<div class="form-group">
		<label for="partida.name">Ingrese un nombre para identificar</label>
    	<input type="text" class="form-control" id="partida.name" name="partida.name" placeholder="Ingrese un nombre" required value="${amigoInvisible.partida.name}">
	</div>	
	<div class="form-group">
	    <table id="tablaAmigoInvisible" class="table table-striped">
	        <thead>
	            <tr>
	                <th>Nombre</th>
	                <th>email</th>
	                <th><button type="button" class="btn btn-link" id="agregarBoton"><span class="glyphicon glyphicon-plus"></span> Agregar</button></th>
	            </tr>
	        </thead>
	         <tbody>
	            <g:if test="${!amigoInvisible?.amigosACalcular.isEmpty()}">
	                  <g:each in="${amigoInvisible.amigosACalcular}" var="amigo">
	                      <tr>
	                          <td>
	                              <g:textField name="nombre" required="" class="form-control" value="${amigo.nombre}"/>
	                          </td>
	                          <td>
	                             <g:field type="email" name="email" required="" class="form-control"  value="${amigo.email}"/>
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
    </div>
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
