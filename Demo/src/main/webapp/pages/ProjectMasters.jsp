<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Biocon Admin Panel</title>
	<style>
		.modal-content{height:180px !important;overflow:scroll !important;}
	</style>
    <%@include file="headers.jsp" %>
    </head>
    <body onload="BodyOnload();" style="padding:0px !important;">
	<div id="wrapper">
      <%@include file="menus.jsp" %>
      
      <div id="page-wrapper"> 
      		 <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Project Details</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                    	<div class="panel-heading headingp">
                             <button type="button" class="btn btn-info btnright" onclick="valide()" id="synchronize">Synchronize</button>
                        </div>
                         <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" style="font-size:13px;">
                                     <thead>
							            <tr>
							           		<th>ID</th>
						                	<th>Project Id</th>
						                	<th>Project Name</th>
						                	<th>Company Name</th>
						                	<th>Project CrDate</th>
						                	<th>Business Area</th>
						                	<th>Main ProID</th>
						                	<th>Status</th>
						                	
						                </tr>
							        </thead>
							        <tbody>
							             <c:forEach items="${master}" var="pro" varStatus="status">     
								  			<tr>
								            	<td><c:out value="${pro.no}"/></td>
								                <td><c:out value="${pro.projectid}"/></td>
								                <td><c:out value="${pro.projectname}"/></td>
								                <td><c:out value="${pro.comname}"/></td> 
								                <td><c:out value="${pro.prcre}"/></td>
								                <td><c:out value="${pro.busar}"/></td>
								                <td><c:out value="${pro.mainproids}"/></td>
								                <td><c:out value="${pro.statusofpros}"/></td>
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
 <div class="modal fade" id="msg" tabindex="-1" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabelTitle1"></h4>
      </div>
      <div class="modal-body" id="dataes">
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" id ="yes" onclick="reload()" >Ok</button>
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
    	responsive: true,
    	"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    });
 });
 function reload(){
		$('#msg').modal('hide');
		$('#loading').modal('show');
		var ss=false;	 
		var table1 = $('#dataTables-example').dataTable();
		table1.fnClearTable();
		$.ajax(
		  {
			type: "Get",
		    url: "rs/getProjectRef",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        data: "{}",
	        async: true,
	        success: function (item) 
	        {
	        	for(var i=0;i < item.length; i++)
	        	{
	           		ss=true;
	           		table1.fnAddData([item[i].no,item[i].projectid,item[i].projectname,item[i].comname,item[i].prcre,item[i].busar,item[i].mainproids,item[i].statusofpros]);            
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
function valide(){
			$('#loading').modal('show');
			$('#exampleModal').modal('hide');
			$.ajax({
			    type: "Get",
			    url: "webserviceProject",
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
