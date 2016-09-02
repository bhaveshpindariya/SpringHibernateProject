
/**
 * IDocServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.solusoft.jpa;

    /**
     *  IDocServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class IDocServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public IDocServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public IDocServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for closeRevision method
            * override this method for handling normal response from closeRevision operation
            */
           public void receiveResultcloseRevision(
                    com.solusoft.jpa.IDocServiceStub.CloseRevisionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from closeRevision operation
           */
            public void receiveErrorcloseRevision(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for applyWaterMark method
            * override this method for handling normal response from applyWaterMark operation
            */
           public void receiveResultapplyWaterMark(
                    com.solusoft.jpa.IDocServiceStub.ApplyWaterMarkResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from applyWaterMark operation
           */
            public void receiveErrorapplyWaterMark(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for storeDocument method
            * override this method for handling normal response from storeDocument operation
            */
           public void receiveResultstoreDocument(
                    com.solusoft.jpa.IDocServiceStub.StoreDocumentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from storeDocument operation
           */
            public void receiveErrorstoreDocument(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for acceptTrackChanges method
            * override this method for handling normal response from acceptTrackChanges operation
            */
           public void receiveResultacceptTrackChanges(
                    com.solusoft.jpa.IDocServiceStub.AcceptTrackChangesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from acceptTrackChanges operation
           */
            public void receiveErroracceptTrackChanges(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteRevisionars method
            * override this method for handling normal response from deleteRevisionars operation
            */
           public void receiveResultdeleteRevisionars(
                    com.solusoft.jpa.IDocServiceStub.DeleteRevisionarsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRevisionars operation
           */
            public void receiveErrordeleteRevisionars(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteRevisionDocument method
            * override this method for handling normal response from deleteRevisionDocument operation
            */
           public void receiveResultdeleteRevisionDocument(
                    com.solusoft.jpa.IDocServiceStub.DeleteRevisionDocumentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRevisionDocument operation
           */
            public void receiveErrordeleteRevisionDocument(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRevisionReportWord method
            * override this method for handling normal response from getRevisionReportWord operation
            */
           public void receiveResultgetRevisionReportWord(
                    com.solusoft.jpa.IDocServiceStub.GetRevisionReportWordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRevisionReportWord operation
           */
            public void receiveErrorgetRevisionReportWord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsersByDeprartmentId method
            * override this method for handling normal response from getUsersByDeprartmentId operation
            */
           public void receiveResultgetUsersByDeprartmentId(
                    com.solusoft.jpa.IDocServiceStub.GetUsersByDeprartmentIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsersByDeprartmentId operation
           */
            public void receiveErrorgetUsersByDeprartmentId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listRevisionars method
            * override this method for handling normal response from listRevisionars operation
            */
           public void receiveResultlistRevisionars(
                    com.solusoft.jpa.IDocServiceStub.ListRevisionarsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listRevisionars operation
           */
            public void receiveErrorlistRevisionars(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteDocument method
            * override this method for handling normal response from deleteDocument operation
            */
           public void receiveResultdeleteDocument(
                    com.solusoft.jpa.IDocServiceStub.DeleteDocumentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteDocument operation
           */
            public void receiveErrordeleteDocument(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkOutDocument method
            * override this method for handling normal response from checkOutDocument operation
            */
           public void receiveResultcheckOutDocument(
                    com.solusoft.jpa.IDocServiceStub.CheckOutDocumentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkOutDocument operation
           */
            public void receiveErrorcheckOutDocument(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for storeRevisionarParam method
            * override this method for handling normal response from storeRevisionarParam operation
            */
           public void receiveResultstoreRevisionarParam(
                    com.solusoft.jpa.IDocServiceStub.StoreRevisionarParamResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from storeRevisionarParam operation
           */
            public void receiveErrorstoreRevisionarParam(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertUser method
            * override this method for handling normal response from insertUser operation
            */
           public void receiveResultinsertUser(
                    com.solusoft.jpa.IDocServiceStub.InsertUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertUser operation
           */
            public void receiveErrorinsertUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsersByUsersRef method
            * override this method for handling normal response from getUsersByUsersRef operation
            */
           public void receiveResultgetUsersByUsersRef(
                    com.solusoft.jpa.IDocServiceStub.GetUsersByUsersRefResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsersByUsersRef operation
           */
            public void receiveErrorgetUsersByUsersRef(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getReUniteReportWord method
            * override this method for handling normal response from getReUniteReportWord operation
            */
           public void receiveResultgetReUniteReportWord(
                    com.solusoft.jpa.IDocServiceStub.GetReUniteReportWordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getReUniteReportWord operation
           */
            public void receiveErrorgetReUniteReportWord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for base64DocumentDownload method
            * override this method for handling normal response from base64DocumentDownload operation
            */
           public void receiveResultbase64DocumentDownload(
                    com.solusoft.jpa.IDocServiceStub.Base64DocumentDownloadResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from base64DocumentDownload operation
           */
            public void receiveErrorbase64DocumentDownload(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for storeRevision method
            * override this method for handling normal response from storeRevision operation
            */
           public void receiveResultstoreRevision(
                    com.solusoft.jpa.IDocServiceStub.StoreRevisionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from storeRevision operation
           */
            public void receiveErrorstoreRevision(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertUserExt method
            * override this method for handling normal response from insertUserExt operation
            */
           public void receiveResultinsertUserExt(
                    com.solusoft.jpa.IDocServiceStub.InsertUserExtResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertUserExt operation
           */
            public void receiveErrorinsertUserExt(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRevisionDocStatus method
            * override this method for handling normal response from getRevisionDocStatus operation
            */
           public void receiveResultgetRevisionDocStatus(
                    com.solusoft.jpa.IDocServiceStub.GetRevisionDocStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRevisionDocStatus operation
           */
            public void receiveErrorgetRevisionDocStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRevisionReportPDF method
            * override this method for handling normal response from getRevisionReportPDF operation
            */
           public void receiveResultgetRevisionReportPDF(
                    com.solusoft.jpa.IDocServiceStub.GetRevisionReportPDFResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRevisionReportPDF operation
           */
            public void receiveErrorgetRevisionReportPDF(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRevisionDoc method
            * override this method for handling normal response from getRevisionDoc operation
            */
           public void receiveResultgetRevisionDoc(
                    com.solusoft.jpa.IDocServiceStub.GetRevisionDocResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRevisionDoc operation
           */
            public void receiveErrorgetRevisionDoc(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkInDocument method
            * override this method for handling normal response from checkInDocument operation
            */
           public void receiveResultcheckInDocument(
                    com.solusoft.jpa.IDocServiceStub.CheckInDocumentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkInDocument operation
           */
            public void receiveErrorcheckInDocument(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findUsers method
            * override this method for handling normal response from findUsers operation
            */
           public void receiveResultfindUsers(
                    com.solusoft.jpa.IDocServiceStub.FindUsersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findUsers operation
           */
            public void receiveErrorfindUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for identityLogin method
            * override this method for handling normal response from identityLogin operation
            */
           public void receiveResultidentityLogin(
                    com.solusoft.jpa.IDocServiceStub.IdentityLoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from identityLogin operation
           */
            public void receiveErroridentityLogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listRevisions method
            * override this method for handling normal response from listRevisions operation
            */
           public void receiveResultlistRevisions(
                    com.solusoft.jpa.IDocServiceStub.ListRevisionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listRevisions operation
           */
            public void receiveErrorlistRevisions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for authSecureCust method
            * override this method for handling normal response from authSecureCust operation
            */
           public void receiveResultauthSecureCust(
                    com.solusoft.jpa.IDocServiceStub.AuthSecureCustResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from authSecureCust operation
           */
            public void receiveErrorauthSecureCust(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getReUniteReport method
            * override this method for handling normal response from getReUniteReport operation
            */
           public void receiveResultgetReUniteReport(
                    com.solusoft.jpa.IDocServiceStub.GetReUniteReportResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getReUniteReport operation
           */
            public void receiveErrorgetReUniteReport(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRevision method
            * override this method for handling normal response from getRevision operation
            */
           public void receiveResultgetRevision(
                    com.solusoft.jpa.IDocServiceStub.GetRevisionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRevision operation
           */
            public void receiveErrorgetRevision(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listRemarks method
            * override this method for handling normal response from listRemarks operation
            */
           public void receiveResultlistRemarks(
                    com.solusoft.jpa.IDocServiceStub.ListRemarksResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listRemarks operation
           */
            public void receiveErrorlistRemarks(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for documentDownload method
            * override this method for handling normal response from documentDownload operation
            */
           public void receiveResultdocumentDownload(
                    com.solusoft.jpa.IDocServiceStub.DocumentDownloadResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from documentDownload operation
           */
            public void receiveErrordocumentDownload(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for storeRevisionar method
            * override this method for handling normal response from storeRevisionar operation
            */
           public void receiveResultstoreRevisionar(
                    com.solusoft.jpa.IDocServiceStub.StoreRevisionarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from storeRevisionar operation
           */
            public void receiveErrorstoreRevisionar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for saveDeprartmentMember method
            * override this method for handling normal response from saveDeprartmentMember operation
            */
           public void receiveResultsaveDeprartmentMember(
                    com.solusoft.jpa.IDocServiceStub.SaveDeprartmentMemberResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from saveDeprartmentMember operation
           */
            public void receiveErrorsaveDeprartmentMember(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUser method
            * override this method for handling normal response from getUser operation
            */
           public void receiveResultgetUser(
                    com.solusoft.jpa.IDocServiceStub.GetUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUser operation
           */
            public void receiveErrorgetUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for base64CheckOutDocument method
            * override this method for handling normal response from base64CheckOutDocument operation
            */
           public void receiveResultbase64CheckOutDocument(
                    com.solusoft.jpa.IDocServiceStub.Base64CheckOutDocumentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from base64CheckOutDocument operation
           */
            public void receiveErrorbase64CheckOutDocument(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listRevisionDocuments method
            * override this method for handling normal response from listRevisionDocuments operation
            */
           public void receiveResultlistRevisionDocuments(
                    com.solusoft.jpa.IDocServiceStub.ListRevisionDocumentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listRevisionDocuments operation
           */
            public void receiveErrorlistRevisionDocuments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteRevision method
            * override this method for handling normal response from deleteRevision operation
            */
           public void receiveResultdeleteRevision(
                    com.solusoft.jpa.IDocServiceStub.DeleteRevisionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRevision operation
           */
            public void receiveErrordeleteRevision(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for convertToPDF method
            * override this method for handling normal response from convertToPDF operation
            */
           public void receiveResultconvertToPDF(
                    com.solusoft.jpa.IDocServiceStub.ConvertToPDFResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from convertToPDF operation
           */
            public void receiveErrorconvertToPDF(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRevisionar method
            * override this method for handling normal response from getRevisionar operation
            */
           public void receiveResultgetRevisionar(
                    com.solusoft.jpa.IDocServiceStub.GetRevisionarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRevisionar operation
           */
            public void receiveErrorgetRevisionar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAuthSecureCust method
            * override this method for handling normal response from getAuthSecureCust operation
            */
           public void receiveResultgetAuthSecureCust(
                    com.solusoft.jpa.IDocServiceStub.GetAuthSecureCustResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAuthSecureCust operation
           */
            public void receiveErrorgetAuthSecureCust(java.lang.Exception e) {
            }
                


    }
    