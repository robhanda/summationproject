package sep_dataprovider;

import java.util.Map;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class driver_summation extends base_summation{
	
	//public static ExtentReports extentreport;
	
	
	
	public static Logger log = Logger.getLogger(driver_summation.class);
	
	SoftAssert sassert = new SoftAssert();
	
	
	@Test(dataProvider="dp_sum",dataProviderClass=sep_dataprovider.dataprovider_summation.class,groups={"smoke"})
	public void test_summation(Map cal1)
	
	{
		
		extenttest=extentreport.startTest("summation case");
		
		String num1 = cal1.get("Num1").toString();
		String num2 = cal1.get("Num2").toString();
		String exp_result = cal1.get("Exp_Result").toString();
		
		double number1 = Double.parseDouble(num1);
		double number2 = Double.parseDouble(num2);
		double expected_result= Double.parseDouble(exp_result);
		
		double actual_result= number1+number2;
		extenttest.log(LogStatus.PASS, "details correctly read from excel");
		System.out.println(actual_result);
		
		log.info("starting test case");
		
		if (actual_result==expected_result)
		{
			
			log.info("Passed as actual result is" +actual_result +"and expected result is "+expected_result);
			//System.out.println("pass");
			extenttest.log(LogStatus.PASS, "Passed as actual result is" +actual_result +"and expected result is "+expected_result);
			
		}
		
		else
		{
			log.info("Failed as actual result is" +actual_result +"and expected result is "+expected_result);
			//System.out.println("fail");
			sassert.fail("Failed as actual result is" +actual_result +"and expected result is "+expected_result);
			extenttest.log(LogStatus.FAIL, "Failed as actual result is" +actual_result +"and expected result is "+expected_result);
			
		}
		
		stopectentreports();
		System.out.println("assert testing");
		sassert.assertAll();
		
	}
	
	
	@Test(dataProvider="dp_sum",dataProviderClass=sep_dataprovider.dataprovider_summation.class,groups={"regression"})
	public void print( Map cal1)
	
	{
		
		System.out.println("this is just testing of testng xml");
		String num1 = cal1.get("Num1").toString();
		String num2 = cal1.get("Num2").toString();
		String exp_result = cal1.get("Exp_Result").toString();
		
		System.out.println(num1);
		
	}
	
	
	

}
