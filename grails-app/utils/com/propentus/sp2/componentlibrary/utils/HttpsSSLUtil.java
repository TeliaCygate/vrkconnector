package com.propentus.sp2.componentlibrary.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Contains utility method for disabling hostname verifying and certificate validation for HttpsUrlConnection.
 */
public class HttpsSSLUtil {
	
	public static void disableSSLVerification(HttpsURLConnection connection) {
		
		try {
			final SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, allowAllTrustManager(), new java.security.SecureRandom());
			final SSLSocketFactory socketFactory = sc.getSocketFactory();
			
			connection.setSSLSocketFactory(socketFactory);
			connection.setHostnameVerifier(new allowAllHostnameVerifier());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void disableSSLVerificationGlobally() {
		
		try {
			final SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, allowAllTrustManager(), new java.security.SecureRandom());
			final SSLSocketFactory socketFactory = sc.getSocketFactory();
			
			HttpsURLConnection.setDefaultHostnameVerifier(new allowAllHostnameVerifier());
			HttpsURLConnection.setDefaultSSLSocketFactory(socketFactory);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Create TrustManager for SSLContext which trusts all server certificates.
	 * @return
	 */
	public static TrustManager[] allowAllTrustManager() {
		return new TrustManager[] { new X509TrustManager() {

			@Override
			public void checkClientTrusted(
				java.security.cert.X509Certificate[] chain, String authType) {
				// TODO Auto-generated method stub

			}

			@Override
			public void checkServerTrusted(
				java.security.cert.X509Certificate[] chain, String authType) {
				// TODO Auto-generated method stub

			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return null;
			}
		} };
	}
	
	public static void disableHostnameVerifier(HttpsURLConnection connection) {
		connection.setHostnameVerifier(new allowAllHostnameVerifier());
	}
	
	/**
	 * Implementation of HostnameVerifier which accepts all hostnames
	 */
	private static class allowAllHostnameVerifier implements HostnameVerifier {

		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}		
	}
}
