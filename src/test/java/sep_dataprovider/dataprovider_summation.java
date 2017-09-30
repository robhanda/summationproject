package sep_dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

public class dataprovider_summation {
	
	@DataProvider(name="dp_sum")
	public static Iterator<Object[]> getsummationData() throws IOException
	
	{
		
		ExcelReadWrite xl =new ExcelReadWrite("D:\\Sum1.xls");
		
		HSSFSheet sheet = xl.Setsheet("Sheet1");
		
		int rowcount = xl.getrowcount(sheet);
		
		List<Object[]> arr_list = new ArrayList<Object[]>();
		
		
		
		for(int i=1;i<=rowcount;i++)
			
		{
			Map<String,String> dsmap = new HashMap<String,String>();
			
			dsmap.put(xl.Readvalue(sheet, 0, "Num1"), xl.Readvalue(sheet, i, "Num1"));
			dsmap.put(xl.Readvalue(sheet, 0, "Num2"), xl.Readvalue(sheet, i, "Num2"));
			dsmap.put(xl.Readvalue(sheet, 0, "Exp_Result"), xl.Readvalue(sheet, i, "Exp_Result"));
			
			Object[] obj = new Object[1];
			obj[0]=dsmap;
			
			arr_list.add(obj);
					
			
		}
		
			return arr_list.iterator();
		
	}

}
