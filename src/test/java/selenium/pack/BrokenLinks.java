package selenium.pack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {
	
private WebDriver driver;
	
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
	
	@Test(enabled = false)
	public void openAmazon() throws IOException {
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> ls=driver.findElements(By.tagName("a"));
		List<String> ls1=new ArrayList<String>();
		for(WebElement t:ls) {
			String url=t.getAttribute("href");
			ls1.add(url);
			//checkBrokenLinks(url);
		}
		System.out.println("total urls are: "+ls1.size());
		long settime=System.currentTimeMillis();
		ls1.parallelStream().forEach(e ->{  //parallelstream //sequence - ls1.stream().foreach
			try {
				checkBrokenLinks(e);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		long endtime=System.currentTimeMillis();
		System.out.println("total time="+(endtime-settime));
	}
	
	@Test
	public void brokenLink2() {
		driver.navigate().to("https://www.opencart.com/index.php?route=cms/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> ls=driver.findElements(By.tagName("a"));
		List<String> ls1=new ArrayList<String>();
		for(WebElement t:ls) {
			String url=t.getAttribute("href");
			ls1.add(url);
			//checkBrokenLinks(url);
			try {
			URL ul1=new URL(url);
			HttpURLConnection hp2=(HttpURLConnection)ul1.openConnection();
			//wait 2 seconds
			Thread.sleep(2000);
			//establish connection
			hp2.connect();
			int respcode=hp2.getResponseCode();
			if(respcode>=400) {
				System.out.println(url+" ------>"+hp2.getResponseMessage()+" is broken link");
			}else {
				System.out.println(url+" ------>"+hp2.getResponseMessage()+" not a broken link");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	
		}	
		System.out.println("total urls are: "+ls1.size());
		
	}
	
	public static void checkBrokenLinks(String urllink) throws IOException
	{
		URL u=new URL(urllink);
		HttpURLConnection hp=(HttpURLConnection)u.openConnection();
		hp.setConnectTimeout(9000);
		hp.connect();
		if(hp.getResponseCode() >=400) {
			System.out.println(urllink +"-------------> "+hp.getResponseMessage() +" is a broken link");
			
		}else {
			System.out.println(urllink +"-------------> "+hp.getResponseMessage());
		}
	}
}
