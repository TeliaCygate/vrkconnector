package com.propentus.sp2.componentlibrary.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility class for URL manipulation
 */
public class URLUtil {

	private static final Log logger = LogFactory.getLog(URLUtil.class);

	/**
	 * Append new GET parameter to URL, or if parameter with same name already
	 * exists, replace the value.
	 * 
	 * Test case for this method can be found in class URLUtilTest.java
	 * 
	 * @param url
	 * @param parameterKey
	 * @param parameterValue
	 * @return
	 */
	public static String appendOrReplaceParameter(String url, String parameterKey,
		String parameterValue) {
		String newUrl = "";
		
		try {
			parameterKey = URLEncoder.encode(parameterKey, "UTF-8");
			parameterValue = URLEncoder.encode(parameterValue, "UTF-8");
			
			String baseUrl;
			String[] urlParts = url.split("\\?");
			if (urlParts.length == 1) {
				newUrl = url + "?" + parameterKey + "=" + parameterValue;
			} else if (urlParts.length > 2) {
				System.out
					.println("URL contained more than one '?' character, couldn't parse parameter part of url");
				return url;
			} else {
				baseUrl = urlParts[0];
				String[] keyValuePair = urlParts[1].split("&");
				Map<String, String> map = new HashMap<String, String>();
				for (String pair : keyValuePair) {
					String key = pair.split("=")[0];
					String value;
					//Replace parameter value
					if (parameterKey.equals(key)) {
						value = parameterValue;
					} else {
						try {
							value = pair.split("=")[1];
						}
						//Parameter value was empty
						catch (ArrayIndexOutOfBoundsException e) {
							value = "";
						}
					}
					
					//	Don't show userDetails and passwordResetDetails again
					if (!key.equals("userFromVetuma") && !key.equals("passwordResetDetails"))
						map.put(key, value);
				}

				if (!map.containsKey(parameterKey)) {
					map.put(parameterKey, parameterValue);
				}

				//Reconstruct url
				newUrl += baseUrl + "?";
				int index = 1;
				for (Entry<String, String> set : map.entrySet()) {
					String key = set.getKey();
					String value = set.getValue();
					if (set.getKey().equals(parameterKey)) {
						value = parameterValue;
					}
					newUrl += key + "=" + value;
					//Don't add '&' to last parameter
					if (index != map.size()) {
						newUrl += "&";
					}
					index++;
				}

			}
			return newUrl;
		} catch (Exception e) {
			logger.fatal("Error while trying to parse URL:" + url);
			e.printStackTrace();
			return url + "&" + parameterKey + "=" + parameterValue;
		}
	}

	/**
	 * Makes request to given URL and returns its content
	 * @param connectionUrl
	 * @param ignoreSSL
	 * @return
	 */
	private static String getContentFromUrl(String connectionUrl, boolean ignoreSSL) {

		String content = "";
		try {
			URL url = new URL(connectionUrl);
			URLConnection con = url.openConnection();
			logger.debug("Getting content from URL:" + connectionUrl);
			
			//Set timeout
			con.setConnectTimeout(5000); //5 seconds
			
			if(con instanceof HttpsURLConnection) {
				HttpsURLConnection https = (HttpsURLConnection) con;
				HttpsSSLUtil.disableHostnameVerifier(https);
				if(ignoreSSL) {
					HttpsSSLUtil.disableSSLVerification(https);
				}
			}
			
			// open the stream and put it into BufferedReader
			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				content += inputLine;
			}
			br.close();

		} catch (Exception e) {
			logger.error("Error trying to get content from URL:" + connectionUrl);
			
			//Get stacktrace string
			//TODO: Remove this when Tomcat properly prints stacktraces
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			logger.error("Stacktrace:" + exceptionAsString);
			////
			e.printStackTrace();
		}
		logger.debug("Got response: \n {0}" + content);
		return content;
	}
	

	/**
	 * Makes request to given URL and returns its content. Also decodes the
	 * response with given encoding type.
	 * 
	 * @param connectionUrl
	 * @param encoding
	 * @return
	 */
	public static String getContentFromUrl(String connectionUrl, String encoding) {

		String content = getContentFromUrl(connectionUrl, false);
		try {
			content = URLDecoder.decode(content, encoding);
		} catch (UnsupportedEncodingException e) {
			logger.error("Error while trying to decode response from URL: "+ connectionUrl);
			e.printStackTrace();
		}
		logger.debug("Decoded response: \n" + content);
		return content;
	}
	
	public static String getContentFromUrlIgnoreSSL(String connectionUrl) {
		return getContentFromUrl(connectionUrl, true);
	}
	
	public static String getContentFromUrl(String connectionUrl) {
		return getContentFromUrl(connectionUrl, false);
	}

	public static String getParameterValue(String url, String parameterKey) {
		HashMap<String, String> parameterMap = createParameterMap(url);
		if (parameterMap.containsKey(parameterKey)) {
			return parameterMap.get(parameterKey);
		}
		return null;
	}

	private static HashMap<String, String> createParameterMap(String url) {

		HashMap<String, String> parameterMap = new HashMap<String, String>();
		String[] urlParts = url.split("\\?");
		if (urlParts.length == 1) {
			return parameterMap;
		} else if (urlParts.length > 2) {
			System.out
				.println("URL contained more than one '?' character, couldn't parse parameter part of url");
			return parameterMap;
		} else {
			String[] keyValuePair = urlParts[1].split("&");
			for (String pair : keyValuePair) {
				String key = pair.split("=")[0];
				String value = pair.split("=")[1];
				parameterMap.put(key, value);
			}
		}
		return parameterMap;
	}

	/**
	 * Remove one parameter (key and value) entirely from URL.
	 * @param url
	 * @param paramToDelete
	 * @return
	 */
	public static String removeParam(String url, String paramToDelete) {
			String newUrl = "";

			try {
				String baseUrl;
				String[] urlParts = url.split("\\?");
				if (urlParts.length == 1) {
					newUrl = url + "?";
				} else if (urlParts.length > 2) {
					System.out
						.println("URL contained more than one '?' character, couldn't parse parameter part of url");
					return url;
				} else {
					baseUrl = urlParts[0];
					String[] keyValuePair = urlParts[1].split("&");
					Map<String, String> map = new HashMap<String, String>();
					for (String pair : keyValuePair) {
						String key = pair.split("=")[0];
						String value = pair.split("=")[1];					
						//Don't put paramToDelete back to map before reconstruction
						if (!paramToDelete.equals(key))
							map.put(key, value);
					}

					//Reconstruct url
					newUrl += baseUrl + "?";
					int index = 1;
					for (Entry<String, String> set : map.entrySet()) {
						String key = set.getKey();
						String value = set.getValue();
						newUrl += key + "=" + value;
						//Don't add '&' to last parameter
						if (index != map.size()) {
							newUrl += "&";
						}
						index++;
					}

				}
				return newUrl;
			} catch (Exception e) {
				logger.fatal("Error while trying to parse URL: {0}" + url);
				return url;
			}
		}
	
	public static String doPOST(String url, Map<String, String> params) {
		
		StringBuffer response = new StringBuffer();
		try {
			
			logger.info("Sending POST request to URL: " + url);
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection)obj.openConnection();
	
			//Add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			String urlParameters = "";
			for(String key : params.keySet()) {
				urlParameters += key;
				urlParameters += "=";
				urlParameters += params.get(key);
				urlParameters += "&";
			}
			
			logger.info("POST parameters: " + urlParameters);
			
			//Send POST request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
	
			int responseCode = con.getResponseCode();
			logger.debug("Response code:" + responseCode);
	
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}
		catch (Exception e) {
			logger.error("Error while doing POST request to URL:" + url);
			e.printStackTrace();
		}
		
		logger.info("POST response:" + response.toString());
		
		return response.toString();
	}
		
	/***
	 * Get base URL from HTTP request. Returned base url is in format like 'http://localhost:8040'
	 * @param request
	 * @return
	 */
	public static String getBaseUrl(HttpServletRequest request) {
		String baseURL = request.getScheme() + "://" + request.getServerName();
		
		//Only add port information, if they are not default ports for http or https
		if(request.getScheme().equals("http") && request.getServerPort() != 80) {
			baseURL += ":" + request.getServerPort();
		}
		else if(request.getScheme().equals("https") && request.getServerPort() != 443) {
			baseURL += ":" + request.getServerPort();
		}
		
		return baseURL;
	}
	
	/**
	 * Check if HTTP-request is Ajax request
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		 return "XMLHttpRequest".equals(
					request.getHeader("X-Requested-With"));
	}	
}
