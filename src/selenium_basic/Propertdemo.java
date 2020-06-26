package selenium_basic;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Propertdemo {
	
	public static void main(String[] args) throws Exception {
		File file=new File(".//Properties//config.properties");
		FileInputStream fins=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fins);
		System.setProperty("webdriver.chrome.driver",".//Driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String user=prop.getProperty("username");
		String pass=prop.getProperty("password");
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@name=\"Submit\"]")).click();
		driver.close();		
		}

}
