package SeleniumProject.SeleniumProject;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YouTube {

	int count = 0;

	public void playmultipleVideoOnYoutube(String webSiteDomain, WebDriver driver) throws InterruptedException {
		driver.navigate().to(webSiteDomain);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		List<WebElement> list = driver
				.findElements(By.xpath("//div[@id='content' and @class='style-scope ytd-rich-item-renderer']"));
		Actions action = new Actions(driver);
		for (WebElement element : list) {
			String title = element.getText();
			count = count + 1;
			action.moveToElement(element).click().build().perform();
			Thread.sleep(3000);
			System.out.println(count + ". Video Played" + " and the Title is = " + title);
			action.sendKeys(Keys.ESCAPE).build().perform();
			Thread.sleep(3000);
			driver.navigate().back();
			action.sendKeys(Keys.ESCAPE).build().perform();
			Thread.sleep(3000);
			System.out.println("\n****************************************");
		}
	}

	public void playmultipleVideoOnYoutubeInTabs(String webSiteDomain, WebDriver driver) throws InterruptedException {
		driver.navigate().to(webSiteDomain);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		List<WebElement> list = driver
				.findElements(By.xpath("//div[@id='content' and @class='style-scope ytd-rich-item-renderer']"));
		Actions action = new Actions(driver);
		String mainTab = driver.getWindowHandle();
		for (WebElement element : list) {
			String title = element.getText();
			if (count >= 5) {

				break;
			} else {
				action.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
				System.out.println(count + ". Video Played" + " and the Title is = " + title);
				System.out.println("\n****************************************");
				count = count + 1;
			}
			Set<String> allTabs = driver.getWindowHandles();
			for (String str : allTabs) {
				Thread.sleep(2000);
				driver.switchTo().window(str);
				
			}
			System.out.println("Switched to Tab = " + count);
			Thread.sleep(2000);
			driver.switchTo().window(mainTab);
		}

		System.out.println("End of Program");
	}

}
