<%-- List of users and user's settings --%>

<%-- Error and success notifications --%>
<div id="login-error" class="notification-element" <g:if test="${ flash.errorMessage }">style="display: inline-block;"</g:if>>
	${ flash.errorMessage }
</div>
<div id="logout-ok" class="notification-element" <g:if test="${ flash.successMessage }">style="display: inline-block;"</g:if>>
	${ flash.successMessage }
</div>

<div id="setting-change-success" class="notification-element  setting-change-success"></div>
<div id="setting-change-error" class="notification-element  setting-change-error"></div>

<div class="users-container">
	<g:each in="${ apiUsers }" var="${ user }">
		<div class="user-container" data-user-id="${ user.id }">
		
			<div class="user-container-header">
				<h2 class="user-organization">${ user.organization }</h2>
			</div>
			<div class="user-container-content">
				<%-- Certificate can be uploaded to server and the fingerprint is then extracted from the certificate --%>
				<form enctype="multipart/form-data" id="certificate-upload-${ user.id }" name="certificate-upload" method="post" action="${ createLink(controller: 'configuration', action: 'setFingerprint') }">
					<input type="hidden" name="userId" value="${ user.id }">
					<label class="user-setting-label  user-setting-container" for="certificate_${ user.id }">Set new fingerprint for user: </label>
					<input id="certificate_${ user.id }" type="file" name="certificate"/>
					<button type="submit">Set new fingerprint</button>
				</form>
				<div class="user-setting-container">
					<label id="current-fingerprint-label-${ user.id }" class="current-fingerprint-label  user-setting-label">Current fingerprint: </label>
					<input id="current-fingerprint-input-${ user.id }" class="current-fingerprint-value  user-setting-value" size="100" value="${ user.sha1 }"/>
				</div>
				
				<g:each in="${ user.settings }" var="${ setting }">
					<div class="user-setting-container  js-user-setting-container " data-setting-name="${ setting.name }">
						<label class="user-setting-label" for="${ setting.name }_${ setting.id }">${ setting.name }</label>
						<input id="${ setting.name }_${ setting.id }" size="100" class="user-setting-value  js-user-setting-value" value="${ setting.value }" data-old-value="${ setting.value }" autocomplete="off"/>
						<button class="user-setting-update  js-user-setting-update">Update</button>
					</div>
				</g:each>
			</div>
		</div>
	</g:each>
	
	<div class="user-container  new">
		<div class="user-container-header">
			<h2 class="user-organization">Add new user</h2>
		</div>
		<div class="user-container-content">
			<form id="create-new-user-form" name="create-new-user-form" method="post" action="${ createLink(controller: 'configuration', action: 'newUser') }">
				<label class="user-setting-label  user-setting-container" for="new-user-organization-input">Organization name: </label>
				<input id="new-user-organization-input" type="text" name="organization"/>
				<button type="submit">Create new user</button>
			</form>
		</div>
	</div>
</div>
