/**
 * Created by xiaokaiwang on 3/1/16.
 */

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebDriver;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HelpTest {

    /**
     * As a user,
     * I would like to be able seek help when have any problems,
     * So that I don't have to waste time on searching around.
     * @author xwang
     */


    static WebDriver driver = new HtmlUnitDriver();
    // start at home page for every tests
    @Before
    public void setUp()throws Exception{

        driver.get("https://www.reddit.com/");


    }

    // Given that you are on the home page,
    // When user click site rules at the bottom of the page,
    // Then the site rules page is loaded.


    @Test
    public void aRulesTest() throws Exception{
        driver.findElement(By.linkText("site rules")).click();
        assertTrue(driver.findElement(By.id("section_reddit_content_policy")).isDisplayed());
        assertTrue(driver.findElement(By.id("section_unwelcome_content")).isDisplayed());
        assertTrue(driver.findElement(By.id("section_prohibited_behavior")).isDisplayed());
        assertTrue(driver.findElement(By.id("section_nsfw_.28not_safe_for_work.29_content")).isDisplayed());
        assertFalse(isElementPresent(By.linkText("Submit a new link")));
    }

    // Given that you are on the home page,
    // When user click FAQ at the bottom of the page,
    // Then the FAQ page is loaded.

    @Test
    public void bFaqTest() throws Exception{
        driver.findElement(By.linkText("FAQ")).click();
        assertTrue(driver.findElement(By.className("search")).isDisplayed());
        assertTrue(driver.findElement(By.className("knowledge-base")).isDisplayed());
        assertFalse(isElementPresent(By.linkText("Submit a new link")));
    }

    // Given that you are on the home page,
    // When user click wiki at the bottom of the page,
    // Then the wiki page is loaded.

    @Test
    public void cWikiTest() throws Exception{
        driver.findElement(By.linkText("wiki")).click();
        assertTrue(driver.findElement(By.className("wikititle")).isDisplayed());
        assertTrue(driver.findElement(By.className("toc")).isDisplayed());
        assertTrue(driver.findElement(By.id("wiki_the_essentials__________")).isDisplayed());
        assertTrue(isElementPresent(By.linkText("Submit a new link")));
    }

    // Given that you are on the home page,
    // When user click reddiquette at the bottom of the page,
    // Then the reddiquette page is loaded.

    @Test
    public void dReddiquetteTest() throws Exception{
        driver.findElement(By.linkText("reddiquette")).click();
        assertTrue(driver.findElement(By.id("wiki_please__do")).isDisplayed());
        assertTrue(driver.findElement(By.id("wiki_please__don.27t")).isDisplayed());
        assertTrue(isElementPresent(By.linkText("Submit a new link")));
        assertTrue(isElementPresent(By.linkText("Submit a new text post")));
    }

    // Given that you are on the home page,
    // When user click contact us at the bottom of the page,
    // Then the contact page is loaded.

    @Test
    public void eContactUsTest() throws Exception{
        driver.findElement(By.linkText("contact us")).click();
        assertTrue(driver.findElement(By.className("space-snoo")).isDisplayed());
        assertTrue(driver.findElement(By.id("message-the-admins")).isDisplayed());
        assertTrue(driver.findElement(By.id("ask-a-question")).isDisplayed());
        assertNotNull(driver.findElement(By.id("report-a-bug")));
        assertFalse(isElementPresent(By.linkText("Submit a new link")));
        assertFalse(isElementPresent(By.linkText("Submit a new text post")));
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
