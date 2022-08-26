package seleenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement createaccount= driver.findElement(By.linkText("Create New Account"));
		createaccount.click();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String parent = itr.next();
		System.out.println("parent id is : " + parent);
		String child = itr.next();
		System.out.println("child id is : " + child);
		
		driver.switchTo().window(child);
		
		driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("sahil");
		driver.findElement(By.xpath("//input[@name=\'lastname\']")).sendKeys("pahuja");
		driver.findElement(By.xpath("//input[@name=\'reg_email__\']")).sendKeys("ssahhiillppaahhuja73@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"reg_passwd__\"]")).sendKeys("sahil123");
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		

		Select selday = new Select(day);
		selday.selectByVisibleText("12");
		Select selmonth = new Select(month);
		selmonth.selectByVisibleText("Feb");
		Select selyear = new Select(year);
		selyear.selectByVisibleText("2008");
		
		driver.findElement(By.xpath("//label[text() ='Male']")).click();
		
		
		 driver.findElement(By.linkText("Sign Up")).click();
		 
		
		driver.switchTo().window(parent);
		
	
	}

}
