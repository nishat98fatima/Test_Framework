package Utilities;

import PageObject.BaseClass;

public class CommonMethod extends BaseClass {
	public static void Launch_Browser() throws Throwable {
		try {
			
		
		driver=DriverManager.createDriver(ReadConfig.get_from_config("browser_name"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void urlOpen() throws Throwable{
		try {
			
		
		driver.get(ReadConfig.get_from_config("URL"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
