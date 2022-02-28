package utils;

import java.io.File;

public class Constants {
	public static final String USER_DIR = System.getProperty("user.dir") + File.separator;
	public static final String SYSTEMOS = System.getProperty("os.name");
	public static final String RESOURCES = USER_DIR +"src" + File.separator + "test" + File.separator + "resources"
			+ File.separator;
	public static final String CHROME = "Chrome";
	
	public static final String EDGE = "Edge";
	public static final String CHCAPSPATH = RESOURCES + "Capabilites" + File.separator + "Chrome.json";
	public static final String EDGECAPSPATH = RESOURCES + "Capabilites" + File.separator + "Edge.json";
	public static final String CONFIGPATH = RESOURCES + "config" + File.separator + "config.properties";
	public static final String REPORT=USER_DIR+"Reports"+ File.separator ;
}
