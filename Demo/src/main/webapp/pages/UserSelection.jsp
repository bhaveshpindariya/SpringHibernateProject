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
                    <h1 class="page-header">Casewise User Details</h1>
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
							                <th>No</th>
							                <th>Case Id</th>
							                <th>Employee Id</th>
							                <th>Employee Name</th>
							                <th>Employee Alias</th>
							                <th>Role</th>
							                <th>Department Name</th>
							                <th>Create Date</th>
							                <th>Company Name</th>
							                <th>IS_ACTIVE</th>
							           </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="cases" varStatus="status">     
							  			<tr>
							            	<td><c:out value="${cases.id}"/></td>
							            	<td><c:out value="${cases.caseId}"/></td>
							                <td><c:out value="${cases.ecode}"/></td>
							                <td><c:out value="${cases.ename}"/></td>
							                <td><c:out value="${cases.ealias}"/></td>
							                <td><c:out value="${cases.role}"/></td>
							                <td><c:out value="${cases.dname}"/></td>
							                <td><c:out value="${cases.dateEntry}"/></td>
							                <td><c:out value="${cases.cname}"/></td>
							                <c:choose> 
											  <c:when test="${cases.isactive > 0}">
											   <td style="text-align:center;"><span class="glyphicon glyphicon-ok" style="color:green;"></span></td>
											  </c:when>
											  <c:otherwise>
											    <td style="text-align:center;"><span class="glyphicon glyphicon-remove" style="color:red;"></span></td>
											  </c:otherwise>
											</c:choose>
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
