package selenium_basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook_signup {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".//Driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("firstname")).sendKeys("Abhay");
		driver.findElement(By.name("lastname")).sendKeys("Mane");
		driver.findElement(By.name("reg_email__")).sendKeys("abhaymane@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("abhay@123");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abhaymane@gmail.com");
		WebElement birth_day=driver.findElement(By.id("day"));
		WebElement birth_month=driver.findElement(By.id("month"));
		WebElement birth_year=driver.findElement(By.id("year"));
		Select sel=new Select(birth_day);
		sel.selectByIndex(10);
		Select sel1=new Select(birth_month);
		sel1.selectByVisibleText("Jun");
		Select sel2=new Select(birth_year);
		sel2.selectByVisibleText("1990");
		WebElement f_radiobtn=driver.findElement(By.id("u_0_6"));
		WebElement m_radiobtn=driver.findElement(By.id("u_0_7"));
		m_radiobtn.click();
		System.out.println("Female button is displayed: "+f_radiobtn.isDisplayed());
		System.out.println("Male button is enabled: "+m_radiobtn.isEnabled());
		System.out.println("Male button is checked: "+m_radiobtn.isSelected());
		
		driver.close();		
		
	}

}
