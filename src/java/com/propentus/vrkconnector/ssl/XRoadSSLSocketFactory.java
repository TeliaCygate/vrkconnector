package com.propentus.vrkconnector.ssl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import com.propentus.sp2.componentlibrary.utils.HttpsSSLUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class XRoadSSLSocketFactory {

	private static final Log logger = LogFactory.getLog(XRoadSSLSocketFactory.class);

	private String keystorePath;
	private String password;
	
	public XRoadSSLSocketFactory(String keystorePath, String password) {
		this.keystorePath = keystorePath;
		this.password = password;
	}
	
	public SSLSocketFactory createSocketFactory() {
		try {
			final SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(getKeyManager(), HttpsSSLUtil.allowAllTrustManager(), new java.security.SecureRandom());
			final SSLSocketFactory socketFactory = sc.getSocketFactory();
			return socketFactory;
		} 
		catch (Exception e) {
			logger.error("Error creating socket factory", e);
		}
		return null;
	}
	
	
	/**
	 * Load signature key for HTTPS requests
	 * @return
	 * @throws UnrecoverableKeyException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public KeyManager[] getKeyManager() throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {

		FileInputStream fis = new FileInputStream(new File(keystorePath));
		
		//First, get the default TrustManagerFactory.
	    String alg = KeyManagerFactory.getDefaultAlgorithm();
	    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(alg);
	 
	    KeyStore ks = KeyStore.getInstance("jks");
	    ks.load(fis, password.toCharArray());
	    fis.close();
	    
	    keyManagerFactory.init(ks, password.toCharArray());
	 
	    // And now get the TrustManagers
	    KeyManager[] tms = keyManagerFactory.getKeyManagers();
	    return tms;
	}
}
