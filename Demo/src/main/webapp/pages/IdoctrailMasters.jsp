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
                    <h1 class="page-header">iDoc Trail Details</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                       <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" style="font-size:13px;">
                                     <thead>
							             <tr>
							                <th>ID</th>
							                <th>Operation</th>
							                <th>Name</th>
							                <th>Alias</th>
							                <th>Email</th>
							                <th>CreateBy</th>
							                <th>Create Date</th>
							                <th>ModifyBy</th>
							                <th>Modify Date</th>
							           </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="autri" varStatus="status">     
							  			<tr>
							            	<td><c:out value="${autri.ids}"/></td>
							                <td><c:out value="${autri.operation}"/></td>
							                <td><c:out value="${autri.nvalue}"/></td>
							                <td><c:out value="${autri.ovalue}"/></td>
							                <td><c:out value="${autri.tableName}"/></td>
							                <td><c:out value="${autri.createdBy}"/></td>
							                <td><c:out value="${autri.createdDate}"/></td>
							                <td><c:out value="${autri.modifyBy}"/></td>
							                <td><c:out value="${autri.modifyDate}"/></td>
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
    </script>
</body>
</html>
