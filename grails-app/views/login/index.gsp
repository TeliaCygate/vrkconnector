<html>
	<head>
		<meta name="layout" content="main"/>
		<asset:stylesheet src="login.css"/>
	</head>
	<body>
		<form id="login-form" name="loginForm" action="${ createLink(controller: 'login', action: 'auth') }" method="post">
			<div id="login-error" <g:if test="${ params.error || params.forbidden }">style="display: inline-block;"</g:if>>
				<ul>
					<g:if test="${ params.error }">
						<li>Authentication details are incorrect</li>
					</g:if>
					<g:if test="${ params.forbidden }">
						<li>No permission to access this action, login first</li>
					</g:if>
				</ul>
			</div>
			<div id="logout-ok" <g:if test="${ params.logout }">style="display: inline-block;"</g:if>>
				<g:if test="${ params.logout }">
					Logout success
				</g:if>
			</div>
			<div id="login-inputs-container">
				<h2>Login</h2>
				<div class="login-input">
					<label for="username" class="login-label">Username: </label><input id="username" name="username" autocomplete="off"/>
				</div>
				<div class="login-input">
					<label for="password" class="login-label">Password: </label><input id="password" type="password" name="password"/>
				</div>
			</div>
			<button type="submit">Login</button>
		</form>
	</body>
</html>