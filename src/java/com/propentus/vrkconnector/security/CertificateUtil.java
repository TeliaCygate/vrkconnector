package com.propentus.vrkconnector.security;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * This class contains utility methods related to X509 certificates.
 */
public class CertificateUtil {

	private static final Log logger = LogFactory.getLog(CertificateUtil.class);

	/**
	 * Get SHA-1 fingerprint value from X509 certificate in hex format.
	 * @param cert
	 * @return Fingerprint value of certificate in hex format.
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateEncodingException
	 */
	public static String getFingerprint(X509Certificate cert) throws NoSuchAlgorithmException, CertificateEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] der = cert.getEncoded();
        md.update(der);
        byte[] digest = md.digest();
        return hexify(digest);
	 }
	
	/**
	 * Convert array of bytes to hex format.
	 * @param bytes
	 * @return
	 */
    private static String hexify(byte bytes[]) {

        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', 
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuffer buf = new StringBuffer(bytes.length * 2);

        for (int i = 0; i < bytes.length; ++i) {
            buf.append(hexDigits[(bytes[i] & 0xf0) >> 4]);
            buf.append(hexDigits[bytes[i] & 0x0f]);
        }

        return buf.toString();
    }
    
    /**
     * Try to get client certificate from HTTP-request.
     * @param request
     * @return Client certificate if it exists, else return null
     */
    public static X509Certificate getClientCertificateFromHttpRequest(HttpServletRequest request) {
    	X509Certificate[] certs = (X509Certificate[]) request
    	    .getAttribute("javax.servlet.request.X509Certificate");
    	
    	if (certs == null)
    		return null;
    	
    	if(certs.length > 0) {
    		return certs[0];
    	}
    	return null;   	
    }
    
    /**
     * Get certificate from uploaded CommonsMultipartFile
     * @param cmf
     * @return
     */
    public static X509Certificate getCertificateFromCommonsMultipartFile(CommonsMultipartFile cmf) {
    	
    	try {
			InputStream is = cmf.getInputStream();
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate c = (X509Certificate) cf.generateCertificate(is);
			return c;
		} catch (FileNotFoundException e) {
			logger.error("File not found", e);
		} catch (CertificateException e) {
			logger.error("Certificate error", e);
		} catch (IOException e) {
			logger.error("IO error", e);
		}
    	
    	return null;
    }
	
}
