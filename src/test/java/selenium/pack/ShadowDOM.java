package selenium.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDOM {

	public WebDriver driver=null;
	@Test
	public void openbowser() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("chrome://settings/appearance");
		WebElement ele=driver.findElement(By.xpath("//settings-ui")).getShadowRoot()//first identify the shadow host with the help of xpath/id/class/name
			.findElement(By.cssSelector("settings-main#main")).getShadowRoot() //bu using getshadowRoot method we can identify the shadowroot elements using Only CSS selectors
			.findElement(By.cssSelector("settings-basic-page.cr-centered-card-container")).getShadowRoot()
			.findElement(By.cssSelector("settings-section[section='appearance']"))
			.findElement(By.tagName("settings-appearance-page")).getShadowRoot()
			.findElement(By.cssSelector("settings-toggle-button[label='Show home button']")).getShadowRoot()
			.findElement(By.cssSelector("cr-toggle#control"));
		Thread.sleep(2000);
		ele.click();
		Thread.sleep(2000);
		driver.quit();
	}
}
