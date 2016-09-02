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
                    <h1 class="page-header">Employee Site Vertical Details</h1>
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
							                <th>Employee Id</th>
							                <th>Employee Name</th>
							                <th>Site</th>
							                <th>Site Alias</th>
							                <th>Vertical Name</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                <th style="bSortable: false;">Action</th>
							                
							           </tr>
							        </thead>
							        <tbody>
							           <c:forEach items="${master}" var="empsit" varStatus="status">     
								  			<tr>
								            	<td><c:out value="${empsit.no}"/></td>
								            	<td><c:out value="${empsit.eid}"/></td>
								            	<td><c:out value="${empsit.ename}"/></td>
								            	<td><c:out value="${empsit.sname}"/></td>
								                <td><c:out value="${empsit.salians}"/></td> 
								                <td><c:out value="${empsit.vname}"/></td> 
							               	 	<td><c:out value="${empsit.createdBy}"/></td>
								                <td><c:out value="${empsit.createdDate}"/></td>
							                	<td><c:out value="${empsit.modifyBy}"/></td>
							                	<td><c:out value="${empsit.modifyDate}"/></td>
								                <td><a href="#" onclick="editData('${empsit.id}','${empsit.eid}','${empsit.sid}','${empsit.vid}','${empsit.cid}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${empsit.id}')"  title="Delete" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
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
        <button type="button" class="close" data-dismiss="modal" ><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Edit employee site detail</h4>
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
            <select class="form-control" id="com">
            </select>
        </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Employee name</label>
            <select class="form-control" id="loc">
            </select>
          </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Site alias</label>
             <select class="form-control" id="sit">
            </select>
            <select class="form-control" id="sites" style="display:none;">
            </select>
           </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Vertical Name</label>
             <select class="form-control" id="ver">
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
        <h4 class="modal-title" id="exampleModalLabel">Add employee site detail</h4>
      </div>
      <div class="modal-body">
        <form>
        <div class="form-group">
             <label for="message-text" class="control-label">Company name</label>
            <select class="form-control" id="coms">
            </select>
        </div>
        <div class="form-group">
             <label for="message-text" class="control-label">Employee name</label>
            <select class="form-control" id="locs">
            </select>
        </div>
         <div class="form-group">
            <label for="message-text" class="control-label">Site alias</label>
             <select class="form-control" id="sits">
            </select>
            <select class="form-control" id="sitess" style="display:none;">
            </select>
           </div>
           <div class="form-group">
            <label for="message-text" class="control-label">Vertical Name</label>
             <select class="form-control" id="vers">
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
		                <th>Site</th>
		                <th>Site Alias</th>
		                <th>Vertical Name</th>
		                <th>CreateBy</th>
		                <th>Create Date</th>
		                <th>ModifyBy</th>
		                <th>Modify Date</th>
              			<th style="bSortable: false;">Action</th>
         			</tr>
      		   </thead>
      		   <tbody>
          			<c:forEach items="${masters}" var="esd" varStatus="status">     
 						<tr>
           					<td><c:out value="${esd.no}"/></td>
			            	<td><c:out value="${esd.eid}"/></td>
			            	<td><c:out value="${esd.ename}"/></td>
			            	<td><c:out value="${esd.sname}"/></td>
			                <td><c:out value="${esd.salians}"/></td> 
			                <td><c:out value="${esd.vname}"/></td> 
			                <td><c:out value="${esd.createdBy}"/></td>
			                <td><c:out value="${esd.createdDate}"/></td>
			                <td><c:out value="${esd.modifyBy}"/></td>
			                <td><c:out value="${esd.modifyDate}"/></td>
               				<td><a href="#" onclick="active('${esd.id}')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a></td>
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
	        $("#coms").html(datas);
	        var cname=$("#coms").val();
	        
	        $.getJSON('rs/getEmployeeForCompany',{
	 	      	Company_name : cname
	 	    },function(data){
	 	    	var datas='';
	               $.each(data, function(index, item){
	              	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
	               });
	               $("#locs").html(datas);
	         }); 
	        
	        $.getJSON('rs/getSitComp',{
	        	Company_name : cname
	        },function(data){
	        	var datas='';
	        	$.each(data, function(index, item){
	        	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
	        	});
	        	$("#sits").html(datas);
	        }); 
	}); 
   
   $("#coms").change(function(){
    	var cname=$("#coms").val();
    	
    	$.getJSON('rs/getEmployeeForCompany',{
 	      	Company_name : cname
 	    },function(data){
 	    	var datas='';
               $.each(data, function(index, item){
              	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
               });
               $("#locs").html(datas);
         
    	
	        $.getJSON('rs/getSitComp',{
	        	Company_name : cname
	        },function(data){
	        	var datas='';
	        	$.each(data, function(index, item){
	        	   if(item !=null){
	        			datas+='<option value='+item.id+'>'+item.sname+'</option>';
	        	   }
	        	});
	        	$("#sits").html(datas);
	        });  
 	   }); 
 	});
    
    $("#com").change(function(){
 	   var cnames=$("#com").val();
 	   
 	  $.getJSON('rs/getEmployeeForCompany',{
	      	Company_name : cnames
	    },function(data){
	    	var datas='';
             $.each(data, function(index, item){
            	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
             });
             $("#loc").html(datas);
      
 	   
		   $.getJSON('rs/getSitComp',{
		      	Company_name : cnames
		    },function(data){
		      var datas='';
		      $.each(data, function(index, item){
		      	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
		      });
		      $("#sit").html(datas);
		    });
		   
	    }); 
 	});
	$.getJSON('rs/getVer', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	       	 datas+='<option value='+item.id+'>'+item.vname+'</option>';
	        });
	       var  data='<option value=0 >Please select</option>';
	        $("#vers").html(data);
	        $("#vers").append(datas);
	    });
	 
});

function re(){
	$.getJSON('rs/getComp', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	       	 datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
	        });
	        $("#coms").html(datas);
	        var cname=$("#coms").val();
	        
	        $.getJSON('rs/getEmployeeForCompany',{
	 	      	Company_name : cname
	 	    },function(data){
	 	    	var datas='';
	               $.each(data, function(index, item){
	              	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
	               });
	               $("#locs").html(datas);
	         }); 
	        
	        $.getJSON('rs/getSitComp',{
	        	Company_name : cname
	        },function(data){
	        	var datas='';
	        	$.each(data, function(index, item){
	        	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
	        	});
	        	$("#sits").html(datas);
	        }); 
	}); 
  
  $("#coms").change(function(){
   	var cname=$("#coms").val();
   	
   	$.getJSON('rs/getEmployeeForCompany',{
	      	Company_name : cname
	    },function(data){
	    	var datas='';
              $.each(data, function(index, item){
             	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
              });
              $("#locs").html(datas);
        
   	
	        $.getJSON('rs/getSitComp',{
	        	Company_name : cname
	        },function(data){
	        	var datas='';
	        	$.each(data, function(index, item){
	        	   if(item !=null){
	        			datas+='<option value='+item.id+'>'+item.sname+'</option>';
	        	   }
	        	});
	        	$("#sits").html(datas);
	        });  
	   }); 
	});
   
   $("#com").change(function(){
	   var cnames=$("#com").val();
	   
	  $.getJSON('rs/getEmployeeForCompany',{
	      	Company_name : cnames
	    },function(data){
	    	var datas='';
            $.each(data, function(index, item){
           	 datas+='<option value='+item.empid+'>'+item.name+'</option>';
            });
            $("#loc").html(datas);
     
	   
		   $.getJSON('rs/getSitComp',{
		      	Company_name : cnames
		    },function(data){
		      var datas='';
		      $.each(data, function(index, item){
		      	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
		      });
		      $("#sit").html(datas);
		    });
		   
	    }); 
	});
	$.getJSON('rs/getVer', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	       	 datas+='<option value='+item.id+'>'+item.vname+'</option>';
	        });
	       var  data='<option value=0 >Please select</option>';
	        $("#vers").html(data);
	        $("#vers").append(datas);
	    });
}

function editData(pid,eid,sid,vid,cid){
	$("#id").val(pid);
	$("#id1").val(pid);
	$.getJSON('rs/getComp', function(data){
	   	 var datas='';
	        $.each(data, function(index, item){
	        	if(item.companyCode==cid){
	        		datas+='<option value='+item.companyCode+' selected>'+item.companyName+'</option>';
	        	}else{
	        		datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
	        	}
	        });
	        $("#com").html(datas);
	        var cnames=$("#com").val();
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
	   	   
	            $.getJSON('rs/getSitComp',{
		 	      	Company_name : cnames
		 	    },function(data){
		 	      var datas='';
		 	      $.each(data, function(index, item){
		   	        	if(item.id==sid){
		   	        		datas+='<option value='+item.id+' selected>'+item.sname+'</option>';
		   	        	}else{
		   	        		datas+='<option value='+item.id+'>'+item.sname+'</option>';
		   	        	}
		   	        });
		   	        $("#sit").html(datas);
		   	     }); 
	 	   }); 
	});
	   
		
		$.getJSON('rs/getVer', function(data){
		   	 var datas='';
		   	 if(vid == 0){
		         datas+='<option value=0 selected>Please select</option>';
		        }else{
		         datas+='<option value=0>Please select</option>';
		        }
		        $.each(data, function(index, item){
		        	if(item.id==vid){
		        		datas+='<option value='+item.id+' selected>'+item.vname+'</option>';
		        	}else{
		        		datas+='<option value='+item.id+'>'+item.vname+'</option>';
		        	}
		        });
		        $("#ver").html(datas);
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
	    url: "rs/getesvactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].sname,item[i].salians,item[i].vname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].eid+','+item[i].sid+','+item[i].vid+','+item[i].cid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getesvinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].sname,item[i].salians,item[i].vname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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


function valides(){
	if($("#locs").val()=="" || $("#locs").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter employee detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#sits").val()=="" || $("#sits").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter site detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#vers").val()=="" || $("#vers").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter vertical detail");
    	$('#alerts').modal('show');
		return false;
	}else{
		var emp=$("#locs").val();
		var sit=$("#sits").val();
		var vid=$("#vers").val();
		$('#exampleModal2').modal('hide');
		$('#loading').modal('show');
		$.ajax({
		    type: "Get",
		    url: "insertEmpSitVer",
		    data: "Emp="+emp+"&Sit="+sit+"&Vid="+vid,
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
		$("#dataes1").html("Please enter site detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#ver").val()=="" || $("#ver").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter vertical detail");
    	$('#alerts').modal('show');
		return false;
	}else{
		var id=$("#id1").val();
		var emp=$("#loc").val();
		var sit=$("#sit").val();
		var vid=$("#ver").val();
		$('#loading').modal('show');
		$('#exampleModal').modal('hide');
		$.ajax({
		    type: "Get",
		    url: "updateEmpSitVer",
		    data: "ID="+id+"&Emp="+emp+"&Sit="+sit+"&Vid="+vid,
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
	re();
	var s=false;
	var table = $('#dataTables-example').dataTable();
	table.fnClearTable();
	var ss=false;	 
	var table1 = $('#dataTables-example1').dataTable();
	table1.fnClearTable();
	$.ajax({
		type: "Get",
	    url: "rs/getesvactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].sname,item[i].salians,item[i].vname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].eid+','+item[i].sid+','+item[i].vid+','+item[i].cid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getesvinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].sname,item[i].salians,item[i].vname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
		    url: "deleteEmpSitVer",
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
function rese(){
	re();
}
function active(id){
	$('#exampleModal3').modal('hide');
	$('#loading').modal('show');
	$.ajax({
	    type: "Get",
	    url: "activeIdEsVer",
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
	    url: "rs/getesvactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].sname,item[i].salians,item[i].vname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].eid+','+item[i].sid+','+item[i].vid+','+item[i].cid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getesvinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].eid,item[i].ename,item[i].sname,item[i].salians,item[i].vname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	$("#exampleModalLabelTitle").html("Inactive employee site detail");
	$("#datas").html("Do you want to inactive?");
}
</script>
</body>
</html>
