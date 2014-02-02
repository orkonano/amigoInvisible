<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
	<!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title><g:layoutTitle default="Amigo Invisible" /></title>
		<g:layoutHead />
		<r:layoutResources />
	</head>
	<body>
		<div class="container">
            <sec:ifLoggedIn>
                Hola <sec:username/>!
                <g:remoteLink class="btn btn-default btn-xs" controller="logout" onSuccess="window.location.assign(${createLinkTo(dir: '/')})">Salir</g:remoteLink>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <g:link controller='login' action='auth' class="btn btn-default btn-xs">Entrar</g:link>
            </sec:ifNotLoggedIn>
			<div class="jumbotron">
				<div class="container">
					<h1>El amigo invisible</h1>
				</div>
			</div>
			<g:layoutBody />
		</div>
		<r:layoutResources />
	</body>
</html>
