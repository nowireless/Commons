package org.nowireless.commons.nativehelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class NativeHelper {

	public enum Platform {
		WINDOWS,
		MAC,
		OTHER
	}
	
	private volatile boolean libraryLoaded;
	private File jniLibrary = null;

	public void load() {
	    if (!libraryLoaded) {
	        try {
	          String osname = System.getProperty("os.name");
	          String resname;
	          Platform platform;
	          if (osname.startsWith("Windows")) {
	        	  platform = Platform.WINDOWS;
	          }else if (osname.startsWith("Mac")) {
	        	  platform = Platform.MAC;
	          }else{
	        	  platform = Platform.OTHER;
	          }
	          
	          resname = this.getResourceName(platform);
          
	          System.out.println("platform: " + resname);
	          
	          
	          
	          InputStream is = this.getClass().getResourceAsStream(resname);
	          if (is != null) {
	            // create temporary file
	            jniLibrary = File.createTempFile(this.getLibraryName(platform), this.getLibraryName(platform));
	            // flag for delete on exit
	            jniLibrary.deleteOnExit();
	            OutputStream os = new FileOutputStream(jniLibrary);

	            byte[] buffer = new byte[1024];
	            int readBytes;
	            try {
	              while ((readBytes = is.read(buffer)) != -1) {
	                os.write(buffer, 0, readBytes);
	              }
	            } finally {
	              os.close();
	              is.close();
	            }
	            try {
	              System.load(jniLibrary.getAbsolutePath());
	            } catch (UnsatisfiedLinkError e) {
	              System.loadLibrary(this.getLibraryName());
	            }
	          } else {
	            System.loadLibrary(this.getLibraryName());
	          }
	        } catch (IOException ex) {
	          ex.printStackTrace();
	          System.exit(1);
	        }
	        libraryLoaded = true;
	      }

	}

	protected abstract String getResourceName(Platform platform);
	protected abstract String getLibraryName();
	protected abstract String getLibraryName(Platform platform);
	
	protected String getLibExtension(Platform platform) {
		switch(platform) {
		case WINDOWS:
			return ".dll";
		case MAC:
			return ".dylib";
		case OTHER:
		default:
			return ".so";
		}
	}
	
}
