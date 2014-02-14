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
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">
                            <sec:ifNotLoggedIn>Amigos</sec:ifNotLoggedIn>
                            <sec:ifLoggedIn>Hola <sec:username/>!</sec:ifLoggedIn>
                        </a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <sec:ifNotLoggedIn>
                            <li><g:link controller='login' action='auth'>Entrar</g:link></li>
                            </sec:ifNotLoggedIn>
                            <sec:ifLoggedIn>
                                <li><g:link controller="partida" action="partidas">Tus Partidas</g:link>
                                <li><g:link data-action="logout" data-url-logout="${createLink(controller:'logout')}" data-url-redirect="${createLinkTo(dir: '/')}">Salir</g:link>
                            </sec:ifLoggedIn>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>





            </nav>

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
