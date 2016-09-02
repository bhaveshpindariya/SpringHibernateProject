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
                    <h1 class="page-header">Role Details</h1>
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
							                <th>Role Name</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							            </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="role" varStatus="status">     
							  			<tr>
							            	<td><c:out value="${role.no}"/></td>
							                <td><c:out value="${role.rolename}"/></td> 
							                <td><c:out value="${role.createdBy}"/></td> 
							                <td><c:out value="${role.createdDate}"/></td> 
							                <td><c:out value="${role.modifyBy}"/></td> 
							                <td><c:out value="${role.modifyDate}"/></td> 
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
 
 <div class="modal fade" id="exampleModal2" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Add role detail</h4>
      </div>
      <div class="modal-body">
        <form>
        <div class="form-group">
             <label for="message-text" class="control-label">Role name</label>
              <select class="form-control" id="cdetails">
	            <option value="PMAdministrator">PMAdministrator</option>
	  			<option value="LRFAdministrator">LRFAdministrator</option>
              </select>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="valides()" id="savepr">Save</button>
        <button type="reset" class="btn btn-default">Reset</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="relo()">Close</button>
        
        
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
      <button type="button" class="btn btn-primary" id ="Ok" onclick="relo()" >Ok</button>
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
    	"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    });
 });
 
 
 function relo(){
	    $('#msg').modal('hide');
		$('#loading').modal('show');
		var ss=false;	 
		var table = $('#dataTables-example').dataTable();
		table.fnClearTable();
		$.ajax(
		  {
			type: "Get",
		    url: "rs/getRoles",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		ss=true;
	           		table.fnAddData([item[i].id,item[i].rolename,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate]);           
	        	}
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) 
	        {
	            alert(errorThrown);
	        }
	    });
		 if(ss==true){
	  		$('#loading').modal('hide');
	   	  }else{
	   		$('#loading').modal('hide'); 
	   	  }
}

 function valides(){
		if($("#cdetails").val()=="" || $("#cdetails").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter role detail");
			$('#alerts').modal('show');
			return false;
		}else{
			var role=$("#cdetails").val();
			$('#exampleModal2').modal('hide');
			$('#loading').modal('show');
			$.ajax({
			    type: "Get",
			    url: "insertuserRole",
			    data: "Role="+role,
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
			    	$("#dataes").html("Error in inserting record");
			    	$('#msg').modal('show');
			    }
			});
		}
	}
 </script>
</body>
</html>
