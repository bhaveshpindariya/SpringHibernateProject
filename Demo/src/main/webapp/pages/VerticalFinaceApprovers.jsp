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
                    <h1 class="page-header">Other Approvers Details</h1>
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
							                <th>No</th>
							                <th>Employee Id</th>
							                <th>Employee Name</th>
							                <th>Vertical Name</th>
							                <th>Agreement Name</th>
							                <th>Company Name</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                <th style="bSortable: false;">Action</th>
							           </tr>
							        </thead>
							        <tbody>
							           <c:forEach items="${master}" var="empver" varStatus="status">     
								  			<tr>
								            	<td><c:out value="${empver.no}"/></td>
								            	<td><c:out value="${empver.eid}"/></td>
								            	<td><c:out value="${empver.ename}"/></td>
								            	<td><c:out value="${empver.vname}"/></td>
								            	<td><c:out value="${empver.aname}"/></td>
								            	<td><c:out value="${empver.cname}"/></td>
								            	<td><c:out value="${empver.createdBy}"/></td>
								            	<td><c:out value="${empver.createdDate}"/></td>
							                	<td><c:out value="${empver.modifyBy}"/></td>
							                	<td><c:out value="${empver.modifyDate}"/></td>
							                	<td><a href="#" onclick="editData('${empver.id}','${empver.eid}','${empver.vid}','${empver.aid}','${empver.cid}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${empver.id}')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
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
		<span>Copyright � 1995-2015 SoluSoft Technologies Pvt. Ltd.</span>
		</footer>
	</div>
 </div>
<div class="modal fade" id="exampleModal" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" ><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Edit other approvers detail</h4>
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
            <label for="message-text" class="control-label">Employee name</label>
            <select class="form-control" id="loc">
            </select>
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Vertical name</label>
             <select class="form-control" id="sit">
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

 <div class="modal fade" id="exampleModal2" tabindex="-1"  data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" onclick="rese()"><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Add other approvers detail</h4>
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
             <label for="message-text" class="control-label">Employee name</label>
            <select class="form-control" id="locs">
            </select>
        </div>
         <div class="form-group">
            <label for="message-text" class="control-label" >Vertical name</label>
             <select class="form-control" id="sits">
            </select>
           </div>
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="valides()" id="savepr">Save</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="relo()">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="deletbox" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
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
		                <th>Employee Id</th>
		                <th>Employee Name</th>
		                <th>Vertical Name</th>
		                <th>Agreement Name</th>
		                <th>Company Name</th>
		                <th>CreateBy</th>
		                <th>Create Date</th>
		                <th>ModifyBy</th>
		                <th>Modify Date</th>
		                <th style="bSortable: false;">Action</th>
		           </tr>
      		   </thead>
      		   <tbody>
          			 <c:forEach items="${masters}" var="vfappro" varStatus="status">     
			  			<tr>
			            	<td><c:out value="${vfappro.no}"/></td>
			            	<td><c:out value="${vfappro.eid}"/></td>
			            	<td><c:out value="${vfappro.ename}"/></td>
			            	<td><c:out value="${vfappro.vname}"/></td>
			            	<td><c:out value="${vfappro.aname}"/></td>
			            	<td><c:out value="${vfappro.cname}"/></td>
			            	<td><c:out value="${vfappro.createdBy}"/></td>
			            	<td><c:out value="${vfappro.createdDate}"/></td>
			                <td><c:out value="${vfappro.modifyBy}"/></td>
			                <td><c:out value="${vfappro.modifyDate}"/></td>
			                <td><a href="#" onclick="active('${vfappro.id}')"  title="Active" data-toggle="modal" rel="tooltip"><span style="color:green; font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a></td>
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
		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 10 ] } ],
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
	});
   $('#dataTables-example1').DataTable({
		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 10 ] } ],
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
	        $.getJSON('rs/getEmployeeForCompany',{
	 	      	Company_name : cname
	 	    },function(data){
	 	    	var datas='';
	               $.each(data, function(index, item){
	              	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
	               });
	               $("#locs").html(datas);
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
   		$.getJSON('rs/getEmployeeForCompany',{
	      	Company_name : cname
	    },function(data){
	    	var datas='';
            $.each(data, function(index, item){
                datas+='<option value='+item.empid+'>'+item.name+'</option>';
            });
            $("#locs").html(datas);
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
	   	$.getJSON('rs/getEmployeeForCompany',{
		      	Company_name : cname
		    },function(data){
		    	var datas='';
	            $.each(data, function(index, item){
	                datas+='<option value='+item.empid+'>'+item.name+'</option>';
	            });
	            $("#loc").html(datas);
	    	});
	   });
   $.getJSON('rs/getVer', function(data){
   	 var datas='';
        $.each(data, function(index, item){
       	 datas+='<option value='+item.id+'>'+item.vname+'</option>';
        });
        $("#sits").html(datas);
    }); 
	 
});
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
	        $.getJSON('rs/getEmployeeForCompany',{
	 	      	Company_name : cname
	 	    },function(data){
	 	    	var datas='';
	               $.each(data, function(index, item){
	              	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
	               });
	               $("#locs").html(datas);
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
   		$.getJSON('rs/getEmployeeForCompany',{
	      	Company_name : cname
	    },function(data){
	    	var datas='';
            $.each(data, function(index, item){
                datas+='<option value='+item.empid+'>'+item.name+'</option>';
            });
            $("#locs").html(datas);
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
	   	$.getJSON('rs/getEmployeeForCompany',{
		      	Company_name : cname
		    },function(data){
		    	var datas='';
	            $.each(data, function(index, item){
	                datas+='<option value='+item.empid+'>'+item.name+'</option>';
	            });
	            $("#loc").html(datas);
	    	});
	   });
   $.getJSON('rs/getVer', function(data){
   	 var datas='';
        $.each(data, function(index, item){
       	 datas+='<option value='+item.id+'>'+item.vname+'</option>';
        });
        $("#sits").html(datas);
    }); 
}
function editData(id,eid,vid,aid,cid){
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
	     
	     $.getJSON('rs/getEmployeeForCompany',{
	 	    Company_name : cnames
	 	 },function(data){
	   	    var datas='';
	   	    $.each(data, function(index, item){
		   	    if(item.empid==eid){
		   	       datas+='<option value='+item.empid+' selected>'+item.name+'</option>';
		   	    }else{
		   	       datas+='<option value='+item.empid+'>'+item.name+'</option>';
		   	    }
	   	    });
	   	    $("#loc").html(datas);
	 	 });
	});
	$.getJSON('rs/getVer', function(data){
   	 var datas='';
        $.each(data, function(index, item){
        	if(item.id==vid){
        		datas+='<option value='+item.id+' selected>'+item.vname+'</option>';
        	}else{
        		datas+='<option value='+item.id+'>'+item.vname+'</option>';
        	}
        });
        $("#sit").html(datas);
    }); 
		
}
function reload(){
	$('#msg').modal('hide');
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
	    url: "rs/getagreefinacactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].vname,item[i].aname,item[i].cname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].eid+',' +item[i].vid+ ',' +item[i].aid+ ',' +item[i].cid+ ')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getagreefinacinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].vname,item[i].aname,item[i].cname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	    url: "activeIdforVfm",
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


function valides(){
	if($("#locs").val()=="" || $("#locs").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter employee detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#sits").val()=="" || $("#sits").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter vertical detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#cids").val()=="" || $("#cids").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter company detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#agrees").val()=="" || $("#agrees").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter agreement detail");
    	$('#alerts').modal('show');
		return false;
	}else{
		var emp=$("#locs").val();
		var vid=$("#sits").val();
		var aid=$("#agrees").val();
		$('#exampleModal2').modal('hide');
		$('#loading').modal('show');
		$.ajax({
		    type: "Get",
		    url: "insertVerFin",
		    data: "Emp="+emp+"&Vid="+vid+"&Aid="+aid,
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
	if($("#loc").val()=="" || $("#loc").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter employee detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#sit").val()=="" || $("#sit").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter vertical detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#cid").val()=="" || $("#cid").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter company detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#agree").val()=="" || $("#agree").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter agreement detail");
    	$('#alerts').modal('show');
		return false;
	}else{
		var id=$("#id1").val();
		var emp=$("#loc").val();
		var vid=$("#sit").val();
		var aid=$("#agree").val();
		$('#loading').modal('show');
		$('#exampleModal').modal('hide');
		$.ajax({
		    type: "Get",
		    url: "updateVerFin",
		    data: "ID="+id+"&Emp="+emp+"&Vid="+vid+"&Aid="+aid,
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
function rese(){
	re();
}
function refarance(){
	$('#deletbox').modal('hide');
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
	    url: "rs/getagreefinacactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].vname,item[i].aname,item[i].cname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].eid+',' +item[i].vid+ ',' +item[i].aid+ ',' +item[i].cid+ ')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getagreefinacinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].vname,item[i].aname,item[i].cname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	var id=$("#id1").val();
	$.ajax({
		    type: "Get",
		    url: "deleteVerFin",
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
	    url: "rs/getagreefinacactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].vname,item[i].aname,item[i].cname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].eid+',' +item[i].vid+ ',' +item[i].aid+ ',' +item[i].cid+ ')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getagreefinacinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].vname,item[i].aname,item[i].cname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
function synchronize(){
	$('#loading').modal('show');
	$('#exampleModal').modal('hide');
	$.ajax({
	    type: "Get",
	    url: "synchronizeExcelOtherApprovers",
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
	$("#id1").val(id);
	$("#exampleModalLabelTitle").html("Inactive vertical finance manager detail");
	$("#datas").html("Do you want to inactive?");
}
</script>
</body>
</html>
