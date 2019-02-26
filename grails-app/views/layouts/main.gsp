<!DOCTYPE html>
<html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<asset:javascript src="jquery-3.2.1.min.js"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		<title><g:layoutTitle default="VrkConnector"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<asset:stylesheet src="main.css"/>
		<g:layoutHead/>
	</head>
	<body>
		<div id="content">
			<g:if test="${ session.getAttribute('authed') }">
				<a href="${ createLink(controller: 'login', action: 'logout') }">Logout</a>
			</g:if>
			<g:layoutBody/>
		</div>
	</body>
</html>
