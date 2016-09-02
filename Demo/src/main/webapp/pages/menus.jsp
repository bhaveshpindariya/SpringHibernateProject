 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <nav class="navbar navbar-default navbar-static-top headings"style="margin-bottom: 0;">
    <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="#"><img src="<c:url value="/images/Biocon_Logo.png"/>"></a> </div>
    <!-- /.navbar-header -->
    
    <ul class="nav navbar-top-links navbar-right">
          <li class="dropdown"> <a class="dropdown-toggle fntclor" data-toggle="dropdown" href="#">${user.username}<i class="fa fa-caret-down fntclor"></i></a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="<c:url value="/logout"/>"><i class="fa fa-sign-out fa-fw"></i> Logout</a> </li>
            </ul>

          </li>
     
    </ul>
    </nav>
    <div class="navbar-default sidebar">
     <div class="sidebar-nav navbar-collapse">
      <ul class="nav" id="side-menu">
      <c:if  test = "${APPAdministrator}" >
        <li name="Root"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Root<span class="fa arrow"></span> </a>
            <ul class="nav nav-third-level collapse in" name="Root">
                <li name="Root_Root1"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Master Table<span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level " name="Root_Root1">
                        <li><a href="companys" id="Third1_Root_Root1" class="secound">Company</a></li>
                        <li><a href="department" id="Third2_Root_Root1" class="secound">Department</a></li>
                        <li><a href="branchs" id="Third3_Root_Root1" class="secound">Branch</a></li>
                        <li><a href="costCenterDetail" id="Third4_Root_Root1" class="secound">Cost Center</a></li>
                        <li><a href="empMaster" id="Third5_Root_Root1" class="secound">Employee</a></li>
                        <li><a href="reportingDetail" id="Third6_Root_Root1" class="secound">Reporting</a></li>
                        <li><a href="projectMaster" id="Third8_Root_Root1" class="secound">Project</a></li>
                        <li><a href="idocUser" id="Third98_Root_Root1" class="secound">iDoc User</a></li>
                    </ul>
                </li>
				<li name="Root_Root2"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Custom Table<span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level" name="Root_Root2">
                    	  <li name="Root_Root2_sub1"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Procedure<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1">
		                        <li><a href="printResPM" id="Third6_Root_Root2_sub1" class="third">Print Reason</a> </li>
		                        <li><a href="cancelResPM" id="Third20_Root_Root2_sub1" class="third">Cancel Reason</a> </li>
		                        <li><a href="BRLGroupData" id="Third11_Root_Root2_sub1" class="third">BRL Group/Lab</a></li>
		                        <li><a href="customeDepartment" id="Third10_Root_Root2_sub1" class="third">Custom Department</a></li>
		                        <li><a href="SapCustomeDepartment" id="Third91_Root_Root2_sub1" class="third">SAP To Custom Department</a></li>
		                        <li><a href="EmployeeSiteVerdetail" id="Third26_Root_Root2_sub1" class="third">Employee Site Vertical Detail</a></li>
		                        <li name="Root_Root2_sub1_Root11"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Vertical<span class="fa arrow"></span></a>
                           		 	<ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root11">
                                		<li><a href="vertical" id="Fourth1_Root_Root2_sub1_Root11" class="forth">Vertical Detail</a></li>
                                		<li><a href="CompanyVerdetail" id="Fourth2_Root_Root2_sub1_Root11" class="forth">Vertical Company Detail</a></li>
                           			 </ul>
                        		</li>
                        		<li name="Root_Root2_sub1_Root22"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Document<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root22">
		                                <li><a href="docType" id="Fourth1_Root_Root2_sub1_Root22" class="forth">Document Type</a></li>
		                                <li><a href="docComType" id="Fourth3_Root_Root2_sub1_Root22"class="forth">Document Company</a></li>
		                            </ul>
                       			</li>
                       			<li name="Root_Root2_sub1_Root33"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i> Site<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root33">
		                                <li><a href="siteMaster" id="Fourth33_Root_Root2_sub1_Root33"class="forth">Site Detail</a></li>
		                                <!-- <li><a href="EmployeeSitedetail" id="Fourth55_Root_Root2_sub1_Root33"class="forth">Employee Site Detail</a></li> -->
		                             </ul>
                        		</li>
                        		<li name="Root_Root2_sub1_Root44"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i> Signature<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root44">
		                                <li><a href="signRole" id="Fourth6_Root_Root2_sub1_Root44" class="forth">Signature Role</a></li>
		                                <li><a href="signReason" id="Fourth7_Root_Root2_sub1_Root44"class="forth">Signature Reason</a></li>
		                                
		                            </ul>
                       			</li>
                                <li name="Root_Root2_sub1_Root55"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Location<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root55">
		                                <li><a href="location" id="Fourth6_Root_Root2_sub1_Root55"class="forth">Location Detail</a></li>
		                            </ul>
		                        </li>
		                    </ul>
                          </li>
                          
                          <li name="Root_Root2_sub2"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Legal<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level " name="Root_Root2_sub2">
                            	<li><a href="printResLRF" id="Third99_Root_Root2_sub2" class="third">Print Reason</a> </li>
                            	<li><a href="cancelResLRF" id="Third20_Root_Root2_sub2" class="third">Cancel Reason</a> </li>
                            	<li><a href="agreementType" id="Third11_Root_Root2_sub2" class="third">Agreement Type</a></li>
                            	<li><a href="EmployeeVerdetail" id="Third475_Root_Root2_sub2" class="third">Legal Manager</a></li>
                            	<li><a href="VerFinacedetail" id="Third475_Root_Root2_sub2" class="third">Other Approvers</a></li>
                            	<li><a href="agreementscreen" id="Third88_Root_Root2_sub2" class="third">Agreement Screens</a></li>
                            	<li><a href="agreementattachments" id="Third89_Root_Root2_sub2" class="third">Agreement Attachments</a></li>
                            </ul>
                        </li>
                        
                    </ul>
                </li>
               
                <li name="Root_Root3"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Audit<span class="fa arrow"></span></a>
                 	<ul class="nav nav-third-level" name="Root_Root3">
                		<li name="Root_Root3_sub1"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Procedure<span class="fa arrow"></span></a>
               				  <ul class="nav nav-third-level fourth" name="Root_Root3_sub1">
               				 	<li><a href="PMprintAudit" id="Third11_Root_Root3_sub1" class="third">PM Print Audit</a> </li>
                         	 	<li><a href="cancelAudit" id="Third20_Root_Root3_sub1" class="third">Cancel Audit</a> </li>
                         	 	<li><a href="signAudit" id="Third13_Root_Root3_sub1" class="third">Signature Audit</a></li>
                         	 	<li><a href="processAudit" id="Third15_Root_Root3_sub1" class="third">Procedure Process Audit</a></li>
                         	 	<!-- <li><a href="userSelection" id="Third56_Root_Root3_sub1" class="third">Casewise User</a></li> -->
                         	 	
                         	 	<li name="Root_Root3_sub1_Root88"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Document Name<span class="fa arrow"></span></a>
                            		<ul class="nav nav-third-level fourth" name="Root_Root3_sub1_Root88">
                                		<li><a href="BlDocumentName" id="Fourth23_Root_Root3_sub1_Root88" class="forth">Document Name BL</a></li>
                                		<li><a href="BrlDocumentName" id="Fourth56_Root_Root3_sub1_Root88"class="forth">Document Name BRL</a></li>
                                		<li><a href="BMDocumentName" id="Fourth60_Root_Root3_sub1_Root88"class="forth">Document Name BM</a></li>
                            		</ul>
                        		</li>
                         	  </ul>
                        </li>
                         
                        <li name="Root_Root3_sub2"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Legal<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level " name="Root_Root3_sub2">
                            	<li><a href="LRFprintAudit" id="Third20_Root_Root3_sub2" class="third">LRF Print Audit</a></li>
                            	<li><a href="lrfprocessAudit" id="Third11_Root_Root3_sub2" class="third">Legal Process Logs</a></li>
                            	<li><a href="lrfCancelAudit" id="Third123_Root_Root3_sub2" class="third">Cancel Audit</a> </li>
                            	<li><a href="lrfNumberGenerate" id="Third128_Root_Root3_sub2" class="third">Lrf Number</a> </li>
                            </ul>
                        </li>
                        <li name="Root_Root3_sub3"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Trail<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level " name="Root_Root3_sub3">
                            	<li><a href="audittrailMaster" id="Third11_Root_Root3_sub3" class="third">Audit Trail</a></li>
                            	<li><a href="iDoctrail" id="Third65_Root_Root3_sub3" class="third">iDoc Trail</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
               
                <li name="Root_Root4"><a href="#"><i class="fa fa-sitemap fa-fw"></i>User Management<span class="fa arrow"></span></a>
                	<ul class="nav nav-third-level" name="Root_Root4">
                		<li><a href="roles" id="Third1_Root_Root4" class="secound">Role</a></li>
                        <li><a href="userManagement" id="Third2_Root_Root4" class="secound">User Detail</a></li>
                	</ul>
                </li>
            </ul>
        </li>
      </c:if>
      <c:if  test = "${PMAdministrator}" >
        <li name="Root"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Root<span class="fa arrow"></span> </a>
            <ul class="nav nav-third-level collapse in" name="Root">
                <li name="Root_Root2"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Custom Table<span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level" name="Root_Root2">
                    	  <li name="Root_Root2_sub1"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Procedure<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1">
		                        <li><a href="printResPM" id="Third6_Root_Root2_sub1" class="third">Print Reason</a> </li>
		                        <li><a href="cancelResPM" id="Third20_Root_Root2_sub1" class="third">Cancel Reason</a> </li>
		                        <li><a href="BRLGroupData" id="Third11_Root_Root2_sub1" class="third">BRL Group/Lab</a></li>
		                        <li><a href="customeDepartment" id="Third10_Root_Root2_sub1" class="third">Custom Department</a></li>
		                        <li><a href="SapCustomeDepartment" id="Third91_Root_Root2_sub1" class="third">SAP To Custom Department</a></li>
		                        <li><a href="EmployeeSiteVerdetail" id="Third26_Root_Root2_sub1" class="third">Employee Site Vertical Detail</a></li>
		                        <li name="Root_Root2_sub1_Root11"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Vertical<span class="fa arrow"></span></a>
                           		 	<ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root11">
                                		<li><a href="vertical" id="Fourth1_Root_Root2_sub1_Root11" class="forth">Vertical Detail</a></li>
                                		<li><a href="CompanyVerdetail" id="Fourth2_Root_Root2_sub1_Root11" class="forth">Vertical Company Detail</a></li>
                           			 </ul>
                        		</li>
                        		<li name="Root_Root2_sub1_Root22"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Document<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root22">
		                                <li><a href="docType" id="Fourth1_Root_Root2_sub1_Root22" class="forth">Document Type</a></li>
		                                <li><a href="docComType" id="Fourth3_Root_Root2_sub1_Root22"class="forth">Document Company</a></li>
		                            </ul>
                       			</li>
                       			<li name="Root_Root2_sub1_Root33"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i> Site<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root33">
		                                <li><a href="siteMaster" id="Fourth33_Root_Root2_sub1_Root33"class="forth">Site Detail</a></li>
		                                <!-- <li><a href="EmployeeSitedetail" id="Fourth55_Root_Root2_sub1_Root33"class="forth">Employee Site Detail</a></li> -->
		                             </ul>
                        		</li>
                        		<li name="Root_Root2_sub1_Root44"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i> Signature<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root44">
		                                <li><a href="signRole" id="Fourth6_Root_Root2_sub1_Root44" class="forth">Signature Role</a></li>
		                                <li><a href="signReason" id="Fourth7_Root_Root2_sub1_Root44"class="forth">Signature Reason</a></li>
		                                
		                            </ul>
                       			</li>
                                <li name="Root_Root2_sub1_Root55"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Location<span class="fa arrow"></span></a>
		                            <ul class="nav nav-third-level fourth" name="Root_Root2_sub1_Root55">
		                                <li><a href="location" id="Fourth6_Root_Root2_sub1_Root55"class="forth">Location Detail</a></li>
		                            </ul>
		                        </li>
		                    </ul>
                          </li>
                    </ul>
                </li>
               
                <li name="Root_Root3"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Audit<span class="fa arrow"></span></a>
                 	<ul class="nav nav-third-level" name="Root_Root3">
                		<li name="Root_Root3_sub1"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Procedure<span class="fa arrow"></span></a>
               				  <ul class="nav nav-third-level fourth" name="Root_Root3_sub1">
               				 	<li><a href="PMprintAudit" id="Third11_Root_Root3_sub1" class="third">PM Print Audit</a> </li>
                         	 	<li><a href="cancelAudit" id="Third20_Root_Root3_sub1" class="third">Cancel Audit</a> </li>
                         	 	<li><a href="signAudit" id="Third13_Root_Root3_sub1" class="third">Signature Audit</a></li>
                         	 	<li><a href="processAudit" id="Third15_Root_Root3_sub1" class="third">Procedure Process Audit</a></li>
                         	 	<!-- <li><a href="userSelection" id="Third56_Root_Root3_sub1" class="third">Casewise User</a></li> -->
                         	 	
                         	 	<li name="Root_Root3_sub1_Root88"><a href="#" class="third"><i class="fa fa-sitemap fa-fw"></i>Document Name<span class="fa arrow"></span></a>
                            		<ul class="nav nav-third-level fourth" name="Root_Root3_sub1_Root88">
                                		<li><a href="BlDocumentName" id="Fourth23_Root_Root3_sub1_Root88" class="forth">Document Name BL</a></li>
                                		<li><a href="BrlDocumentName" id="Fourth56_Root_Root3_sub1_Root88"class="forth">Document Name BRL</a></li>
                                		<li><a href="BMDocumentName" id="Fourth60_Root_Root3_sub1_Root88"class="forth">Document Name BM</a></li>
                            		</ul>
                        		</li>
                         	  </ul>
                        </li>
                     </ul>
                </li>
                
            </ul>
        </li>
      </c:if>
      <c:if  test = "${LRFAdministrator}" >
        <li name="Root"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Root<span class="fa arrow"></span> </a>
            <ul class="nav nav-third-level collapse in" name="Root">
                <li name="Root_Root2"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Custom Table<span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level" name="Root_Root2">
                    	  <li name="Root_Root2_sub2"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Legal<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level " name="Root_Root2_sub2">
                           		<li><a href="printResLRF" id="Third99_Root_Root2_sub2" class="third">Print Reason</a> </li>
                           		<li><a href="cancelResLRF" id="Third20_Root_Root2_sub2" class="third">Cancel Reason</a> </li>
                            	<li><a href="agreementType" id="Third11_Root_Root2_sub2" class="third">Agreement Type</a></li>
                            	<li><a href="EmployeeVerdetail" id="Third475_Root_Root2_sub2" class="third">Legal Manager</a></li>
                            	<li><a href="VerFinacedetail" id="Third475_Root_Root2_sub2" class="third">Other Approvers</a></li>
                            	<li><a href="agreementscreen" id="Third88_Root_Root2_sub2" class="third">Agreement Screens</a></li>
                            	<li><a href="agreementattachments" id="Third89_Root_Root2_sub2" class="third">Agreement Attachments</a></li>
                           </ul>
                        </li>
                        
                    </ul>
                </li>
               
                <li name="Root_Root3"><a href="#"><i class="fa fa-sitemap fa-fw"></i>Audit<span class="fa arrow"></span></a>
                 	<ul class="nav nav-third-level" name="Root_Root3">
                		<li name="Root_Root3_sub2"><a href="#" class="secound"><i class="fa fa-sitemap fa-fw"></i>Legal<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level " name="Root_Root3_sub2">
                            	<li><a href="LRFprintAudit" id="Third20_Root_Root3_sub2" class="third">LRF Print Audit</a></li>
                            	<li><a href="lrfprocessAudit" id="Third11_Root_Root3_sub2" class="third">Legal Process Logs</a></li>
                            	<li><a href="lrfCancelAudit" id="Third123_Root_Root3_sub2" class="third">Cancel Audit</a> </li>
                            	<li><a href="lrfNumberGenerate" id="Third128_Root_Root3_sub2" class="third">Lrf Number</a> </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
      </c:if>
      </ul>
     </div>
    </div>
