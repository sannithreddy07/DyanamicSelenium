package selenium.pack;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*
 * Dynamic Webtable 
 * 
 * You don't know how many pages, rows,cols are present in the table
 * 
 * for to get the data of dynamic table use below lines of code
 * 
 */

public class DynamicWebTable {

	public WebDriver driver;
	@Test
	public void tabledata() throws InterruptedException{

		//		ChromeOptions options = new ChromeOptions();
		//
		//		options.setExperimentalOption("excludeSwitches",
		//
		//		     Arrays.asList("disable-popup-blocking"));
		//		
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

		//	WebElement mcb=mc.findElement(By.xpath(".//div[@class='modal-content']"));

		WebElement mcbutton=mc.findElement(By.xpath(".//button[@class='btn-close']"));

		Thread.sleep(1000);

		mcbutton.click();

		Thread.sleep(1000);



		driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/ul[@id='collapse-4']/li[1]/a[1]")).click();
		String textpages=driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[2]/div[2]")).getText();
	
		System.out.println(textpages);

		int totalpages=Integer.valueOf(textpages.substring(textpages.indexOf("(")+1, textpages.indexOf("Pages")-1));
		System.out.println(totalpages);

		for(int i=1;i<=totalpages;i++) {
			

			WebElement activepage=driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));

			System.out.println("page no: "+activepage.getText());


			int totalrow=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
			System.out.println("number of rows: "+totalrow);
			
			if(i==totalpages)break;
			
			String p=Integer.toString(i+1);
			
			WebElement nxt=driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+p+"']"));
			
			Actions ac=new Actions(driver);
			Thread.sleep(2000);
			ac.moveToElement(nxt).click().build().perform();
			Thread.sleep(2000);


//			String p=Integer.toString(i+1);

//			WebElement nextpage=driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+p+"']"));
//			WebDriverWait wt1=new WebDriverWait(driver, Duration.ofSeconds(3));
//			wt1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination']/li/a[text()='"+p+"']")));
//			Actions ac=new Actions(driver);
//			try {
//			ac.click(nextpage).perform();
//			}catch(StaleElementReferenceException e) {
//				ac.click(nextpage).perform();
			}
			
			
			

//		}

		driver.quit();
	}

}
