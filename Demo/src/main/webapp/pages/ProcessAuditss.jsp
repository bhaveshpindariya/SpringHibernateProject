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
                    <h1 class="page-header">Procedure Process Audit Details</h1>
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
							                <th>Case Title</th>
							                <th>Step Name</th>
							                <th>Step User</th>
							                <th>Step Response</th>
							                <th>Time In</th>
							                <th>Time Out</th>
							                <th>Document Status</th>
							                <th>Department Name</th>
							           </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="proaudit" varStatus="status">     
							  				<tr>
								            	<td><c:out value="${proaudit.no}"/></td>
								                <td><c:out value="${proaudit.casetitle}"/></td>
								                <td><c:out value="${proaudit.stepname}"/></td>
								                <td><c:out value="${proaudit.stepuser}"/></td>
								                <td><c:out value="${proaudit.stepreason}"/></td>
								                <td><c:out value="${proaudit.timein}"/></td>
								                <td><c:out value="${proaudit.timeout}"/></td>
								                <td><c:out value="${proaudit.docstatus}"/></td>
								                <td><c:out value="${proaudit.dname}"/></td>
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
