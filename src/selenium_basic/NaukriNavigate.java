package selenium_basic;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriNavigate {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".//Driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		Set<String> parentWin=driver.getWindowHandles();
		int count=parentWin.size();		
		System.out.println("Total child window is :"+(count-1));
		for(String childWin:parentWin) {
			driver.manage().window().maximize();
			driver.switchTo().window(childWin);
			System.out.println("Title of window :"+driver.getTitle());	
			}
		driver.switchTo().parentFrame();
			 driver.quit();
			 
	}
}
