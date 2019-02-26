<html>
	<head>
		<meta name="layout" content="main"/>
		<asset:stylesheet src="configuration.css"/>
		<asset:javascript src="configuration.js"/>
		<asset:javascript src="jquery-ui.js"/>
		<asset:stylesheet src="jquery-ui.css"/>
	</head>
	<body>
		<h1>Configurations</h1>
		<div id="tabs">
		<input type="hidden" id="change-setting-url" value="${ createLink(controller: 'configuration', action: 'changeSetting') }"/>
		<input type="hidden" id="change-global-setting-url" value="${ createLink(controller: 'configuration', action: 'changeGlobalSetting') }"/>
		
		  <ul>
		  	<li><a href="#tabs-1" data-tab-index="0">ApiUsers</a></li>
		    <li><a href="#tabs-2" data-tab-index="1">Global settings</a></li>
		  </ul>
		  <div id="tabs-1">
		  	<div class="setting-container">
		    	<g:render template="apiUserSettings"/>
		    </div>
		  </div>
		  <div id="tabs-2">
		  	<div class="setting-container">
		  		<g:render template="globalSettings" model="[globalSettings: globalSettings]"/>
		  	</div>
		  </div>
		</div>
	</body>
</html>
