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
                    <h1 class="page-header">Document Name Biocon Limited Details</h1>
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
							                <th>Type</th>
							                <th>Vertical Name</th>
							                <th>Custom Department Abbreviation</th>
							                <th>Doc Type Abbreviation</th>
							                <th>Doc Type Name</th>
							                <th>SRNO</th>
							                <th>Document No</th>
							           </tr>
							        </thead>
							        <tbody>
							            <c:forEach items="${master}" var="doc" varStatus="status">     
							  			<tr>
							            	<td><c:out value="${doc.no}"/></td>
							                <td><c:out value="${doc.sabb}"/></td>
							                <td><c:out value="${doc.lcode}"/></td>
							                <td><c:out value="${doc.cdabb}"/></td>
							                <td><c:out value="${doc.dabb}"/></td>
							                <td><c:out value="${doc.dname}"/></td>
							                <td><c:out value="${doc.srn}"/></td>
							                <td><c:out value="${doc.documentname}"/></td>
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
