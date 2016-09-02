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
                    <h1 class="page-header">SAP Department To Custom Department Details</h1>
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
							                <th>Department Code</th>
							                <th>Department Name</th>
							                <th>Custom Department Name</th>
							                <th>Company Name</th>
							                <th>Vertical Name</th>
							                <th>Site Name</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                <th style="bSortable: false;">Action</th>
							                
							           </tr>
							        </thead>
							        <tbody>
							           <c:forEach items="${master}" var="dcust" varStatus="status">     
								  			<tr>
								            	<td><c:out value="${dcust.no}"/></td>
								            	<td><c:out value="${dcust.departCode}"/></td>
								            	<td><c:out value="${dcust.dename}"/></td>
								            	<td><c:out value="${dcust.custdename}"/></td> 
								            	<td><c:out value="${dcust.cname}"/></td> 
								            	<td><c:out value="${dcust.vname}"/></td> 
								            	<td><c:out value="${dcust.sname}"/></td> 
							                	<td><c:out value="${dcust.createdBy}"/></td>
								                <td><c:out value="${dcust.createdDate}"/></td>
							                	<td><c:out value="${dcust.modifyBy}"/></td>
							                	<td><c:out value="${dcust.modifyDate}"/></td>
								                <td><a href="#" onclick="editData('${dcust.id}','${dcust.departCode}','${dcust.cudtdepartCode}','${dcust.cid}','${dcust.vid}','${dcust.sid}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${dcust.id}')"  title="Delete" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
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
        <h4 class="modal-title" id="exampleModalLabel">Edit SAP department to custom department detail</h4>
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
            <label for="message-text" class="control-label">Department name</label>
            <select class="form-control" id="loc">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Custom department name</label>
             <select class="form-control" id="sit">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Vertical name</label>
             <select class="form-control" id="ver">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Site name</label>
             <select class="form-control" id="site">
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
    <div class="modal-content" style="width:500px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" onclick="rese()"><span>&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Add SAP department to custom department detail</h4>
      </div>
      <div class="modal-body">
        <form>
         <div class="form-group">
            <label for="message-text" class="control-label">Company name</label>
            <select class="form-control" id="coms">
            </select>
          </div>
        <div class="form-group">
            <label for="message-text" class="control-label">Department name</label>
            <select class="form-control" id="locs">
            </select>
        </div>
        <div class="form-group">
            <label for="message-text" class="control-label">Custom department name</label>
            <select class="form-control" id="sits">
            </select>
        </div>
        <div class="form-group">
            <label for="message-text" class="control-label">Vertical name</label>
             <select class="form-control" id="vers">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Site name</label>
             <select class="form-control" id="sites">
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
    <div class="modal-content" style="width:500px;">
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
		                <th>Department Code</th>
		                <th>Department Name</th>
		                <th>Custom Department Name</th>
		                <th>Company Name</th>
		                <th>Vertical Name</th>
						<th>Site Name</th>
		                <th>CreateBy</th>
		                <th>Create Date</th>
		                <th>ModifyBy</th>
		                <th>Modify Date</th>
              			<th style="bSortable: false;">Action</th>
         			</tr>
      		   </thead>
      		   <tbody>
          			<c:forEach items="${masters}" var="custdepart" varStatus="status">     
 						<tr>
           					<td><c:out value="${custdepart.no}"/></td>
			            	<td><c:out value="${custdepart.departCode}"/></td>
			            	<td><c:out value="${custdepart.dename}"/></td>
			            	<td><c:out value="${custdepart.custdename}"/></td> 
			            	<td><c:out value="${custdepart.cname}"/></td> 
			            	<td><c:out value="${custdepart.vname}"/></td> 
							<td><c:out value="${custdepart.sname}"/></td> 
			                <td><c:out value="${custdepart.createdBy}"/></td>
			                <td><c:out value="${custdepart.createdDate}"/></td>
			                <td><c:out value="${custdepart.modifyBy}"/></td>
			                <td><c:out value="${custdepart.modifyDate}"/></td>
               				<td><a href="#" onclick="active('${custdepart.id}')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a></td>
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
		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 11 ] } ],
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
	});
   $('#dataTables-example1').DataTable({
		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 11 ] } ],
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
	});
   
    $.getJSON('rs/getComp', function(data){
	   	var datas='';
	    $.each(data, function(index, item){
	    	if(item.companyName.trim() !="Biocon Research Limited"){
        		datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
        	}
	    });
	    $("#coms").html(datas);
	        
	    var cname=$("#coms").val();
	    $.getJSON('rs/getDeptCompany',{
	       Company_code : cname
	    },function(data){
	        var dataes='';
	   	    $.each(data, function(index, item){
	   	       dataes+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
	   	    });
	   	    $("#locs").html(dataes);
	   
	   	 	$.getJSON('rs/getCustDepForCompany',{
		       Company_code : cname
		    },function(data){
		        var datas='';
		   	    $.each(data, function(index, item){
		        		datas+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
		        });
		        $("#sits").html(datas);
		
		   $.getJSON('rs/getSitComp',{
		      	Company_name : cname
		   },function(data){
		        	var datas='';
		        	$.each(data, function(index, item){
		        	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
		        	});
		        	$("#sites").html(datas);
		        }); 
	   		});
	    }); 
	}); 
    
    $("#com").change(function(){
   	 var cname=$("#com").val();
   	    $.getJSON('rs/getDeptCompany',{
	       Company_code : cname
	    },function(data){
	        var dataes='';
	   	    $.each(data, function(index, item){
	   	       dataes+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
	   	    });
	   	    $("#loc").html(dataes);
	   
	   	 	$.getJSON('rs/getCustDepForCompany',{
		       Company_code : cname
		    },function(data){
		        var datas='';
		   	    $.each(data, function(index, item){
		        		datas+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
		        });
		        $("#sit").html(datas);
		
		   $.getJSON('rs/getSitComp',{
		      	Company_name : cname
		   },function(data){
		        	var datas='';
		        	$.each(data, function(index, item){
		        	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
		        	});
		        	$("#site").html(datas);
		        }); 
	   		});
	    }); 
      });
   
    $("#coms").change(function(){
    	 var cname=$("#coms").val();
    	 $.getJSON('rs/getDeptCompany',{
 	       Company_code : cname
 	    },function(data){
 	        var dataes='';
 	   	    $.each(data, function(index, item){
 	   	       dataes+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
 	   	    });
 	   	    $("#locs").html(dataes);
 	   
 	   	 	$.getJSON('rs/getCustDepForCompany',{
 		       Company_code : cname
 		    },function(data){
 		        var datas='';
 		   	    $.each(data, function(index, item){
 		        		datas+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
 		        });
 		        $("#sits").html(datas);
 		
 		   $.getJSON('rs/getSitComp',{
 		      	Company_name : cname
 		   },function(data){
 		        	var datas='';
 		        	$.each(data, function(index, item){
 		        	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
 		        	});
 		        	$("#sites").html(datas);
 		        }); 
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
	    	if(item.companyName.trim() !="Biocon Research Limited"){
        		datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
        	}
	    });
	    $("#coms").html(datas);
	        
	    var cname=$("#coms").val();
	    $.getJSON('rs/getDeptCompany',{
	       Company_code : cname
	    },function(data){
	        var dataes='';
	   	    $.each(data, function(index, item){
	   	       dataes+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
	   	    });
	   	    $("#locs").html(dataes);
	   
	   	 	$.getJSON('rs/getCustDepForCompany',{
		       Company_code : cname
		    },function(data){
		        var datas='';
		   	    $.each(data, function(index, item){
		        		datas+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
		        });
		        $("#sits").html(datas);
		
		   $.getJSON('rs/getSitComp',{
		      	Company_name : cname
		   },function(data){
		        	var datas='';
		        	$.each(data, function(index, item){
		        	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
		        	});
		        	$("#sites").html(datas);
		        }); 
	   		});
	    }); 
	}); 
    $("#coms").change(function(){
   	 var cname=$("#coms").val();
   	   $.getJSON('rs/getDeptCompany',{
	       Company_code : cname
	    },function(data){
	        var dataes='';
	   	    $.each(data, function(index, item){
	   	       dataes+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
	   	    });
	   	    $("#locs").html(dataes);
	   
	   	 	$.getJSON('rs/getCustDepForCompany',{
		       Company_code : cname
		    },function(data){
		        var datas='';
		   	    $.each(data, function(index, item){
		        		datas+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
		        });
		        $("#sits").html(datas);
		
		   $.getJSON('rs/getSitComp',{
		      	Company_name : cname
		   },function(data){
		        	var datas='';
		        	$.each(data, function(index, item){
		        	   datas+='<option value='+item.id+'>'+item.sname+'</option>';
		        	});
		        	$("#sites").html(datas);
		        }); 
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
function rese(){
	re();
}
function editData(pid,dcode,cdcode,cid,vid,sid){
	$("#id").val(pid);
	$("#id1").val(pid);
	
	 $.getJSON('rs/getComp', function(data){
		   	var datas='';
		    $.each(data, function(index, item){
		    	if(item.companyCode==cid){
	        		datas+='<option value='+item.companyCode+' selected>'+item.companyName+'</option>';
	        	}else{
	        		if(item.companyName.trim()!="Biocon Research Limited"){
		        		datas+='<option value='+item.companyCode+'>'+item.companyName+'</option>';
		        	}
	        	}
		    });
		    $("#com").html(datas);
	  		var cname=$("#com").val();
	    	$.getJSON('rs/getDeptCompany',{
	       		Company_code : cname
	    	},function(data){
	        	var dataes='';
	   	    	$.each(data, function(index, item){
	   	    		if(item.deptcode==dcode){
	        			dataes+='<option value='+item.deptcode+' selected>'+item.deptname+'</option>';
	        		}else{
	        			dataes+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
	        		}
	   	    	});
	   	    $("#loc").html(dataes);
	    	 
	   	 $.getJSON('rs/getCustDepForCompany',{
		       Company_code : cname
		    },function(data){
		   	 var datas='';
		        $.each(data, function(index, item){
		        	if(item.deptcode==cdcode){
		        		datas+='<option value='+item.deptcode+' selected>'+item.deptname+'</option>';
		        	}else{
		        		datas+='<option value='+item.deptcode+'>'+item.deptname+'</option>';
		        	}
		        });
		        $("#sit").html(datas);
		    
		   	 	$.getJSON('rs/getSitComp',{
		        	Company_name : cname
		        },function(data){
		        	var datas='';
		        	$.each(data, function(index, item){
			        	if(item.id==sid){
			        		datas+='<option value='+item.id+' selected>'+item.sname+'</option>';
			        	}else{
			        		datas+='<option value='+item.id+'>'+item.sname+'</option>';
			        	}
			        });
			        $("#site").html(datas);
				});
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
	    url: "rs/getspactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].departCode,item[i].dename,item[i].custdename,item[i].cname,item[i].vname,item[i].sname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].departCode+','+item[i].cudtdepartCode+','+item[i].cid+','+item[i].vid+','+item[i].sid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getspinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].departCode,item[i].dename,item[i].custdename,item[i].cname,item[i].vname,item[i].sname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	if($("#coms").val()=="" || $("#coms").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter company detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#locs").val()=="" || $("#locs").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter department detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#sits").val()=="" || $("#sits").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter custom department detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#vers").val()=="" || $("#vers").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter vertical detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#sites").val()=="" || $("#sites").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter site detail");
    	$('#alerts').modal('show');
		return false;
	}else{
		var emp=$("#locs").val();
		var sit=$("#sits").val();
		var cid=$("#coms").val();
		var vid=$("#vers").val();
		var sid=$("#sites").val();
		$('#exampleModal2').modal('hide');
		$('#loading').modal('show');
		$.ajax({
		    type: "Get",
		    url: "insertDepartCust",
		    data: "Did="+emp+"&CdId="+sit+"&Cid="+cid+"&Vid="+vid+"&Sid="+sid,
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
	if($("#com").val()=="" || $("#com").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter company detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#loc").val()=="" || $("#loc").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter department detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#sit").val()=="" || $("#sit").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter custom department detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#ver").val()=="" || $("#ver").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter vertical detail");
    	$('#alerts').modal('show');
		return false;
	}
	if($("#site").val()=="" || $("#site").val()==null){
		$("#exampleModalLabelTitle2").html("Info");
		$("#dataes1").html("Please enter site detail");
    	$('#alerts').modal('show');
		return false;
	}else{
		var id=$("#id1").val();
		var emp=$("#loc").val();
		var sit=$("#sit").val();
		var cid=$("#com").val();
		var vid=$("#ver").val();
		var sid=$("#site").val();
		$('#loading').modal('show');
		$('#exampleModal').modal('hide');
		$.ajax({
		    type: "Get",
		    url: "updateDepartCust",
		    data: "ID="+id+"&Did="+emp+"&CdId="+sit+"&Cid="+cid+"&Vid="+vid+"&Sid="+sid,
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
	    url: "rs/getspactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].departCode,item[i].dename,item[i].custdename,item[i].cname,item[i].vname,item[i].sname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].departCode+','+item[i].cudtdepartCode+','+item[i].cid+','+item[i].vid+','+item[i].sid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getspinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].departCode,item[i].dename,item[i].custdename,item[i].cname,item[i].vname,item[i].sname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
		    url: "deleteMasterMapping",
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
	    url: "activeIdMasterMapping",
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
	    url: "rs/getspactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
        		s=true;
        		table.fnAddData([item[i].no,item[i].departCode,item[i].dename,item[i].custdename,item[i].cname,item[i].vname,item[i].sname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+','+item[i].departCode+','+item[i].cudtdepartCode+','+item[i].cid+','+item[i].vid+','+item[i].sid+')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);           
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        }
    });
	$.ajax({
		type: "Get",
	    url: "rs/getspinactive",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: "{}",
        async: true,
        success: function (item) {
        	for(var i=0;i < item.length; i++){
           		ss=true;
           		table1.fnAddData([item[i].no,item[i].departCode,item[i].dename,item[i].custdename,item[i].cname,item[i].vname,item[i].sname,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);           
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
	$("#exampleModalLabelTitle").html("Inactive SAP department to custom department detail");
	$("#datas").html("Do you want to inactive?");
}

function synchronize(){
	$('#loading').modal('show');
	$('#exampleModal').modal('hide');
	$.ajax({
	    type: "Get",
	    url: "synchronizeExcelSap",
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
</script>
</body>
</html>
