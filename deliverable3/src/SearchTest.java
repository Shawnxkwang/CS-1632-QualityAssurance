import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebDriver;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SearchTest {
    /**
     * As a user,
     * I would like to be able to search for categories of posts
     * So that I can narrow my selection
     */
	static WebDriver driver = new HtmlUnitDriver();
	private String baseUrl;

	@Before
	public void setUp()throws Exception
	{
		baseUrl = "https://www.reddit.com";
	}

//    Given a search for whales,
//    When on the homepage,
//    Then I should see the results for whales.

    @Test
	public void testSearchWhales() throws Exception
	{
		driver.get(baseUrl + "/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("whales");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        for (int second = 0;; second++) {
    		if (second >= 60) fail("timeout");
    		try { if (isElementPresent(By.cssSelector("header.search-result-group-header"))) break; } catch (Exception e) {}
    	    Thread.sleep(1000);
        }
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://www.reddit.com/search?q=whales" );
}

//    Given a search for bananas,
//    When on the homepage,
//    Then I should see the results for bananas.

    @Test
	public void testSearchBananas() throws Exception
	{
		driver.get(baseUrl + "/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("banana");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        for (int second = 0;; second++) {
    		if (second >= 60) fail("timeout");
    		try { if (isElementPresent(By.cssSelector("header.search-result-group-header"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
	}
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://www.reddit.com/search?q=banana" );
}

//    Given a search for jazz,
//    When on the homepage,
//    Then I should see the results for jazz.
	@Test 
	public void testSearchJazz() throws Exception
	{
		driver.get(baseUrl + "/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("jazz");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        for (int second = 0;; second++) {
    		if (second >= 60) fail("timeout");
    		try { if (isElementPresent(By.cssSelector("header.search-result-group-header"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
	}
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://www.reddit.com/search?q=jazz" );
}
//    Given a search for cars,
//    When on the homepage,
//    Then I should see the results for cars.

	@Test
	public void testSearchcars() throws Exception
	{
		driver.get(baseUrl + "/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("cars");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        for (int second = 0;; second++) {
    		if (second >= 60) fail("timeout");
    		try { if (isElementPresent(By.cssSelector("header.search-result-group-header"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
	}
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://www.reddit.com/search?q=cars" );

}
//    Given a search for computers,
//    When on the homepage,
//    Then I should see the results for computers.

	@Test
	public void testSearchcomp() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("computers");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        for (int second = 0; ; second++) {
			if (second >= 60) fail("timeout");
			try {
				if (isElementPresent(By.cssSelector("header.search-result-group-header"))) break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://www.reddit.com/search?q=computers" );
    }


	private boolean isElementPresent(By by)
	{
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


}