import grails.util.Environment
import org.apache.catalina.connector.Connector

eventConfigureTomcat = { org.apache.catalina.startup.Tomcat tomcat ->
	
	if (Environment.getCurrent() == Environment.DEVELOPMENT) {
		def connector = new Connector("org.apache.coyote.http11.Http11NioProtocol")
		connector.port = 8443
		connector.protocol = "org.apache.coyote.http11.Http11NioProtocol"
		connector.setProperty("maxSpareThreads", "75")
		connector.setProperty("minSpareThreads", "5")
		connector.setProperty("SSLEnabled", "true")
		connector.setProperty("scheme", "https")
		connector.setProperty("secure", "true")
		connector.setProperty("ciphers", "ALL")
		connector.setProperty("enableLookups", "false")
		connector.setProperty("clientAuth", "want")
		connector.setProperty("sslProtocol", "TLS")
		connector.setProperty("keystoreFile", "")
		connector.setProperty("keystoreType", "JKS")
		connector.setProperty("keystorePass", "")
		connector.setProperty("truststoreFile", "")
		connector.setProperty("truststoreType", "JKS")
		connector.setProperty("truststorePass", "")
		connector.setProperty("SSLVerifyClient", "none")
		connector.setProperty("SSLEngine", "on")
		connector.setProperty("SSLVerifyDepth", "1")
		connector.setProperty("SSLCertificateFile", "")
		connector.setProperty("SSLCertificateKeyFile", "")
		connector.setProperty("SSLPassword", "")
		tomcat.service.addConnector connector
	}
}

