/**
 * Main js-file for configuration-pages
 */  
$( function() {
	
	//	Initialize tabs
	$( "#tabs" ).tabs();
	
	//	If parameter "tab" is "apiuser"
	//	Open ApiUser's tab and open user-container
	if (getUrlParameter("tab") === "apiuser") {
	    $('#tabs').tabs("option", "active", "0");
	    
	    var userId = getUrlParameter("user");
	    
	    if (userId !== undefined) {
	    	
	    	$('.user-container[data-user-id="' + userId + '"]').find(".user-container-content").toggle();
	    	
	    }
	}
	
    
	/**
	 * Click event for handling the setting-update
	 * 
	 * Gets name and value of the setting that is updated
	 * and sends those to server with userId so we know which ApiUser's settings
	 * we are changing.
	 * 
	 * Done:
	 * 		Show success notification
	 * 
	 * Fail:
	 * 		Show error notification
	 */
	$(".js-user-setting-update").click(function() {
		
		var container = $(this).closest(".js-user-setting-container");
		var setting = container.data("setting-name");
		var value = container.find(".js-user-setting-value").val();
		var oldValue = container.find(".js-user-setting-value").attr("data-old-value");
		var userId = container.closest(".user-container").data("user-id");
		var url = $("#change-setting-url").val();
		
		$.ajax({
			
			url: url,
			method: "POST",
			data: {
				setting: setting,
				value: value,
				userId: userId,
				oldValue: oldValue
			}
		
			
		}).done(function() {
			
			//	Show success notification
			$("#setting-change-success").html("Changed setting succesfully").fadeIn().delay(5000).fadeOut();
			
			container.find(".js-user-setting-value").attr("value", value);
			container.find(".js-user-setting-value").attr("data-old-value", value);
			
		}).fail(function() {
			
			//	Show error notification
			$("#setting-change-error").html("Setting change went horribly wrong").fadeIn().delay(5000).fadeOut();
		});
		
	});
	
	/**
	 * Click event for handling the setting-update
	 * 
	 * Gets name and value of the setting that is updated
	 * and sends those to server.
	 * 
	 * Done:
	 * 		Show success notification
	 * 
	 * Fail:
	 * 		Show error notification
	 */
	$(".js-global-user-setting-update").click(function() {
		
		var container = $(this).closest(".js-setting-container");
		var setting = container.data("setting-name");
		var value = container.find(".js-global-setting-value").val();
		var url = $("#change-global-setting-url").val();
		
		$.ajax({
			
			url: url,
			method: "POST",
			data: {
				setting: setting,
				value: value,
			}
		
			
		}).done(function() {
			
			//	Show success notification
			$("#global-setting-change-success").html("Changed setting succesfully").fadeIn().delay(5000).fadeOut();
			
		}).fail(function() {
			
			//	Show error notification
			$("#global-setting-change-error").html("Setting change went horribly wrong").fadeIn().delay(5000).fadeOut();
		});
		
	});
	
	/**
	 * Click event for closing notifications
	 */
	$(".notification-element").click(function() {
		$(this).fadeOut();
	});
	
	/**
	 * Opens and closes container for user's settings
	 */
	$(".user-container-header").click(function() {
		var container = $(this).closest(".user-container");
		var content = container.find(".user-container-content");
		content.toggle();
	});
	
});

//Get given url parameter
function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    
    for (var i = 0; i < sURLVariables.length; i++) {
    	
        var sParameterName = sURLVariables[i].split('=');
        
        if (sParameterName[0] === sParam) {
            return sParameterName[1];
        }
    }
}


function validateConfig(provider) {
	var val = $("#orgSelect").val();
	
	$.get("http://localhost:8080/VrkConnector/configuration/validate", { orgId: val, provider: provider } )
  	.done(function( data ) {
    	alert( "Data Loaded: " + data );
  });
	
}