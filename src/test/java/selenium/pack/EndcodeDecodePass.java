package selenium.pack;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EndcodeDecodePass {
	
	static String encode1(String password) {
		byte[] encodeString=Base64.encodeBase64(password.getBytes());
		return (new String(encodeString));
		
	}
	static String decode(String enpassword) {
		byte[] decodeString=Base64.decodeBase64(enpassword);
		return (new String(decodeString));
		
	}
	
	@Test
	public void endcode() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("http://183.82.103.245/nareshit/login.php");
		Thread.sleep(2000);
		driver.findElement(By.name("txtUserName")).sendKeys(decode("bmFyZXNoaXQ="));
	driver.findElement(By.name("txtPassword")).sendKeys(decode("bmFyZXNoaXQ="));
		
		driver.findElement(By.name("Submit")).click();
		driver.close();		
}
	

	
	@Test(enabled = false)
	public static void getEncode() {
		System.out.println(encode1("nareshit"));
	}


}
