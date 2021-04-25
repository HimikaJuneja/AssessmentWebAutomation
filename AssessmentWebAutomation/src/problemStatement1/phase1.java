package problemStatement1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class phase1 {

	public static void main(String[] args) throws InterruptedException {
		
		//Initialize driver
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\himjunej\\eclipse-workspace\\AssessmentWebAutomation\\src\\driver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				//Triggering game.tv
				driver.get("https://weather.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				waitForElement(driver, 5, driver.findElement(By.xpath("//input[@id='LocationSearch_input']")));
				System.out.println(driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).isEnabled());
				
				
				
				driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).click();
				driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).sendKeys("Delhi");
				driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).sendKeys(Keys.ENTER);
				
				////div[@id='LocationSearch_listbox']/button
				driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).click();
				driver.findElement(By.xpath("//div[@id='LocationSearch_listbox']/button")).click();
	}
	public static void waitForElement(WebDriver driver,int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.
				elementToBeClickable(element));
	}

}
