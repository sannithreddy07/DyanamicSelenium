package selenium.pack;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicWTmethod2 {

	public WebDriver driver;
	@Test
	public void tabledata() throws InterruptedException{


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

		String totalentries=driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[2]/div[2]")).getText().split(" ")[5];

		int paginationsize=driver.findElements(By.xpath("//div[@class='col-sm-6 text-start']/ul/child::li")).size();

		System.out.println(paginationsize);

		List<String> ls=new ArrayList<String>();

		List<String> ls2=new ArrayList<String>();

		int sz=paginationsize-2;



		for(int i=1;i<=sz;i++) {

			WebElement ele=driver.findElement(By.xpath("//ul[@class='pagination']/li[@class='page-item active']"));

			String pageno=ele.getText();

			System.out.println("page no: "+pageno);

			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();

			System.out.println("no of rows in "+pageno+"  "+rows);

			int cols=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead//tr[1]//td")).size();

			List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td[2]"));

			for(WebElement temp:list) {

				ls.add(temp.getText());

			}

			for(int j=1;j<=rows;j++) {

				for(int k=2;k<cols;k++) {

					List<WebElement> list2=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+j+"]/td["+k+"]"));

					for(WebElement temp1:list2) {

						ls2.add(temp1.getText());

					}
				}
			}

			if(i==sz)break;

			String p=Integer.toString(i+1);

			WebElement nxt=driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+p+"']"));

			Actions ac=new Actions(driver);

			Thread.sleep(2000);

			ac.moveToElement(nxt).click().build().perform();

			Thread.sleep(2000);

		}

		int entries=ls.size();

		System.out.println(entries);

		for(String templs2:ls2) {

			System.out.println(templs2);
		}

		System.out.println(totalentries);

		Assert.assertEquals(String.valueOf(entries), totalentries);

		driver.quit();

	}
}





//WebDriverWait wt1=new WebDriverWait(driver, Duration.ofSeconds(10));
//wt1.until(ExpectedConditions.elementToBeClickable(nxt));
//
//nxt.click();


//JavascriptExecutor js=((JavascriptExecutor)driver);
//try {
//js.executeScript("arguments[0].click();", nxt);
//}catch(StaleElementReferenceException e) {
//	js.executeScript("arguments[0].click();", nxt);
//}	







