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
                    <h1 class="page-header">Print Reason Details</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <button type="submit" class="btn btn-info" data-toggle="modal" data-target="#exampleModal2">Insert New Record</button>
                            <button type="button" class="btn btn-info btnright"  style="margin-top:-2px;" data-toggle="modal" data-target="#exampleModal3">Inactive Records</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" style="font-size:13px;">
                                     <thead>
							            <tr>
							                <th>No</th>
							                <th>Print Reason</th>
							                <th>Module</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                <th style="bSortable: false;">Action</th>
							           </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="printReason" varStatus="status">     
								  			<tr>
								            	<td><c:out value="${printReason.no}"/></td>
								                <td><c:out value="${printReason.name}"/></td>
								                <td><c:out value="${printReason.module}"/></td>
							                	<td><c:out value="${printReason.createdBy}"/></td>
								                <td><c:out value="${printReason.createdDate}"/></td>
							                	<td><c:out value="${printReason.modifyBy}"/></td>
							                	<td><c:out value="${printReason.modifyDate}"/></td>
								                <td><a href="#" onclick="editData('${printReason.id}','${printReason.name}','${printReason.module}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${printReason.id}')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
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
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span >&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Edit print reason</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">Id</label>
            <input type="text" class="form-control" id="id" name="id"disabled>
            <input type="text" class="form-control" id="id1" name="id1" style="display:none;">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Print reason name</label>
             <input type="text" class="form-control" id="name" name="name">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Module name</label>
             <select class="form-control" id="mod">
              	<option value="PM">PM</option>
  			 </select>
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

 <div class="modal fade" id="exampleModal2" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" onclick="rese()" ><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Add print reason</h4>
      </div>
      <div class="modal-body">
        <form>
        <div class="form-group">
            <label for="message-text" class="control-label">Print reason name</label>
             <input type="text" class="form-control" id="printName" name="printName">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Module name</label>
             <select class="form-control" id="mods">
              	<option value="PM">PM</option>
  			</select>
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
      <input type="text" class="form-control" id="ids" name="ids" style="display:none;">
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

<div class="modal fade" id="exampleModal3" tabindex="-1" data-backdrop="static" data-keyboard="false" >
  <div class="modal-dialog" style="width:90%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Inactive Record List</h4>
      </div>
      <div class="modal-body">
        <div class="dataTable_wrapper">
           <table class="table table-striped table-bordered table-hover" id="dataTables-example1" style="font-size:13px;">
               <thead>
          			<tr>
              			<th>No</th>
		                <th>Print Reason</th>
		                <th>Module</th>
		                <th>CreateBy</th>
		                <th>Create Date</th>
		                <th>ModifyBy</th>
		                <th>Modify Date</th>
              			<th style="bSortable: false;">Action</th>
         			</tr>
      		   </thead>
      		   <tbody>
          			<c:forEach items="${masters}" var="printReasons" varStatus="status">     
 						<tr>
           					<td><c:out value="${printReasons.no}"/></td>
               				<td><c:out value="${printReasons.name}"/></td>
               				<td><c:out value="${printReason.module}"/></td>
		                	<td><c:out value="${printReasons.createdBy}"/></td>
               				<td><c:out value="${printReasons.createdDate}"/></td>
		                	<td><c:out value="${printReasons.modifyBy}"/></td>
		                	<td><c:out value="${printReasons.modifyDate}"/></td>
               				<td><a href="#" onclick="active('${printReasons.id}')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a></td>
          				</tr>   
    				</c:forEach>
      			</tbody>
           </table>
        </div>
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
  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 7 ] } ],
  	 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
}); 
   $('#dataTables-example1').DataTable({
	  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 7 ] } ],
	  	 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
	}); 
});
function editData(pid,data,modus)
{
	$("#id").val(pid);
	$("#id1").val(pid);
	$("#name").val(data);
	$("#mod").val(modus);
}
function reload()
{
	$('#msg').modal('hide');
	$('#loading').modal('show');
	$("#printName").val('');
	var s=false;
	var table = $('#dataTables-example').dataTable();
	table.fnClearTable();
	var ss=false;	 
	var table1 = $('#dataTables-example1').dataTable();
	table1.fnClearTable();
	$.ajax(
	  {
		type: "Get",
	    url: "rs/getPMprintActive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) 
        {
        	for(var i=0;i < item.length; i++)
        	{
           		s=true;
           		table.fnAddData([item[i].no,item[i].name,item[i].module,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',\'' +item[i].name+ '\',\'' +item[i].module+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) 
        {
            alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getPMprintInActive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
   	    		table1.fnAddData([item[i].no,item[i].name,item[i].module,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
function rese(){
	$("#printName").val('');
}
function valides(){
if($("#printName").val()=="" || $("#printName").val()=="null"){
	$("#exampleModalLabelTitle2").html("Info");
	$("#dataes1").html("Please enter print reason name");
	$('#alerts').modal('show');
	return false;
 }
if($("#mods").val()=="" || $("#mods").val()=="null"){
	$("#exampleModalLabelTitle2").html("Info");
	$("#dataes1").html("Please enter print module name");
	$('#alerts').modal('show');
	return false;
 }else{
	var names=$("#printName").val();
	var mode=$("#mods").val();
	$('#exampleModal2').modal('hide');
	$('#loading').modal('show');
	$.ajax({
	    type: "Get",
	    url: "insert",
	    data: "Name="+names+"&Module="+mode,
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
function valide(){
if($("#name").val()=="" || $("#name").val()=="null"){
	$("#exampleModalLabelTitle2").html("Info");
	$("#dataes1").html("Please enter print reason name");
	$('#alerts').modal('show');
	return false;
}
if($("#mod").val()=="" || $("#mod").val()=="null"){
	$("#exampleModalLabelTitle2").html("Info");
	$("#dataes1").html("Please enter print module name");
	$('#alerts').modal('show');
	return false;
 }else{
	    var id=$("#id1").val();
		var names=$("#name").val();
		var mode=$("#mod").val();
		$('#loading').modal('show');
		$('#exampleModal').modal('hide');
	$.ajax({
	    type: "Get",
	    url: "update",
	    data: "ID="+id+"&Name="+names+"&Module="+mode,
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
function refarance(){
	$('#deletbox').modal('hide');
	$('#loading').modal('show');
	$("#printName").val('');
	var s=false;
	var table = $('#dataTables-example').dataTable();
	table.fnClearTable();
	var ss=false;	 
	var table1 = $('#dataTables-example1').dataTable();
	table1.fnClearTable();
	$.ajax(
	  {
		type: "Get",
	    url: "rs/getPMprintActive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) 
        {
        	for(var i=0;i < item.length; i++)
        	{
           		s=true;
           		table.fnAddData([item[i].no,item[i].name,item[i].module,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',\'' +item[i].name+ '\',\'' +item[i].module+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) 
        {
            alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getPMprintInActive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
   	    		table1.fnAddData([item[i].no,item[i].name,item[i].module,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
function deletedata(){
	$('#deletbox').modal('hide');
	$('#loading').modal('show');
	var id=$("#ids").val();
	$.ajax({
	    type: "Get",
	    url: "delete",
	    data: "ID="+id,
	    success: function(data){
		    	$('#loading').modal('hide');
		    	$("#exampleModalLabelTitle1").html("Successfully");
		    	$("#dataes").html("Record inactive successfully");
		    	$('#msg').modal('show');
		    } ,
		    error: function(){
		    	$('#loading').modal('hide');
		    	$("#exampleModalLabelTitle1").html("Error");
		    	$("#dataes").html("Error in inactivation of record");
		    	$('#msg').modal('show');
		    }
		});
}

function active(id){
	$('#exampleModal3').modal('hide');
	$('#loading').modal('show');
	$.ajax({
	    type: "Get",
	    url: "activeId",
	    data: "ID="+id,
	    success: function(data){
		    	$('#loading').modal('hide');
		    	$("#exampleModalLabelTitle1").html("Successfully");
		    	$("#dataes").html("Record active successfully");
		    	$('#msg').modal('show');
		    } ,
		    error: function(){
		    	$('#loading').modal('hide');
		    	$("#exampleModalLabelTitle1").html("Error");
		    	$("#dataes").html("Error in activation of record");
		    	$('#msg').modal('show');
		     }
		});
}

function relo(){
	$("#printName").val('');
	$('#loading').modal('show');
	var s=false;
	var table = $('#dataTables-example').dataTable();
	table.fnClearTable();
	var ss=false;	 
	var table1 = $('#dataTables-example1').dataTable();
	table1.fnClearTable();
	$.ajax(
	  {
		type: "Get",
	    url: "rs/getPMprintActive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) 
        {
        	for(var i=0;i < item.length; i++)
        	{
           		s=true;
           		table.fnAddData([item[i].no,item[i].name,item[i].module,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',\'' +item[i].name+ '\',\'' +item[i].module+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) 
        {
            alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getPMprintInActive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
   	    		table1.fnAddData([item[i].no,item[i].name,item[i].module,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	$("#ids").val(id);
	$("#exampleModalLabelTitle").html("Inactive Print Reason ");
	$("#datas").html("Do you want to inactive?");
}
</script>
</body>
</html>
