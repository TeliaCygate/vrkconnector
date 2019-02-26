package com.propentus.sp2.componentlibrary.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
	
	/**
	 * Read file content using UTF-8 as charset.
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String path) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, Charset.forName("UTF-8"));
	}
	
}
