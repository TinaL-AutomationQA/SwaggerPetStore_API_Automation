package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
		//DataProvider 1
		@DataProvider(name="Data")
		public String[][]getAllData() throws IOException
		{
			String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
	         //taking xl file from testData
			XLUtility xl=new XLUtility(path);//create an object for XLUtility
			
			int totalrows=xl.getRowCount("Sheet1");
			int totalcols=xl.getCellCount("Sheet1",1);
			String apidata[][]=new String[totalrows][totalcols];//create two dimension array which can store
			for(int i=1;i<=totalrows;i++)//1 read the data from xl storing in the two dimension array
			{
				for(int j=0;j<totalcols;j++)
				{
					apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
				}
			}
			return apidata;//return two dimension array
			
		}
		
		@DataProvider(name="UserNames")
		public String[] getUserNames() throws IOException
		{
			String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
	         //taking xl file from testData
			XLUtility xl=new XLUtility(path);//create an object for XLUtility
			
			int rownum=xl.getRowCount("Sheet1");
			
			String apidata[]=new String[rownum];
			for(int i=1;i<=rownum;i++) 
			{
				
			 apidata[i-1]=xl.getCellData("Sheet1", i, 1);

			}
			return apidata;
			
		}
}
