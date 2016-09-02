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
                    <h1 class="page-header">Custom Department Details</h1>
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
                       		<button type="button" class="btn btn-info btnright"  style="margin-top:-2px;margin-right:5px;" onclick="synchronize()" id="synchronize">Synchronize</button>
                       </div>
                       <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" style="font-size:13px;">
                                     <thead>
							             <tr>
							                <th>Custom Department Code</th>
							                <th>Custom Department Name</th>
							                <th>Custom Department Abbreviation</th>
							                <th>Company Name</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                <th style="bSortable: false;">Action</th>
							           </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="depart" varStatus="status">     
							  			<tr>
							            	<td><c:out value="${depart.dCode}"/></td>
							                <td><c:out value="${depart.dName}"/></td>
							                <td><c:out value="${depart.dAbbra}"/></td>
							                <td><c:out value="${depart.companyName}"/></td>
							                <td><c:out value="${depart.createdBy}"/></td>
							                <td><c:out value="${depart.createdDate}"/></td>
							                <td><c:out value="${depart.modifyBy}"/></td>
							                <td><c:out value="${depart.modifyDate}"/></td>
							                <td><a href="#" onclick="editData('${depart.dCode}','${depart.dName}','${depart.dAbbra}','${depart.cid}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${depart.dCode}')"  title="Delete" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
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
        <h4 class="modal-title" id="exampleModalLabel">Edit custom department detail</h4>
      </div>
      <div class="modal-body">
        <form>
        <div class="form-group">
             <label for="message-text" class="control-label">Company name</label>
            <select class="form-control" id="cdetail">
            </select>
        </div>
          <div class="form-group">
            <label for="recipient-name" class="control-label">Custom department code</label>
            <input type="text" class="form-control" id="id" name="id"disabled>
            <input type="text" class="form-control" id="id1" name="id1" style="display:none;">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Custom department name</label>
             <input type="text" class="form-control" id="cdn" name="cdn">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Custom department abbreviation</label>
             <input type="text" class="form-control" id="cdabb" name="cdabb">
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
        <button type="button" class="close" data-dismiss="modal" onclick="rese()"><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Add custom department detail</h4>
      </div>
      <div class="modal-body">
        <form>
         <div class="form-group">
             <label for="message-text" class="control-label">Company name</label>
            <select class="form-control" id="cdetails">
            </select>
          </div>
         <div class="form-group">
            <label for="recipient-name" class="control-label">Custom department code</label>
              <input type="text" class="form-control" id="cdcs" name="cdcs">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Custom department name</label>
             <input type="text" class="form-control" id="cdns" name="cdns">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Custom department abbreviation</label>
             <input type="text" class="form-control" id="cdabbs" name="cdabbs">
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
      <input type="text" class="form-control" id="code" name="code" style="display:none;">
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
              			 <th>Custom Department Code</th>
			             <th>Custom Department Name</th>
			             <th>Custom Department Abbreviation</th>
			             <th>Company Name</th>
		                 <th>CreateBy</th>
			             <th>Create Date</th>
		                 <th>ModifyBy</th>
		                 <th>Modify Date</th>
              			 <th style="bSortable: false;">Action</th>
         			</tr>
      		   </thead>
      		   <tbody>
          			<c:forEach items="${masters}" var="cudep" varStatus="status">     
 						<tr>
           					<td><c:out value="${cudep.dCode}"/></td>
			                <td><c:out value="${cudep.dName}"/></td>
			                <td><c:out value="${cudep.dAbbra}"/></td>
			                <td><c:out value="${cudep.companyName}"/></td>
			                <td><c:out value="${cudep.createdBy}"/></td>
			                <td><c:out value="${cudep.createdDate}"/></td>
			                <td><c:out value="${cudep.modifyBy}"/></td>
			                <td><c:out value="${cudep.modifyDate}"/></td>
               				<td><a href="#" onclick="active('${cudep.dCode}')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a></td>
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
  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 8 ] } ],
  	 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
	}); 
   $('#dataTables-example1').DataTable({
	  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 8 ] } ],
	  	 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
   }); 
   $.getJSON('rs/getComp', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	        	if(item.companyName.trim() !="Biocon Research Limited"){
	        		datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
	        	}
	        });
	        $("#cdetails").html(datas);
	}); 
   
   $('#cdcs').keydown(function (e) {
	   if (e.shiftKey || e.ctrlKey || e.altKey) {
	   		e.preventDefault();
	   }else{
	   		var key = e.keyCode;
	   		if (!((key == 8) || (key == 46) || (key >= 35 && key <= 40) || (key >= 48 && key <= 57) || (key >= 96 && key <= 105))) {
	  		 	e.preventDefault();
	   		}
	   }
	});
});
function editData(dcode,dname,dabb,ccode){
	$("#id").val(dcode);
	$("#id1").val(dcode);
	$("#cdn").val(dname);
	$("#cdabb").val(dabb);
	$.getJSON('rs/getComp', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	        	if(item.companyCode==ccode){
	        		datas+='<option value='+item.companyCode+' selected>'+item.companyName+'</option>';
	        	}else{
	        		if(item.companyName.trim()!="Biocon Research Limited"){
		        		datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
		        	}
	        	}
	        });
	        $("#cdetail").html(datas);
	});
}
function reload(){
	$('#msg').modal('hide');
	$('#loading').modal('show');
	$("#cdcs").val('');
	$("#cdns").val('');
	$("#cdabbs").val('');
	re();
	var s=false;
	var table = $('#dataTables-example').dataTable();
	table.fnClearTable();
	var ss=false;	 
	var table1 = $('#dataTables-example1').dataTable();
	table1.fnClearTable();
	$.ajax({
		type: "Get",
	    url: "rs/getcustdeptactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].dCode,item[i].dName,item[i].dAbbra,item[i].companyName,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].dCode+',\'' +item[i].dName+ '\',\'' +item[i].dAbbra+ '\','+item[i].cid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].dCode+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getcustdeptinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].dCode,item[i].dName,item[i].dAbbra,item[i].companyName,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].dCode+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	$("#cdcs").val('');
	$("#cdns").val('');
	$("#cdabbs").val('');
}
function valides(){
	if($("#cdcs").val()=="" || $("#cdcs").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter custom department code");
		$('#alerts').modal('show');
		return false;
	}
	if($("#cdns").val()=="" || $("#cdns").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter custom department name");
		$('#alerts').modal('show');
		return false;
	}
	if($("#cdabbs").val()=="" || $("#cdabbs").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter custom department abbreviation");
		$('#alerts').modal('show');
		return false;
	}
	if($("#cdetails").val()=="" || $("#cdetails").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter company detail");
		$('#alerts').modal('show');
		return false;
	}else{
		var id=$("#cdcs").val();
		var dname=$("#cdns").val();
		var dabb=$("#cdabbs").val();
		var cid=$("#cdetails").val();
		$('#exampleModal2').modal('hide');
		$('#loading').modal('show');
		$.ajax({
		    type: "Get",
		    url: "insertCustDep",
		    data: "ID="+id+"&Dname="+dname+"&Dabb="+dabb+"&Com="+cid,
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
	if($("#cdn").val()=="" || $("#cdns").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter custom department name");
		$('#alerts').modal('show');
		return false;
	}
	if($("#cdabb").val()=="" || $("#cdabbs").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter custom department abbreviation");
		$('#alerts').modal('show');
		return false;
	}
	if($("#cdetail").val()=="" || $("#cdetails").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter company detail");
		$('#alerts').modal('show');
		return false;
	}else{
		var id=$("#id1").val();
		var dname=$("#cdn").val();
		var dabb=$("#cdabb").val();
		var cid=$("#cdetail").val();
		$('#loading').modal('show');
		$('#exampleModal').modal('hide');
		$.ajax({
		    type: "Get",
		    url: "updateCustDep",
		    data: "ID="+id+"&Dname="+dname+"&Dabb="+dabb+"&Com="+cid,
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
	$("#cdcs").val('');
	$("#cdns").val('');
	$("#cdabbs").val('');
	re();
	var s=false;
	var table = $('#dataTables-example').dataTable();
	table.fnClearTable();
	var ss=false;	 
	var table1 = $('#dataTables-example1').dataTable();
	table1.fnClearTable();
	$.ajax({
		type: "Get",
	    url: "rs/getcustdeptactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].dCode,item[i].dName,item[i].dAbbra,item[i].companyName,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].dCode+',\'' +item[i].dName+ '\',\'' +item[i].dAbbra+ '\','+item[i].cid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].dCode+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getcustdeptinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].dCode,item[i].dName,item[i].dAbbra,item[i].companyName,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].dCode+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	var id=$("#code").val();
	$.ajax({
	    type: "Get",
	    url: "deleteCustDep",
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
function relo(){
	$("#cdcs").val('');
	$("#cdns").val('');
	$("#cdabbs").val('');
	$('#loading').modal('show');
	re();
	var s=false;
	var table = $('#dataTables-example').dataTable();
	table.fnClearTable();
	var ss=false;	 
	var table1 = $('#dataTables-example1').dataTable();
	table1.fnClearTable();
	$.ajax({
		type: "Get",
	    url: "rs/getcustdeptactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].dCode,item[i].dName,item[i].dAbbra,item[i].companyName,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].dCode+',\'' +item[i].dName+ '\',\'' +item[i].dAbbra+ '\','+item[i].cid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].dCode+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getcustdeptinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].dCode,item[i].dName,item[i].dAbbra,item[i].companyName,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].dCode+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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

function active(id){
	$('#exampleModal3').modal('hide');
	$('#loading').modal('show');
	$.ajax({
	    type: "Get",
	    url: "activeIdsustDo",
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
function synchronize(){
	$('#loading').modal('show');
	$('#exampleModal').modal('hide');
	$.ajax({
	    type: "Get",
	    url: "synchronizeExcelCust",
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
	    	$("#dataes").html("Please contact system administrator");
	    	$('#msg').modal('show');
	    }
	});
}
function deleteData(id){
	$("#code").val(id);
	$("#exampleModalLabelTitle").html("Inactive custom department detail");
	$("#datas").html("Do you want to inactive?");
}
function re(){
	$.getJSON('rs/getComp', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	        	if(item.companyName.trim() !="Biocon Research Limited"){
	        		datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
	        	}
	        });
	        $("#cdetails").html(datas);
	}); 
}
</script>
</body>
</html>
