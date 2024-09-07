package PageObject;

import java.util.ArrayList;
import java.util.List;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Utilities.ReadConfig;

public class PageObjectPwc extends BaseClass {
	String top_root_ele_path = "//book-app[@apptitle='BOOKS']";
	String app_header_path = "app-header";
	String tool_bar_bottom_path = "app-toolbar[clas='toolbar-bottom']";
	String book_input_decorator_path = "book-input-decorator";
	String input_tag_path = "input";
     SearchContext shadow_ele_1;
	String main_tag_path = "main[class=main-content']";
	String root_ele_2_path = "book-explore";
	String section_path = "section";
	String ul_path = "ul";
	String li_path = "li";
	String book_item_path = "book-item";
	String anchor_tag_path = "a";
	String class_info_section_path = "div[class='info']";
	String title_container_path = "div[class='title-container']";
	String h2_path = "h2[class='title']";

	

	

	

	

	public  void searchKeyword() throws Throwable {
		try {
			WebElement root_ele_1 = driver.findElement(By.cssSelector(top_root_ele_path));
			shadow_ele_1 = root_ele_1.getShadowRoot();
			WebElement app_header = shadow_ele_1.findElement(By.cssSelector(app_header_path));
			WebElement tool_bar_bottom = app_header.findElement(By.cssSelector(tool_bar_bottom_path));
			WebElement book_input_decorator = tool_bar_bottom.findElement(By.cssSelector(book_input_decorator_path));
			WebElement input_tag = book_input_decorator.findElement(By.cssSelector(input_tag_path));
			input_tag.sendKeys(ReadConfig.get_from_config("uri_search"));
			Actions a = new Actions(driver);
			a.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void countTotalNumbersOfBooksAndDisplayBooksname() throws Throwable {
		try {
			
			WebElement main_tag = shadow_ele_1.findElement(By.cssSelector(main_tag_path));
			WebElement root_ele_2 = main_tag.findElement(By.cssSelector(root_ele_2_path));
			SearchContext shadow_ele_2 = root_ele_2.getShadowRoot();
			WebElement section = shadow_ele_2.findElement(By.cssSelector(section_path));
			WebElement ul = section.findElement(By.cssSelector(ul_path));
			List<WebElement> li = driver.findElements(By.cssSelector(li_path));
			int total_number = li.size();
			System.out.println("Total number of book present in the page is:" + total_number);
			for (WebElement indvdl_li : li) {
				WebElement book_item = indvdl_li.findElement(By.cssSelector(book_item_path));
				SearchContext shadow_ele_3 = book_item.getShadowRoot();
				WebElement anchor_tag = shadow_ele_3.findElement(By.cssSelector(anchor_tag_path));
				WebElement class_info_section = anchor_tag.findElement(By.cssSelector(class_info_section_path));
				WebElement title_container = class_info_section.findElement(By.cssSelector(title_container_path));
				WebElement h2 = title_container.findElement(By.cssSelector(h2_path));
				System.out.println("Book title:" + h2.getText());
				books_name.add(h2.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void countTotalNumbersOfBook(ArrayList<String> books_name) throws Throwable {
		try {
			int counter = 0;
			for (String book_name : books_name) {
				if (book_name.contains(ReadConfig.get_from_config("partial_book_name"))) {
					counter++;
					System.out.println("Book_count is" + counter);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
