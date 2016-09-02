<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Biocon Admin Panel</title>
	<%@include file="headers.jsp" %>
    </head>
    <body onload="BodyOnload();" style="padding:0px !important;">
	<div id="wrapper">
      <%@include file="menus.jsp" %>
      
      <div id="page-wrapper"> 
      		 <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">User Details</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                     <div class="panel-heading">
                            <button type="submit" class="btn btn-info" data-toggle="modal" data-target="#exampleModal2">Insert New Record</button>
                     </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" style="font-size:13px;">
                                     <thead>
							            <tr>
							                <th>Id</th>
							                <th>User Name</th>
							                <th>User Password</th>
							                <th>User Role</th>
							                <th>User EmailId</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                 <th style="bSortable: false;">Action</th>
							            </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="user" varStatus="status">     
							  			<tr>
							            	<td><c:out value="${user.no}"/></td>
							                <td><c:out value="${user.name}"/></td>
							                <td><c:out value="${user.password}"/></td>
							                <td><c:out value="${user.role}"/></td>
							                <td><c:out value="${user.email}"/></td>
							                <td><c:out value="${user.createdBy}"/></td> 
							                <td><c:out value="${user.createdDate}"/></td> 
							                <td><c:out value="${user.modifyBy}"/></td> 
							                <td><c:out value="${user.modifyDate}"/></td> 
							                <td><a href="#" onclick="editData('${user.id}','${user.name}','${user.password}','${user.roleid}','${user.role}','${user.email}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${user.id}')"  title="Delete" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
								        </tr>   
										</c:forEach>
							        </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
			
      </div>
 </div>
 <div class="col-lg-12">
    <div class="row">
		<footer class="footer"> 
		<span>Copyright © 1995-2015 SoluSoft Technologies Pvt. Ltd.</span>
		</footer>
	</div>
 </div>
 <div class="modal fade" id="exampleModal" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" >
    <div class="modal-content" style="width:500px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" ><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Edit user detail</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">Id</label>
            <input type="text" class="form-control" id="id" name="id" disabled>
            <input type="text" class="form-control" id="id1" name="id1" style="display:none;">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">User name</label>
            <input type="text" class="form-control" id="name" name="name">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">User password</label>
            <input type="password" class="form-control" id="pass" name="pass">
          </div>
          <div class="form-group">
		    <label for="exampleInputPassword1">Confirm Password</label>
		    <input type="password" id="cpassword" name="cpassword" class="form-control" placeholder="Confirm Password"/>
	      </div>
          <div class="form-group">
            <label for="message-text" class="control-label">User role</label>
             <select class="form-control" id="role">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">User email</label>
            <input type="text" class="form-control" id="email" name="email">
          </div>
       </form>
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" onclick="valide()" id="save">Save</button>
       <button type="button" class="btn btn-default" data-dismiss="modal" onclick="relo()">Close</button>
        
      </div>
    </div>
  </div>
</div>

 <div class="modal fade" id="exampleModal2" tabindex="-1"  data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content" style="width:500px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" onclick="rese()"><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Add user detail</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="message-text" class="control-label">User name</label>
            <input type="text" class="form-control" id="names" name="names" >
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">User password</label>
            <input type="password" class="form-control" id="passs" name="passs">
          </div>
          <div class="form-group">
		    <label for="exampleInputPassword1">Confirm Password</label>
		    <input type="password" id="cpasswords" name="cpasswords" class="form-control" placeholder="Confirm Password"/>
	      </div>
          <div class="form-group">
            <label for="message-text" class="control-label">User role</label>
             <select class="form-control" id="roles">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">User email</label>
            <input type="text" class="form-control" id="emails" name="emails">
          </div>
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="valides()" id="savepr">Save</button>
        <button type="reset" class="btn btn-default" onclick="rese()" >Reset</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="relo()">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="deletbox" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" ><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabelTitle"></h4>
      </div>
      <input type="text" class="form-control" id="id1" name="id1" style="display:none;">
      <div class="modal-body" id="datas">
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" id ="yes" onclick="deletedata()" >Yes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="no" onclick="refarance()" >No</button>
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
      <button type="button" class="btn btn-primary" id ="yes" onclick="reload()" >Yes</button>
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
<%@include file="footer.jsp" %>
 <script>
 $(document).ready(function() {
    $('#dataTables-example').DataTable({
    	"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 9 ] } ],
    	"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    });
    
    $.getJSON('rs/getRoles', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	        	if(item.rolename.trim() !="APPAdministrator"){
	        		datas+='<option value='+item.id+'>'+item.rolename+'</option>';
	        	}
	        });
	        $("#roles").html(datas);
	}); 
    $.getJSON('rs/getRoles', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	        	if(item.rolename.trim() !="APPAdministrator"){
	       			datas+='<option value='+item.id+'>'+item.rolename+'</option>';
	        	}
	        });
	        $("#role").html(datas);
	});
 });
 
 
function rese(){
		$("#names").val('');
		$("#passs").val('');
		$("#cpasswords").val('');
		$("#emails").val('');
 }
 
 function editData(id,name,password,roleid,role,email){
	 	$("#id").val(id);
		$("#id1").val(id);
		$("#name").val(name);
		$("#pass").val(password);
		$("#cpassword").val(password);
		$("#email").val(email);
		$.getJSON('rs/getRoles', function(data){
		   	 var datas='';
		        $.each(data, function(index, item){
		        	if(item.id==roleid){
		        		datas+='<option value='+item.id+' selected>'+item.rolename+'</option>';
		        	}else{
		        		if(item.rolename.trim() !="APPAdministrator"){
			       			datas+='<option value='+item.id+'>'+item.rolename+'</option>';
			        	}
		        	}
		        });
		        $("#role").html(datas);
		});
	}
 
 function relo(){
		$('#loading').modal('show');
		$("#names").val('');
		$("#passs").val('');
		$("#emails").val('');
		$("#cpasswords").val('');
		var s=false;
		var table = $('#dataTables-example').dataTable();
		table.fnClearTable();
		$.ajax({
			type: "Get",
		    url: "rs/getuserdata",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	        		s=true;
	        		table.fnAddData([item[i].no,item[i].name,item[i].password,item[i].role,item[i].email,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',\''+item[i].name+'\',\''+item[i].password+'\',\''+item[i].roleid+'\',\''+item[i].role+'\',\''+item[i].email+'\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
	        	}
	        },																																						
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	        	alert(errorThrown);
	        }
	    });
		if(s==true && ss==true){
			$('#loading').modal('hide');
		}else{
			$('#loading').modal('hide'); 
		}
	}
 
 function deleteData(id){
		$("#id1").val(id);
		$("#exampleModalLabelTitle").html("Record delete");
		$("#datas").html("Do you want to delete?");
	}
 
 function deletedata(){
		$('#deletbox').modal('hide');
		$('#msg').modal('hide');
		$('#loading').modal('show');
		var id=$("#id1").val();
		$.ajax({
			    type: "Get",
			    url: "deleteuserdata",
			    data: "ID="+id,
			    success: function(data){
			    	$('#loading').modal('hide');
			    	$("#exampleModalLabelTitle1").html("Successfully");
			    	$("#dataes").html("Record deleted successfully");
			    	$('#msg').modal('show');
			    } ,
			    error: function(){
			    	$('#loading').modal('hide');
			    	$("#exampleModalLabelTitle1").html("Error");
			    	$("#dataes").html("Error in delete record");
			    	$('#msg').modal('show');
			    	
			    }
			});
	}
 function validateEmail(email) {
	  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
	}
 function valides(){
	   if($("#names").val()=="" || $("#names").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter user name");
	    	$('#alerts').modal('show');
			return false;
	   } 
		if($("#passs").val()=="" || $("#passs").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
	    	$("#dataes1").html("Please enter password");
	    	$('#alerts').modal('show');
			return false;
		}
		if($("#emails").val()=="" || $("#emails").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
	    	$("#dataes1").html("Please enter email address");
	    	$('#alerts').modal('show');
			return false;
		}else{
			 var email = $("#emails").val();
			 if (validateEmail(email)) {
			 }else{
				 $("#exampleModalLabelTitle2").html("Info");
				 $("#dataes1").html("Email address is not valid ");
			     $('#alerts').modal('show');
				 return false;
			 }
		 }
		if($("#roles").val()=="" || $("#roles").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
	    	$("#dataes1").html("Please enter user role");
	    	$('#alerts').modal('show');
			return false;
		}
		if($("#cpasswords").val()=="" || $("#cpasswords").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
	    	$("#dataes1").html("Please enter confirm password");
	    	$('#alerts').modal('show');
			return false;
	   }else{
			var pass=$("#pass").val();
			var cpass=$("#cpassword").val();
			if(!(pass==cpass)){
				$("#passs").focus();
				$("#passs").val('');
				$("#cpasswords").val('');
				$("#dataes1").html("Password and confirm password are not matching.");
		    	$('#alerts').modal('show');
		    	return false;
			}else{
				var names=$("#names").val();
				var pass=$("#passs").val();
				var email=$("#emails").val();
				var role=$("#roles").val();
				$('#exampleModal2').modal('hide');
				$('#loading').modal('show');
				$.ajax({
				    type: "Get",
				    url: "insertUserdata",
				    data: "Name="+names+"&Pass="+pass+"&Email="+email+"&Role="+role,
				    success: function(data){
				    	if(data.success==true){
				    		$('#loading').modal('hide');
				    		$("#exampleModalLabelTitle1").html("Successfully");
				    		$("#dataes").html("Record inserted sccessfully");
				    		$('#msg').modal('show');
				    	}else{
				    		$('#loading').modal('hide');
				    		$("#exampleModalLabelTitle1").html("Info");
					    	$("#dataes").html(data.message);
					    	$('#msg').modal('show');
				    	}
				    } ,
				    error: function(){
				    	$('#loading').modal('hide');
				    	$("#exampleModalLabelTitle1").html("Error");
				    	$("#dataes").html("Error inserting record");
				    	$('#msg').modal('show');
				    }
				});
			}
		}
	}

	function valide(){
		if($("#name").val()=="" || $("#name").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter user name");
	    	$('#alerts').modal('show');
			return false;
		 }
		if($("#pass").val()=="" || $("#pass").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
	    	$("#dataes1").html("Please enter password");
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
				 return false;
			 }
		 }
		if($("#role").val()=="" || $("#role").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
	    	$("#dataes1").html("Please enter user role");
	    	$('#alerts').modal('show');
			return false;
		}
		if($("#cpassword").val()=="" || $("#cpassword").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
	    	$("#dataes1").html("Please enter confirm password");
	    	$('#alerts').modal('show');
			return false;
	   }else{
			var pass=$("#pass").val();
			var cpass=$("#cpassword").val();
			if(!(pass==cpass)){
				$("#pass").focus();
				$("#pass").val('');
				$("#cpassword").val('');
				$("#dataes1").html("Password and confirm password are not matching.");
		    	$('#alerts').modal('show');
		    	return false;
			}else{
				var id=$("#id1").val();
				var names=$("#name").val();
				var pass=$("#pass").val();
				var email=$("#email").val();
				var role=$("#role").val();
				$('#loading').modal('show');
				$('#exampleModal').modal('hide');
				$.ajax({
				    type: "Get",
				    url: "updateUserdata",
				    data: "ID="+id+"&Name="+names+"&Pass="+pass+"&Email="+email+"&Role="+role,
				    success: function(data){
				    	if(data.success==true){
				    		$('#loading').modal('hide');
				    		$("#exampleModalLabelTitle1").html("Successfully");
				    		$("#dataes").html("Record updated successfully");
				    		$('#msg').modal('show');
				    	}else{
				    		$('#loading').modal('hide');
				    		$("#exampleModalLabelTitle1").html("Info");
					    	$("#dataes").html(data.message);
					    	$('#msg').modal('show');
				    	}
				    } ,
				    error: function(){
				    	$('#loading').modal('hide');
				    	$("#exampleModalLabelTitle1").html("Error");
				    	$("#dataes").html("Error updating record");
				    	$('#msg').modal('show');
				    }
				});
			}
		}
	}
	
	function refarance(){
		$('#deletbox').modal('hide');
		$('#loading').modal('show');
		$("#names").val('');
		$("#passs").val('');
		$("#emails").val('');
		$("#cpasswords").val('');
		var s=false;
		var table = $('#dataTables-example').dataTable();
		table.fnClearTable();
		$.ajax({
			type: "Get",
		    url: "rs/getuserdata",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	        		s=true;
	        		table.fnAddData([item[i].no,item[i].name,item[i].password,item[i].role,item[i].email,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',\''+item[i].name+'\',\''+item[i].password+'\',\''+item[i].roleid+'\',\''+item[i].role+'\',\''+item[i].email+'\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
		        }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {																																																																														
	        	alert(errorThrown);
	        }
	    });
		if(s==true && ss==true){
			$('#loading').modal('hide');
		}else{
			$('#loading').modal('hide'); 
		}
	}
	
	function reload(){
		$('#msg').modal('hide');
		$('#loading').modal('show');
		$("#names").val('');
		$("#passs").val('');
		$("#emails").val('');
		$("#cpasswords").val('');
		var s=false;
		var table = $('#dataTables-example').dataTable();
		table.fnClearTable();
		$.ajax({
			type: "Get",
		    url: "rs/getuserdata",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	        		s=true;
	        		table.fnAddData([item[i].no,item[i].name,item[i].password,item[i].role,item[i].email,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',\''+item[i].name+'\',\''+item[i].password+'\',\''+item[i].roleid+'\',\''+item[i].role+'\',\''+item[i].email+'\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
		        }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	        	alert(errorThrown);
	        }
	    });
		if(s==true && ss==true){
			$('#loading').modal('hide');
		}else{
			$('#loading').modal('hide'); 
		}
	}
 </script>
</body>
</html>
