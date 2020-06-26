package selenium_basic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",".//Driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://orkut-trials65101.orangehrmlive.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Z@KexGdI95");
		driver.findElement(By.xpath("//input[@name=\"Submit\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"account-name\"]")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File(".//Screenshot//logout"+".png");
		FileUtils.copyFile(srcfile,destfile);
		System.out.println("Screenshot is captured");
		driver.close();
	}

}
