package selenium.pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowHandles {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
//		String winid=driver.getWindowHandle(); //return the current page window id
		
//		System.out.println(winid);
		
	WebElement ele=	driver.findElement(By.xpath("//a[text()='Facebook']"));

		Thread.sleep(3000);

		ele.click();
		Thread.sleep(3000);
		
		List<String> s=new ArrayList<String>( driver.getWindowHandles()); //return all browser windows and store it in list
		
		for (String temp:s) {											//use any loops to get the window id
			String title=driver.switchTo().window(temp).getTitle();
			System.out.println(title);
			if(title.equals("nopCommerce demo store")){
				driver.close();
			}
		}
		
//		for(int i=0;i<s.size();i++) {
//		//	System.out.println(s.get(i));
//			String title=driver.switchTo().window(s.get(i)).getTitle();
//			System.out.println(title);
//		}
		
//		Iterator<String> it=s.iterator();
//		
//		while(it.hasNext()) {
//			//System.out.println(it.next());
//			String title=driver.switchTo().window(it.next()).getTitle();
//			System.out.println(title);
//		}
		
		
		
//		String parentwindow=s.get(0);
//		
//		System.out.println (parentwindow);
//		
//		String childwin=s.get(1);
//		
//		System.out.println(childwin);
		
//		System.out.println(s2); //return child window/next window id
		
		
		
		
//		driver.switchTo().window(childwin);
		




//driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[1]/div/i")).click();
		

		

		
	//	driver.close(); //only current browser window will be closed
		
		driver.quit(); //it will close all browser windows
		
	}

}
