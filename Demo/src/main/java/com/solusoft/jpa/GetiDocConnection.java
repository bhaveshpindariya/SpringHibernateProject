package com.solusoft.jpa;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import org.apache.axis2.AxisFault;

import com.solusoft.jpa.IDocServiceStub.IdentityLogin;
import com.solusoft.jpa.IDocServiceStub.IdentityLoginResponse;

public class GetiDocConnection {
	
	public static IDocServiceStub connection = null;
	public static ResourceBundle properties = null;

	public static String iDocURL = null;
	public static String accessKey = null;
	public static String origin = null;
	
	static String fileName=null;

	public static IDocServiceStub getConnection() throws IOException {
		// TODO Auto-generated method stub
		try {
			if (connection == null) {
				properties = ResourceBundle.getBundle("com.solusoft.controller.generic");
				iDocURL = properties.getString("iDocURL");
				connection = new IDocServiceStub(iDocURL);
				return connection;
			} else {
				return connection;
			}
		} catch (AxisFault axisFault) {
			// TODO Auto-generated catch block
			return null;
		}
		finally {
			
		}
	}

	public static String getContextID(String userName) {
		
		try {
			
			if(connection == null){
				getConnection();
			}
			properties = ResourceBundle.getBundle("com.solusoft.controller.generic");
		
			accessKey = properties.getString("AccessKey");
			origin = properties.getString("Origin");
			
			IdentityLogin identity = new IdentityLogin();
			identity.setLoginName(userName);
			identity.setToken(accessKey);
			identity.setOrigin(origin);
			IdentityLoginResponse identityResponse;
			identityResponse = connection.identityLogin(identity);
			String contextId = identityResponse.getIdentityLoginResult();
	
			return contextId;

		} catch (RemoteException remoteException) {
			// TODO Auto-generated catch block
			remoteException.printStackTrace();
			return null;
			
		}
		catch(Exception exception){
			
			exception.printStackTrace();
			return null;
		}
	}
}
