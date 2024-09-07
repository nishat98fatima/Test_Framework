package StepDefinition_file;

import PageObject.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GlueCodePwc extends BaseClass{
	PageObjectPwc obj=null;
	@Given ("Search the given keyword.")
	public void searchTheGivenKeyword()throws Throwable {
		obj=new PageObjectPwc();
		obj.searchKeyword();
		
		
		
	}
	
	@And ("Total numbers of book present in page")
	public void totalNumbersOfBookPresentInPage() throws Throwable{
		obj.countTotalNumbersOfBooksAndDisplayBooksname();
		
	}
	@Then ("Find the book name and count the number having phrase {string}.")
	public void findBookNameAndCountNumber(String book) throws Throwable {
		obj.countTotalNumbersOfBook(books_name);
		
	}
    
		
	

}
