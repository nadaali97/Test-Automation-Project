package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	By txtBox_SearchBox = By.name("q");
	
	public void search(String query) {
		setElement( txtBox_SearchBox, query);
		pressEnter( txtBox_SearchBox);
	}
}
