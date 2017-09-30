package sep_dataprovider;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class base_summation {
	

	public static ExtentReports extentreport;
	
	public static ExtentTest extenttest;
	
	@BeforeTest
	public static void startextentreports()
	
	{
		
		Date date = new Date();
		SimpleDateFormat df = new  SimpleDateFormat("yyyy-DD-MM hh-mm-ss");
		String report = df.format(date);
		
		extentreport = new ExtentReports("D:\\BB_Project\\Report\\"+"extentreports"+report+".html",false);
		
		
		
		
	}
	
	public static void stopectentreports()
	
	{
		
		extentreport.endTest(extenttest);
		extentreport.flush();
		
		
	}
	
	
}
