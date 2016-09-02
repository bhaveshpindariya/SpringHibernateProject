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
                    <h1 class="page-header">Agreement Attachments</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                      <div class="panel-heading headingp">
                             <button type="submit" class="btn btn-info" data-toggle="modal" data-target="#exampleModal2">Insert New Record</button>
                        	 <button type="button" class="btn btn-info btnright"  style="margin-top:-2px;" data-toggle="modal" data-target="#exampleModal3">Inactive Records</button>
                             <button type="button" class="btn btn-info btnright" style="margin-top:-2px;margin-right:5px;" onclick="synchronize()" id="synchronize">Synchronize</button>
                       </div> 
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" style="font-size:13px;">
                                     <thead>
							            <tr>
							                <th>No</th>
							                <th>Company Name</th>
							                <th>Agreement Name</th>
							                <th>Document Class</th>
							                <th>Document Type</th>
							                <th>Agreement Type Class</th>
							                <th>Mandatory</th>
							                <th>Mandatory Domestic</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                <th style="bSortable: false;">Action</th>
							            </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="agreementattachments" varStatus="status">     
							  			<tr>
							  				<td><c:out value="${agreementattachments.no}"/></td>
							            	<td><c:out value="${agreementattachments.cname}"/></td>
							            	<td><c:out value="${agreementattachments.aname}"/></td>
							                <td><c:out value="${agreementattachments.docclass}"/></td>
							                <td><c:out value="${agreementattachments.doctype}"/></td>
							                <td><c:out value="${agreementattachments.atclass}"/></td>
							                <td><c:out value="${agreementattachments.mandadory}"/></td>
							                <td><c:out value="${agreementattachments.mandadorydom}"/></td>
							                <td><c:out value="${agreementattachments.createdBy}"/></td>
							                <td><c:out value="${agreementattachments.createdDate}"/></td>
							                <td><c:out value="${agreementattachments.modifyBy}"/></td>
							                <td><c:out value="${agreementattachments.modifyDate}"/></td>
							                <td><a href="#" onclick="editData('${agreementattachments.id}','${agreementattachments.cid}','${agreementattachments.aid}','${agreementattachments.docclass}','${agreementattachments.doctype}','${agreementattachments.atclass}','${agreementattachments.mandadory}','${agreementattachments.mandadorydom}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${agreementattachments.id}')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
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
		                <th>Company Name</th>
		                <th>Agreement Name</th>
		                <th>Document Class</th>
		                <th>Document Type</th>
		                <th>Agreement Type Class</th>
		                <th>Mandatory</th>
		                <th>Mandatory Domestic</th>
		                <th>CreateBy</th>
		                <th>Create Date</th>
		                <th>ModifyBy</th>
		                <th>Modify Date</th>
						<th style="bSortable: false;">Action</th>
         			</tr>
      		   </thead>
      		   <tbody>
          			<c:forEach items="${masters}" var="agreementatta" varStatus="status">     
		  			<tr>
		  				<td><c:out value="${agreementatta.no}"/></td>
		            	<td><c:out value="${agreementatta.cname}"/></td>
		            	<td><c:out value="${agreementatta.aname}"/></td>
		                <td><c:out value="${agreementatta.docclass}"/></td>
		                <td><c:out value="${agreementatta.doctype}"/></td>
		                <td><c:out value="${agreementatta.atclass}"/></td>
		                <td><c:out value="${agreementatta.mandadory}"/></td>
		                <td><c:out value="${agreementatta.mandadorydom}"/></td>
		                <td><c:out value="${agreementatta.createdBy}"/></td>
		                <td><c:out value="${agreementatta.createdDate}"/></td>
		                <td><c:out value="${agreementatta.modifyBy}"/></td>
		                <td><c:out value="${agreementatta.modifyDate}"/></td>
		                <td><a href="#" onclick="active('${agreementatta.id}')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a></td>
		            </tr>   
					</c:forEach>
      			</tbody>
           </table>
        </div>
      </div>
    </div>
  </div>
</div>
 
 <div class="modal fade" id="exampleModal" tabindex="-1" data-backdrop="static" data-keyboard="false" style="top:30px;">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span >&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Edit custom department detail</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">Id</label>
            <input type="text" class="form-control" id="id" name="id"disabled>
            <input type="text" class="form-control" id="id1" name="id1" style="display:none;">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Company name</label>
            <select class="form-control" id="cid">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Agreement type</label>
             <select class="form-control" id="agree">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Doc Class</label>
             <input type="text" class="form-control" id="doc" name="doc">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Doc Type</label>
             <input type="text" class="form-control" id="dot" name="dot">
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Is Agreement Type Class</label>
             <select class="form-control" id="iatc">
              	<option value="true">True</option>
              	<option value="false">False</option>
  			</select>
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Is Mandatory</label>
             <select class="form-control" id="im">
              	<option value="true">True</option>
              	<option value="false">False</option>
  			</select>
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Is Mandatory Domestic</label>
             <select class="form-control" id="imd">
              	<option value="true">True</option>
              	<option value="false">False</option>
  			</select>
          </div>
         </form>
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" onclick="updates()" id="save">Save</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="relo()">Close</button>
        
      </div>
    </div>
  </div>
</div>

 <div class="modal fade" id="exampleModal2" tabindex="-1" data-backdrop="static" data-keyboard="false" style="top:50px;">
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
            <select class="form-control" id="cids">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Agreement type</label>
             <select class="form-control" id="agrees">
            </select>
          </div>
         <div class="form-group">
            <label for="message-text" class="control-label">Doc Class</label>
             <input type="text" class="form-control" id="docs" name="docs">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Doc Type</label>
             <input type="text" class="form-control" id="dots" name="dots">
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Is Agreement Type Class</label>
             <select class="form-control" id="iatcs">
              	<option value="true">True</option>
              	<option value="false">False</option>
  			</select>
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Is Mandatory</label>
             <select class="form-control" id="ims">
              	<option value="true">True</option>
              	<option value="false">False</option>
  			</select>
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Is Mandatory Domestic</label>
             <select class="form-control" id="imds">
              	<option value="true">True</option>
              	<option value="false">False</option>
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
	  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 12 ] } ],
	  	 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
		}); 
	   $('#dataTables-example1').DataTable({
		  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 12 ] } ],
		  	 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
	   }); 
	   
    
    $.getJSON('rs/getComp', function(data){
   	    var datas='';
        $.each(data, function(index, item){
       	 datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
        });
        $("#cids").html(datas);
        var cname=$("#cids").val();
        $.getJSON('rs/getAgreementForCompany',{
        	Company_name : cname
        	},	function(data){
        	var dataes='';
   	        $.each(data, function(index, item){
   	       	 dataes+='<option value='+item.id+'>'+item.agreementtype+'</option>';
   	        });
   	        $("#agrees").html(dataes);
   	    }); 
	});
	
	$("#cids").change(function(){
		var cname=$("#cids").val();
		$.getJSON('rs/getAgreementForCompany',{
	  	Company_name : cname
	  	},	function(data){
	  	var dataes='';
		  $.each(data, function(index, item){
		      	 dataes+='<option value='+item.id+'>'+item.agreementtype+'</option>';
		  });
		 $("#agrees").html(dataes);
		}); 
	});
	
	$("#cid").change(function(){
	   	var cname=$("#cid").val();
	   	$.getJSON('rs/getAgreementForCompany',{
	  	Company_name : cname
	  	},	function(data){
	  	  var dataes='';
		        $.each(data, function(index, item){
		       	 dataes+='<option value='+item.id+'>'+item.agreementtype+'</option>';
		        });
		        $("#agree").html(dataes);
		    }); 
	});

 });

 function editData(id,cid,aid,docclass,doctype,atclass,mandadory,mandadorydom){
		$("#id").val(id);
		$("#id1").val(id);
		
		$.getJSON('rs/getComp', function(data){
		   	 var datas='';
		     $.each(data, function(index, item){
			     if(item.companyCode==cid){
			     	datas+='<option value='+item.companyCode+' selected>'+item.companyName+'</option>';
			     }else{
			     	datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
			     }
		     });
		     $("#cid").html(datas);
		     
		     var cnames=$("#cid").val();
		     $.getJSON('rs/getAgreementForCompany',{
		        	Company_name : cnames
		        		},	function(data){
			   	    var datas='';
			        $.each(data, function(index, item){
			        	if(item.id==aid){
			       	 		datas+='<option value='+item.id+' selected>'+item.agreementtype+'</option>';
			        	}else{
			        		datas+='<option value='+item.id+'>'+item.agreementtype+'</option>';
			        	}
			        });
			        $("#agree").html(datas);
			 });
		});
		$("#doc").val(docclass);
		$("#dot").val(doctype);
		$("#iatc").val(atclass);
		$("#im").val(mandadorydom);
		$("#imd").val(mandadorydom);
		
}
 function re(){
	    $.getJSON('rs/getComp', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	       	 datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
	        });
	        $("#cids").html(datas);
	        var cname=$("#cids").val();
	        $.getJSON('rs/getAgreementForCompany',{
	        	Company_name : cname
	        		},	function(data){
	        	var dataes='';
	   	        $.each(data, function(index, item){
	   	       	 dataes+='<option value='+item.id+'>'+item.agreementtype+'</option>';
	   	        });
	   	        $("#agrees").html(dataes);
	   	    }); 
		});
		 $("#cids").change(function(){
		 	var cname=$("#cids").val();
		 	$.getJSON('rs/getAgreementForCompany',{
		    	Company_name : cname
		    		},	function(data){
		    	var dataes='';
			        $.each(data, function(index, item){
			       	 dataes+='<option value='+item.id+'>'+item.agreementtype+'</option>';
			        });
			        $("#agrees").html(dataes);
			    });
		 });
		$("#cid").change(function(){
		   	var cname=$("#cid").val();
		   	$.getJSON('rs/getAgreementForCompany',{
	        	Company_name : cname
	        		},	function(data){
	        	var dataes='';
	   	        $.each(data, function(index, item){
	   	       	 dataes+='<option value='+item.id+'>'+item.agreementtype+'</option>';
	   	        });
	   	        $("#agree").html(dataes);
	   	    });
	   });
		
		var list="<option value='true' selected>True</option>";
		list+="<option value='false'>False</option>";
		$("#iatcs").html(list);
		$("#ims").html(list);
		$("#imds").html(list);
 }
 
 function reload(){
		$('#msg').modal('hide');
		$('#loading').modal('show');
		$("#docs").val('');
		$("#dots").val('');
		re();
		var s=false;
		var table = $('#dataTables-example').dataTable();
		table.fnClearTable();
		var ss=false;	 
		var table1 = $('#dataTables-example1').dataTable();
		table1.fnClearTable();
		$.ajax(
		  {
			type: "Get",
		    url: "rs/getActiveAgreementattachments",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		s=true;
	           		table.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].docclass,item[i].doctype,item[i].atclass,item[i].mandadory,item[i].mandadorydom,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',' +item[i].cid+ ','+item[i].aid+',\'' +item[i].docclass+ '\',\'' +item[i].doctype+ '\',\'' +item[i].atclass+ '\',\'' +item[i].mandadory+ '\',\'' +item[i].mandadorydom+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);          
		        }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) 
	        {
	            alert(errorThrown);
	        }
	    });
		$.ajax({
			type: "Get",
		    url: "rs/getInActiveAgreementattachments",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	           		ss=true;
	           		table1.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].docclass,item[i].doctype,item[i].atclass,item[i].mandadory,item[i].mandadorydom,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);          
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

function relo(){
		$('#loading').modal('show');
		$("#docs").val('');
		$("#dots").val('');
		re();
		var s=false;
		var table = $('#dataTables-example').dataTable();
		table.fnClearTable();
		var ss=false;	 
		var table1 = $('#dataTables-example1').dataTable();
		table1.fnClearTable();
		$.ajax(
		  {
			type: "Get",
		    url: "rs/getActiveAgreementattachments",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		s=true;
	           		table.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].docclass,item[i].doctype,item[i].atclass,item[i].mandadory,item[i].mandadorydom,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',' +item[i].cid+ ','+item[i].aid+',\'' +item[i].docclass+ '\',\'' +item[i].doctype+ '\',\'' +item[i].atclass+ '\',\'' +item[i].mandadory+ '\',\'' +item[i].mandadorydom+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);        
			    }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) 
	        {
	            alert(errorThrown);
	        }
	    });
		$.ajax({
			type: "Get",
		    url: "rs/getInActiveAgreementattachments",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	           		ss=true;
	           		table1.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].docclass,item[i].doctype,item[i].atclass,item[i].mandadory,item[i].mandadorydom,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);          
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

function refarance(){
		$('#deletbox').modal('hide');
		$('#loading').modal('show');
		$("#docs").val('');
		$("#dots").val('');
		re();
		var s=false;
		var table = $('#dataTables-example').dataTable();
		table.fnClearTable();
		var ss=false;	 
		var table1 = $('#dataTables-example1').dataTable();
		table1.fnClearTable();
		$.ajax(
		  {
			type: "Get",
		    url: "rs/getActiveAgreementattachments",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		s=true;
	           		table.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].docclass,item[i].doctype,item[i].atclass,item[i].mandadory,item[i].mandadorydom,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',' +item[i].cid+ ','+item[i].aid+',\'' +item[i].docclass+ '\',\'' +item[i].doctype+ '\',\'' +item[i].atclass+ '\',\'' +item[i].mandadory+ '\',\'' +item[i].mandadorydom+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);        
			    }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) 
	        {
	            alert(errorThrown);
	        }
	    });
		$.ajax({
			type: "Get",
		    url: "rs/getInActiveAgreementattachments",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	           		ss=true;
	           		table1.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].docclass,item[i].doctype,item[i].atclass,item[i].mandadory,item[i].mandadorydom,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);          
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
		$("#docs").val('');
		$("#dots").val('');
		re();
	}

function valides(){
	if($("#agrees").val()=="" || $("#agrees").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter agreement type name");
		$('#alerts').modal('show');
		return false;
	}
	if($("#docs").val()=="" || $("#docs").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter doc class");
		$('#alerts').modal('show');
		return false;
	}else{
		var agid=$("#agrees").val();
		var docclasse=$("#docs").val();
		var coctypes=$("#dots").val();
		var iatc=$("#iatcs").val();
		var im=$("#ims").val();
		var imd=$("#imds").val();
		var docclass=docclasse.replace(/&/g, " bhai ");
		var coctype = coctypes.replace(/&/g, " bhai ");
		$('#exampleModal2').modal('hide');
		$('#loading').modal('show');
		$.ajax({
		    type: "Get",
		    url: "insertAgreementattachment",
		    data: "Agid="+agid+"&Docc="+docclass+"&Doct="+coctype+"&Iatc="+iatc+"&Im="+im+"&Imd="+imd,
		    contentType: "application/json; charset=utf-8",
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

function updates(){
	if($("#agree").val()=="" || $("#agree").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter agreement type name");
		$('#alerts').modal('show');
		return false;
	}
	if($("#doc").val()=="" || $("#doc").val()=="null"){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter doc class");
		$('#alerts').modal('show');
		return false;
	}else{
		var id=$("#id1").val();
		var agid=$("#agree").val();
		var docclasse=$("#doc").val();
		var coctypes=$("#dot").val();
		var iatc=$("#iatc").val();
		var im=$("#im").val();
		var imd=$("#imd").val();
		var docclass=docclasse.replace(/&/g, " bhai ");
		var coctype = coctypes.replace(/&/g, " bhai ");
		$('#exampleModal').modal('hide');
		$('#loading').modal('show');
		$.ajax({
		    type: "Get",
		    url: "updateAgreementattachment",
		    data: "Id="+id+"&Agid="+agid+"&Docc="+docclass+"&Doct="+coctype+"&Iatc="+iatc+"&Im="+im+"&Imd="+imd,
		    contentType: "application/json; charset=utf-8",
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

function synchronize(){
			$('#loading').modal('show');
			$('#exampleModal').modal('hide');
			$.ajax({
			    type: "Get",
			    url: "synchronizeExcelAgreementAttachments",
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
 function deletedata(){
		$('#deletbox').modal('hide');
		$('#loading').modal('show');
		var id=$("#id1").val();
		$.ajax({
			    type: "Get",
			    url: "deleteagreementattachments",
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
		    url: "activeagreementattachments",
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

function deleteData(id){
	 	$("#id1").val(id);
		$("#exampleModalLabelTitle").html("Inactive vertical legal manager detail");
		$("#datas").html("Do you want to inactive?");
	}
 </script>
</body>
</html>
