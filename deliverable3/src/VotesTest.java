
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebDriver;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class VotesTest {
    /**
     * As a user
     * I want to be able to see the vote ratings on a post
     * So I can make a better decision on what post to visit
     */
	private WebDriver driver = new HtmlUnitDriver();
	private String baseUrl;

	@Before
	public void setUp()throws Exception
	{
		baseUrl = "https://www.reddit.com";
	}
//    Given a search from the home page,
//    When the results appear,
//    Then I should see the number of votes.

	@Test
	public void testHomeSearchVotes() throws Exception
	{
		driver.get(baseUrl + "/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("whales");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//div[4]/div/header/span"));
		assertTrue(isElementPresent(By.xpath("//div[4]/div/div/div/div/div/span[2]")));
	}
    //Given that you are not logged into a reddit account,
    //When I vote on a post,
    //Then I will be prompted to log in.
	@Test
	public void testRedditLoginVotes() throws Exception
	{
        driver.get(baseUrl + "/");
        WebElement e = driver.findElement(By.xpath("//div[3]/div[3]/div/div/div/div"));
        e.click();
        Thread.sleep(1000);
        assertTrue(isElementPresent(By.id("login-popup")));

	}
    //Given I click on a post,
    //When it loads,
    //Then I should be able to see the vote ratings of that single post.
	@Test
	public void testPostVotes() throws Exception
	{
		driver.get(baseUrl + "/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("politics");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//div[4]/div/header/span")).click();
		assertTrue(isElementPresent(By.xpath("//div[4]/div/div/div/div/div/span[2]")));
	}

//    Given that you are not logged into a reddit account,
//    When I vote on a post,
//    Then its total votes remains unchanged.
	@Test
	public void testPostVotes2() throws Exception
	{

        driver.get(baseUrl + "/");
        int votes = driver.findElements(By.cssSelector("div.midcol.unvoted")).size();
        WebElement clk = driver.findElement(By.xpath("//div[3]/div[3]/div/div/div/div"));
        clk.click();
        assertEquals(votes, driver.findElements(By.cssSelector("div.midcol.unvoted")).size());
	}

	private boolean isElementPresent(By b)
	{
		try {
			driver.findElement(b);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	 private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}