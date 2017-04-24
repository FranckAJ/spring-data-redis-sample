package br.edu.ifpb.ads.util;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 *
 */
public class Util {
	
	private final static String DIST = "REDIS/DOCSREDIS";
	private final static String ORIG = "REDIS/DOCS";
	private final static String PATH_DOC_ORIG = ORIG + "/";
	private final static String PATH_DOC_DEST = DIST + "/";

	public static void createFolders(){
		
		File directory = new File(DIST);
		File directOrigin = new File(ORIG);

		if (!directory.exists()) {
			directory.mkdirs();
		}
		
		if(!directOrigin.exists()){
			directOrigin.mkdirs();
		}
	}

	public static void bytesToDoc(byte[] img, String key) {
		byte[] imgBytes = img;
		try {

			File directory = new File(DIST);

			if (!directory.exists()) {
				directory.mkdirs();
			}

			FileOutputStream fos = new FileOutputStream(PATH_DOC_DEST +"REDIS_"+key);
			fos.write(imgBytes);
			FileDescriptor fd = fos.getFD();
			fos.flush();
			fd.sync();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param image
	 * @return
	 * @throws IOException
	 */
	public static byte[] docToByte(String name) throws IOException {

		String doc = PATH_DOC_ORIG + name;

		InputStream is = null;
		byte[] buffer = null;
		is = new FileInputStream(doc);
		buffer = new byte[is.available()];
		is.read(buffer);
		is.close();
		return buffer;
	}


}
