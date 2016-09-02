<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Biocon Admin Panel</title>

<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/custome.css"/>" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript">  </script> 
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript">  </script> 
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js"/>" ></script>
<script type="text/javascript">
$.validator.setDefaults({
	submitHandler:function(){jAlert('Submitted','Sucess');}
});

$(document).ready(function () {
	$("#f").validate({
		rules:{
			j_username:"required",
			j_password:{
				required:true,
			}
		},
		messages:{
			j_username: "Please Enter User Name",
			j_password:{
				required: "Please Enter a password",
			}
		}
	});
	
	$("#savedata").click(function () {
		if(valides()){
			$("#registration").submit();
		}
	});
});

$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').focus();
});



function clearStorage(){
	localStorage.clear();
}

function rese(){
	$("#name").val('');
	$("#email").val('');
	$("#password").val('');
	$("#cpassword").val('');
}
function validateEmail(email) {
  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}
function valides(){

   if($("#name").val()=="" || $("#name").val()=="null"){
	    $("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter user name");
    	$('#alerts').modal('show');
		return false;
   }
   if($("#email").val()=="" || $("#email").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
    	$("#dataes1").html("Please enter email address");
    	$('#alerts').modal('show');
		return false;
   }else{
		 var email = $("#email").val();
		 if (validateEmail(email)) {
		 }else{
			 $("#exampleModalLabelTitle2").html("Info");
			 $("#dataes1").html("Email address is not valid ");
		     $('#alerts').modal('show');
		     $("#email").focus();
		     $("#email").val('');
			 return false;
		 }
    }
   if($("#password").val()=="" || $("#password").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
    	$("#dataes1").html("Please enter password");
    	$('#alerts').modal('show');
		return false;
   }
   if($("#cpassword").val()=="" || $("#cpassword").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
    	$("#dataes1").html("Please enter confirm password");
    	$('#alerts').modal('show');
		return false;
   }else{
		var pass=$("#password").val();
		var cpass=$("#cpassword").val();
		if(!(pass==cpass)){
			$("#password").focus();
			$("#password").val('');
			$("#cpassword").val('');
			$("#dataes1").html("Password and confirm password are not matching.");
	    	$('#alerts').modal('show');
	    	return false;
		}else{
			return true;
		}
	}
}

</script>
</head>
<body onload="document.f.j_username.focus();" >

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12 users"><b style="color:#000000;">Biocon Admin Module</b> </div>
</div>

 
<div class="col-md-12 col-sm-12 col-xs-12 panels">
<div class="col-md-4 col-sm-4 col-xs-12"></div>
<form method="POST" name="f" id="f" action="j_spring_security_check"  >
	<div class="panel panel-default col-md-4 col-sm-4 col-xs-12">
	  <div class="tittle">Welcome to Admin Module <span><img style="width:26%;" src="<c:url value="/resources/images/Biocon_Logo.png"/>" ></span></div>
	    <c:if test="${not empty message}">
		    <c:if test="${message=='Administrator user is already in database'}">
		    	<div class="succes">
		  			<span class="glyphicon glyphicon glyphicon-ok" style="color:green;"></span>${message}
		  		</div>
		  	</c:if>
		  	<c:if test="${message=='Administrator registration successfully'}">
		    	<div class="succes">
		  			<span class="glyphicon glyphicon glyphicon-ok" style="color:green;"></span>${message}
		  		</div>
		  	</c:if> 
		  	<c:if test="${message=='Error in administrator registration'}">
		  		<div class="errors">
		  			<span class="glyphicon glyphicon-remove-circle" style="color:red;"></span>${message}
		  		</div>
		  	</c:if> 
		  	<c:if test="${message=='Invalid credentials!'}">
		  		<div class="errors">
		  			<span class="glyphicon glyphicon-remove-circle" style="color:red;"></span>The user ID or password is not valid
		  		</div>
		  	</c:if> 
	 	</c:if>
	  <div class="panel-body">
		    <div>
			  	<label>User name</label>
			  	<br>
			    	<input id="j_username" name="j_username" type="text">
		    </div>
		    <div>
		    	<label>Password</label>
		    	<br>
		    		<input id="j_password" name="j_password" type="password" value="">
		    </div>
	    	<br>
		    <div>
		    	<button type="submit" class="btn btn-primary" id ="submit" name="submit" onclick="clearStorage()" >Log In</button>
		    	<c:if test="${not empty status}">
		    		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Sign Up</button>
		    	</c:if>
		    	<span class="imges"><img style="width:75%;float: right" src="<c:url value="/resources/images/solusoftlogo.png" />" ></span>
		    </div>
	   
	  </div>
	</div>
</form>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" >
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" onclick="rese()"><span >&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Administrator Registration</h4>
      </div>
       <div class="modal-body">
        <form id="registration" name="registration" action="insertRollandUser" method="POST">
	          <div class="form-group">
			    <label for="exampleInputEmail1">User Name</label>
			    <input type="text" id="name" name="name" class="form-control" placeholder="User Name"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Email Id</label>
			    <input type="text" id="email" name="email" class="form-control" placeholder="Email Id"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Confirm Password</label>
			    <input type="password" id="cpassword" name="cpassword" class="form-control" placeholder="Confirm Password"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Role</label>
			    <input type="text" class="form-control" name="role"  placeholder="Role" id="role" value="APPAdministrator" readonly="readonly"/>
			  </div>
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="savedata" name="savedata">Submit</button>
  		<button type="reset" class="btn btn-primary" onclick="rese()" >Reset</button>
  		<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="rese()" >Cancel</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="msg" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabelTitle1"></h4>
      </div>
      <div class="modal-body" id="dataes">
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" id ="yes" data-dismiss="modal" onclick="rese()">Yes</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="alerts" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabelTitle2"></h4>
      </div>
      <div class="modal-body" id="dataes1">
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" data-dismiss="modal" >Yes</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="loading" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" >
  	<div class="modal-body gifani">
       <img src="<c:url value="/resources/images/31.gif"/>"> 
      </div>
  </div>
</div>
</body>
</html>
