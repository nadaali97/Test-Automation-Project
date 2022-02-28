package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class SearchPage extends PageBase {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	By title=By.xpath("//a[@data-q=\"gumtree-logo\"]");

	List<WebElement> links;
	
	public boolean isLinksgreaterThanOne(String keyword){
		links = driver.findElements(By.partialLinkText(keyword));
		if (links.size()>=1) {
			return true;
		}
		return false; 
		}
	
	public void openlinks() {
		 
		for(WebElement link:links) {
			controlClick(link);
		}
		
		}
	
	public boolean navigateBetweenTabs() {
		
		Set<String>openedTabs= getAllWindows();

		openedTabs.remove(getCurrentWindow());

		for(String tab:openedTabs) {
			selectTab(tab);
			
			if(!isElementVisible(title)) {
				
				return false;
			}
			
		}
		return true;
		

	}
	}
	

