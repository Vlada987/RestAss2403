package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
String path=System.getProperty("user.dir")+"\\Book 6.xlsx";	
ExcelGet xl=new ExcelGet(path);

@DataProvider(name="allData")
public String [][] allData() throws IOException{
	
int rows =xl.getRowCount("Sheet1");
int coll =xl.getCellCount("Sheet1", 1);
String[][]data=new String[rows][coll];
for(int r=1;r<=rows;r++) {
	for(int c=0;c<coll;c++) {
	data[r-1][c]=xl.getCelldata("Sheet1", r, c);			
	}
}
return data;	
}
@DataProvider(name="userNames")
public String[] getUserNames() throws IOException {
	
int rows =xl.getRowCount("Sheet1");
String[]uNames=new String[rows];
for(int c=1;c<=rows;c++) {
	uNames[c-1]=xl.getCelldata("Sheet1", c, 1);
}
return uNames;
	



}
	
}
