package selenium.pack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicWTmethod3 {
	
	public WebDriver driver;
	@Test
	public void tabledata1() throws InterruptedException{
	

	driver=new ChromeDriver();

	driver.manage().window().maximize();

	driver.navigate().to("https://demo.opencart.com/admin/");

	driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
	WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	login.click();

	WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(50));
	wt.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));

	WebElement mc=driver.findElement(By.className("modal-dialog"));

	WebElement mcbutton=mc.findElement(By.xpath(".//button[@class='btn-close']"));

	Thread.sleep(1000);

	mcbutton.click();

	Thread.sleep(1000);


	driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")).click();
	driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/ul[@id='collapse-4']/li[1]/a[1]")).click();
	
	WebElement ele=driver.findElement(By.xpath("//ul[@class='pagination']/li[@class='page-item active']"));
	String pageno=ele.getText();
	System.out.println("page no: "+pageno);
	int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
	System.out.println("no of rows in "+pageno+"  "+rows);
	
	int cols=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead//tr[1]//td")).size();
	System.out.println("no of cols "+cols);
	
	for(int i=1;i<=rows;i++) {
		
		for(int j=2;j<cols;j++) {

		
		String cellvalue=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td["+j+"]")).getText();
		System.out.println(cellvalue);
		Thread.sleep(2000);
	}
	}
	cellData(driver,"4","5");
	cellcheck(driver,"2");
	
	driver.quit();

	}
	
	public void cellData(WebDriver driver,String i, String j) {
		String cellvalues=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td["+j+"]")).getText();
		System.out.println(cellvalues);
		
	}
	public void cellcheck(WebDriver driver,String i) {
		driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td[1]")).click();
		
	}

}
