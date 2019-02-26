<html>
	<head>
		<meta name="layout" content="main"/>
		<asset:javascript src="configuration.js"/>
	</head>

<body>

<h1>Validate configurations</h1>

<br>

<p>Select organisation:</p>
<select id="orgSelect">
  <g:each in="${users}">
  	<option value="${it.id}">${it.organization}</option>
  </g:each>
</select>

<br>
<button id="validateXRoad" onclick="validateConfig('XRoad')" class="js-global-user-setting-update user-setting-update">XRoad</button>

<button id="validateTrimble" onclick="validateConfig('Trimble')"  class="js-global-user-setting-update user-setting-update">Trimble</button>

</body>
</html>