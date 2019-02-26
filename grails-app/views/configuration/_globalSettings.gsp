<div id="global-setting-change-success" class="notification-element  setting-change-success"></div>
<div id="global-setting-change-error" class="notification-element  setting-change-error"></div>

<g:each in="${ globalSettings }" var="${ setting }">
	<div class="setting-container js-setting-container" data-setting-name="${ setting.name }">
		<label class="setting-label" for="${ setting.name }">${ setting.name }</label><input class="setting-value js-global-setting-value" id="${ setting.name }" type="text" value="${ setting.value }" size="100"/>
		<button class="js-global-user-setting-update user-setting-update">Update</button>
	</div>
</g:each>