package selenium.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Bookingcom {
	
private WebDriver driver;
FileInputStream filein;
public XSSFWorkbook wb;
public XSSFSheet sh;
public XSSFRow row;


	
	@BeforeTest
	public void openBrowser() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@DataProvider(name="logindata")
	public Object[][] logdataFromExcel() throws IOException{
	
		filein=new FileInputStream(".\\"+"src\\test\\resources\\Exceltestdata.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(filein);
	XSSFSheet sh=wb.getSheet("Sheet1");
	int norows=sh.getLastRowNum();
	int cols=sh.getRow(0).getLastCellNum();
	Object[][] td=new Object[norows][cols];
	for(int i=1;i<=norows;i++) {
		for(int j=0;j<cols;j++) {
			DataFormatter df=new DataFormatter();
		td[i-1][j]=	df.formatCellValue(sh.getRow(i).getCell(j));
		}
		System.out.println();
	}
	wb.close();
	filein.close();
	return td;
	}
	
	
	@Test(dataProvider = "logindata")
	public void dynamicCalendar(String checkinddate, String checkoutdate) throws InterruptedException {
		driver.navigate().to("https://www.booking.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']")).click();
		Thread.sleep(2000);
		String checkinmonth="June 2024";
		
		String checkoutmonth="July 2024";
		
		while(true){
			String s=driver.findElement(By.xpath("(//h3[@class='e1eebb6a1e ee7ec6b631'])[1]")).getText();
			if(s.equals(checkinmonth)) {
				break;
			}else {
				driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			}
		}
		Thread.sleep(2000);
		
		List<WebElement> ls=driver.findElements(By.xpath("(//tbody)[1]//tr//td//span/span"));
		for(WebElement t:ls) {
			String d=t.getText();
			if(d.equals(checkinddate)) {
			t.click();
			break;
		}
		}
		while(true){
			String s=driver.findElement(By.xpath("(//h3[@class='e1eebb6a1e ee7ec6b631'])[2]")).getText();
			if(s.equals(checkoutmonth)) {
				break;
			}else {
				driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			}
		}
		
		List<WebElement> ls1=driver.findElements(By.xpath("(//tbody)[2]//tr//td//span/span"));
		for(WebElement t1:ls1) {
			String d1=t1.getText();
			if(d1.equals(checkoutdate)) {
			t1.click();
			break;
		}
		}
	}

}
