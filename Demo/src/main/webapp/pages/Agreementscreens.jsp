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
                    <h1 class="page-header">Agreement Screens</h1>
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
							                <th>View Definition Id</th>
							                <th>View Definition Name</th>
							                <th>Screen For</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							                <th style="bSortable: false;">Action</th>
							            </tr>
							        </thead>
							        <tbody>
								            <c:forEach items="${master}" var="agreementscreens" varStatus="status">     
								  			<tr>
								  				<td><c:out value="${agreementscreens.no}"/></td>
								            	<td><c:out value="${agreementscreens.cname}"/></td>
								            	<td><c:out value="${agreementscreens.aname}"/></td>
								                <td><c:out value="${agreementscreens.viewid}"/></td>
								                <td><c:out value="${agreementscreens.viewname}"/></td>
								                <td><c:out value="${agreementscreens.screenfor}"/></td>
								                <td><c:out value="${agreementscreens.createdBy}"/></td>
								                <td><c:out value="${agreementscreens.createdDate}"/></td>
								                <td><c:out value="${agreementscreens.modifyBy}"/></td>
								                <td><c:out value="${agreementscreens.modifyDate}"/></td>
								                <td><a href="#" onclick="editData('${agreementscreens.id}','${agreementscreens.cid}','${agreementscreens.aid}','${agreementscreens.viewid}','${agreementscreens.viewname}','${agreementscreens.screenfor}')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('${agreementscreens.id}')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a></td>
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
		                <th>View Definition Id</th>
		                <th>View Definition Name</th>
		                <th>Screen For</th>
		                <th>CreateBy</th>
		                <th>Create Date</th>
		                <th>ModifyBy</th>
		                <th>Modify Date</th>
		               <th style="bSortable: false;">Action</th> 
         			</tr>
      		   </thead>
      		   <tbody>
          			<c:forEach items="${masters}" var="agrscreens" varStatus="status">     
		  			<tr>
		  				<td><c:out value="${agrscreens.no}"/></td>
		            	<td><c:out value="${agrscreens.cname}"/></td>
		            	<td><c:out value="${agrscreens.aname}"/></td>
		                <td><c:out value="${agrscreens.viewid}"/></td>
		                <td><c:out value="${agrscreens.viewname}"/></td>
		                <td><c:out value="${agrscreens.screenfor}"/></td>
		                <td><c:out value="${agrscreens.createdBy}"/></td>
		                <td><c:out value="${agrscreens.createdDate}"/></td>
		                <td><c:out value="${agrscreens.modifyBy}"/></td>
		                <td><c:out value="${agrscreens.modifyDate}"/></td>
		                <td><a href="#" onclick="active('${agrscreens.id}')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a></td>
          			</tr>   
				    </c:forEach>
      			</tbody>
           </table>
        </div>
      </div>
    </div>
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
            <label for="message-text" class="control-label">View id</label>
             <input type="text" class="form-control" id="vid" name="vid">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">View name</label>
             <input type="text" class="form-control" id="vname" name="vname">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Screen for</label>
             <select class="form-control" id="sfor">
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
            <select class="form-control" id="cids">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Agreement type</label>
             <select class="form-control" id="agrees">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">View id</label>
             <input type="text" class="form-control" id="vids" name="vids">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">View name</label>
             <input type="text" class="form-control" id="vnames" name="vnames">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Screen for</label>
             <select class="form-control" id="sfors">
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
	  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 10] } ],
	  	 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
		}); 
	   $('#dataTables-example1').DataTable({
		  	 "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 10] } ],
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
	
	 $.getJSON('rs/screenFor', function(data){
	 	 var datas='';
	      $.each(data, function(index, item){
	     	 datas+="<option value='" + item.screenfor + "'>" + item.screenfor + "</option>";
	      });
	      $("#sfors").html(datas);
	  }); 
});
 
function editData(id,cid,aid,viewid,vname,sfors){
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
		$("#vid").val(viewid);
		$("#vname").val(vname);
		var dataes=sfors.trim();
		$.getJSON('rs/screenFor', function(data){
		   	 var dataesss='';
		        $.each(data, function(index, item){
		        	if(item.screenfor == dataes){
		        		dataesss+="<option value='" + item.screenfor + "'selected>" + item.screenfor + "</option>";
		        	}else{
		        		dataesss+="<option value='" + item.screenfor +"'>"+item.screenfor+"</option>";
		        	}
		        });
		$("#sfor").html(dataesss);
		});
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
 		$.getJSON('rs/screenFor', function(data){
 		 	 var datas='';
 		      $.each(data, function(index, item){
 		    	 datas+="<option value='" + item.screenfor + "'>" + item.screenfor + "</option>";
 		      });
 		      $("#sfor").html(datas);
 		  }); 
  }
 
 function reload(){
		$('#msg').modal('hide');
		$('#loading').modal('show');
		$("#vids").val('');
		$("#vnames").val('');
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
		    url: "rs/getAgreementScreenActive",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		s=true;
	           		table.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].viewid,item[i].viewname,item[i].screenfor,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',' +item[i].cid+ ','+item[i].aid+',\'' +item[i].viewid+ '\',\'' +item[i].viewname+ '\',\'' +item[i].screenfor+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);        
			    }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) 
	        {
	            alert(errorThrown);
	        }
	    });
		$.ajax({
			type: "Get",
		    url: "rs/getAgreementScreenInActive",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	           		ss=true;
	           		table1.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].viewid,item[i].viewname,item[i].screenfor,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);          
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
		$("#vids").val('');
		$("#vnames").val('');
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
		    url: "rs/getAgreementScreenActive",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		s=true;
	           		table.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].viewid,item[i].viewname,item[i].screenfor,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',' +item[i].cid+ ','+item[i].aid+',\'' +item[i].viewid+ '\',\'' +item[i].viewname+ '\',\'' +item[i].screenfor+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);        
			    }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) 
	        {
	            alert(errorThrown);
	        }
	    });
		$.ajax({
			type: "Get",
		    url: "rs/getAgreementScreenInActive",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	           		ss=true;
	           		table1.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].viewid,item[i].viewname,item[i].screenfor,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);          
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
		$("#vids").val('');
		$("#vnames").val('');
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
		    url: "rs/getAgreementScreenActive",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		s=true;
	           		table.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].viewid,item[i].viewname,item[i].screenfor,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="editData('+item[i].id+',' +item[i].cid+ ','+item[i].aid+',\'' +item[i].viewid+ '\',\'' +item[i].viewname+ '\',\'' +item[i].screenfor+ '\')" data-toggle="modal" rel="tooltip" data-target="#exampleModal"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteData('+item[i].id+')"  title="Inactive" data-toggle="modal" rel="tooltip" data-target="#deletbox"><span class="glyphicon glyphicon-trash"></span></a>']);        
			    }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) 
	        {
	            alert(errorThrown);
	        }
	    });
		$.ajax({
			type: "Get",
		    url: "rs/getAgreementScreenInActive",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) {
	        	for(var i=0;i < item.length; i++){
	           		ss=true;
	           		table1.fnAddData([item[i].no,item[i].cname,item[i].aname,item[i].viewid,item[i].viewname,item[i].screenfor,item[i].createdBy,item[i].createdDate,item[i].modifyBy,item[i].modifyDate,'<a href="#" onclick="active('+item[i].id+')" title="Active" data-toggle="modal" rel="tooltip"><span style="color:green;font-size: 20px;" class="glyphicon glyphicon-ok-circle"></span></a>']);          
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
		$("#vids").val('');
		$("#vnames").val('');
		re();
	}
 
 function valides(){
		if($("#cids").val()=="" || $("#cids").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter company detail");
			$('#alerts').modal('show');
			return false;
		}
		if($("#agrees").val()=="" || $("#agrees").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter agreement type name");
			$('#alerts').modal('show');
			return false;
		}
		if($("#vids").val()=="" || $("#vids").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter view id");
			$('#alerts').modal('show');
			return false;
		}
		if($("#vnames").val()=="" || $("#vnames").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter view name");
			$('#alerts').modal('show');
			return false;
		}else{
			var agid=$("#agrees").val();
			var viewid=$("#vids").val();
			var viewname=$("#vnames").val();
			var viewnames=viewname.replace(/&/g, " bhai ");
			var scrfor=$("#sfors").val();
			var scr = scrfor.replace(/&/g, " bhai ");
			$('#exampleModal2').modal('hide');
			$('#loading').modal('show');
			$.ajax({
			    type: "Get",
			    url: "insertAgreementscreen",
			    data: "Agid="+agid+"&Viewid="+viewid+"&Viewname="+viewnames+"&Scrfor="+scr,
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
	 if($("#cid").val()=="" || $("#cid").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter company detail");
			$('#alerts').modal('show');
			return false;
		}
		if($("#agree").val()=="" || $("#agree").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter agreement type name");
			$('#alerts').modal('show');
			return false;
		}
		if($("#vid").val()=="" || $("#vid").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter view id");
			$('#alerts').modal('show');
			return false;
		}
		if($("#vname").val()=="" || $("#vname").val()=="null"){
			$("#exampleModalLabelTitle2").html("Info");
			$("#dataes1").html("Please enter view name");
			$('#alerts').modal('show');
			return false;
		}else{
			var id=$("#id1").val();
			var agid=$("#agree").val();
			var viewid=$("#vid").val();
			var viewname=$("#vname").val();
			var viewnames=viewname.replace(/&/g, " bhai ");
			var scrfor=$("#sfor").val();
			var scr = scrfor.replace(/&/g, " bhai ");
			$('#exampleModal').modal('hide');
			$('#loading').modal('show');
			$.ajax({
			    type: "Get",
			    url: "updateAgreementscreen",
			    data: "Id="+id+"&Agid="+agid+"&Viewid="+viewid+"&Viewname="+viewnames+"&Scrfor="+scr,
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
		    url: "synchronizeExcelAgreementscreens",
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
			    url: "deleteagreementscreens",
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
		    url: "activeagreementscreens",
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
