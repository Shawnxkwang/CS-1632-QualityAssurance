import org.junit.*;
import java.io.*;
import org.mockito.*;


import static org.junit.Assert.*;

/**
 * Created by Xiaokai on 2/09/2016.
 */
public class PlayerTest {



    /**
     * Test to check player has all three items
     * @throws Exception
     */
    @Test
    public void testHasAllItems() throws Exception {
        Player p = new Player();

        assertFalse("Player has no items", p.hasAllItems());

        p.getSugar();
        assertFalse("Player only has sugar", p.hasAllItems());

        p.getCream();
        assertFalse("Player only has sugar and cream", p.hasAllItems());

        p.getCoffee();
        assertTrue("Player has all items", p.hasAllItems());
    }

    /**
     * Test only two items
     */
    @Test
    public void testHasAllItems_twoItems() {
        Player p = new Player();

        p.getSugar();

        p.getCream();

        assertFalse("Player has two items", p.hasAllItems());

    }

    /**
     * Test to check there is only one item
     */
    @Test
    public void testHasAllItems_oneItem() {
        Player p = new Player();

        p.getSugar();

        assertFalse("Player has one item", p.hasAllItems());

    }


    /**
     * Test to check drink condition
     * @throws Exception
     */
    @Test
    public void testDrink() throws Exception {

        Player p = new Player();

        assertFalse("Player has no items at all, and should lose", p.drink());

        p.getSugar();
        assertFalse("Player has one item, and should lose", p.drink());

        p.getCream();
        assertFalse("Player has two items, and should lose", p.drink());

        p.getCoffee();
        assertTrue("Player has all three items, and should win", p.drink());
    }
}