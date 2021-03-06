

$(document).ready(function(){
	$(".error").empty();
	
	$("#registerSubmit").click(function(event){
		event.preventDefault();
		registerSubmit();
	});
	
	$("#loginSubmit").click(function(event){
		event.preventDefault();
		loginSubmit();
	});
});

var successStart = "<div class='alert alert-success'><strong><span class='glyphicon glyphicon-ok'></span>";
var errorStart = "<div class='alert alert-danger'><span class='glyphicon glyphicon-remove'></span><strong>";
var messageEnd = "</strong></div>";

function registerSubmit(){
	$("#registerError").empty();
	$("#loginError").empty();
	$("#loginUsername").val("");
	$("#loginPassword").val("");
	var username = $("#registerUsername").val();
	var password1 = $("#registerPassword1").val();
	var password2 = $("#registerPassword2").val();
	if(username === "" || password1 === "" || password2 === "")
	{
		$("#registerError").append(errorStart + "All fields are required" + messageEnd);
		return;
	}
	else if(password1 != password2)
	{
		$("#registerError").append(errorStart + "Passwords do not match" + messageEnd);
		return;
	}
	var user = {};
	user.username = username;
	user.password = password1;
	$.ajax({
        url: '/users/'+username,
        method: 'GET',
    }).then(function(InUse){
    	if(InUse === false)
    	{
    		$.ajax({
    	        url: '/users',
    	        method: 'POST',
    	        contentType: 'application/json',
    	        data: JSON.stringify(user)
    	    }).then(function(){
    	        console.log("Post successful")
    	        $("#registerUsername").val("");
    	        $("#registerPassword1").val("");
    	        $("#registerPassword2").val("");
    	        $("#registerError").append(successStart + "Success! You may now log in" + messageEnd);
    	    }, function(error){
    	        console.log(error);
    	    });
    	}
    	else
    	{
    		$("#registerError").append(errorStart + "That username is already in use" + messageEnd);
    	}
    }, function(error){
        console.log(error);
    });
};

function loginSubmit(){
	$("#registerError").empty();
	$("#loginError").empty();
	$("#registerUsername").val("");
	$("#registerPassword1").val("");
	$("#registerPassword2").val("");
	var username = $("#loginUsername").val();
	var password = $("#loginPassword").val();
	if(username === "" || password === "")
	{
		$("#loginError").append(errorStart + "All fields are required" + messageEnd);
		return;
	}
	$.ajax({
        url: '/users/'+username,
        method: 'GET',
    }).then(function(InUse){
    	if(InUse === false)
    	{
    		$("#loginError").append(errorStart + "Username does not exist" + messageEnd);
    		return;
    	}
    	else
    	{
    		$.ajax({
    	        url: '/user/name/'+username,
    	        method: 'GET',
    		}).then(function(User){
    			if(User.password != password)
    			{
    				$("#loginError").append(errorStart + "Username/password do not match" + messageEnd);
    				return;
    			}
    			else
    			{
    				window.location.replace("/home");
    			}
    		}, function(error){
    	        console.log(error);
    	    });
    	}
    }, function(error){
        console.log(error);
    });
}