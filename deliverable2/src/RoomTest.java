import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Xiaokai on 2/09/2016.
 */
public class RoomTest {




    /**
     * Test to check all items are in the room.
     * @throws Exception
     */
    @Test
    public void testHasItemAllTrue() throws Exception {
        Room tr = new Room(true,true,true,false,false);
        boolean result = tr.hasItem();
        assertTrue(result);
    }

    /**
     * Test to check two items are in the room.
     * @throws Exception
     */
    @Test
    public void testHasItem2True() throws Exception {
        Room tr = new Room(true,true,false,false,false);
        boolean result = tr.hasItem();
        assertTrue(result);
    }
    /**
     * Test to check one items is in the room.
     * @throws Exception
     */
    @Test
    public void testHasItemOneTrue() throws Exception {
        Room tr = new Room(true,false,false,false,false);
        boolean result = tr.hasItem();
        assertTrue(result);
    }
    /**
     * Test to check no items is in the room.
     * @throws Exception
     */
    @Test
    public void testHasItemAllFalse() throws Exception {
        Room tr = new Room(false,false,false,false,false);
        boolean result = tr.hasItem();
        assertFalse(result);
    }

    /**
     *   Test to check sugar is in the room
     *   @throws Exception
     */
    @Test
    public void testHasSugarTrue() throws Exception {
        Room tr = new Room(false, false, true, false, false);
        boolean result = tr.hasSugar();

        assertTrue(result);
    }

    /**
     * Test to check sugar is not in the room
     * @throws Exception
     */
    @Test
    public void testHasSugarFalse() throws Exception {
        Room tr = new Room(false, false, false, false, false);
        boolean result = tr.hasSugar();

        assertFalse(result);
    }

    /**
     * Test to check cream is in the room
     * @throws Exception
     */
    @Test
    public void testHasCreamTrue() throws Exception {
        Room tr = new Room(false, true, false, false, false);
        boolean result = tr.hasCream();

        assertTrue(result);
    }

    /**
     * Test to check cream is not in the room
     * @throws Exception
     */
    @Test
    public void testHasCreamFalse() throws Exception {
        Room tr = new Room(false, false, false, false, false);
        boolean result = tr.hasCream();

        assertFalse(result);
    }

    /**
     * Test to check coffee is in the room
     * @throws Exception
     */
    @Test
    public void testHasCoffeeTrue() throws Exception {
        Room tr = new Room(true, false, false, false, false);
        boolean result = tr.hasCoffee();

        assertTrue(result);
    }

    /**
     * Test to check coffee is not in the room.
     * @throws Exception
     */
    @Test
    public void testHasCoffeeFalse() throws Exception {
        Room tr = new Room(false, false, false, false, false);
        boolean result = tr.hasCoffee();

        assertFalse(result);
    }

    /**
     * Test to check the north exit exists.
     * @throws Exception
     */
    @Test
    public void testNorthExitExists() throws Exception {
        Room tr = new Room(false, false, false, true, false);
        boolean result = tr.northExit();

        assertTrue(result);
    }

    /**
     * Test to check the north exit does not exist.
     * @throws Exception
     */
    @Test
    public void testNorthExitNotExist() throws Exception {
        Room tr = new Room(false, false, false, false, false);
        boolean result = tr.northExit();

        assertFalse(result);
    }

    /**
     * Test to check the south exit exists.
     * @throws Exception
     */
    @Test
    public void testSouthExitExists() throws Exception {
        Room tr = new Room(false, false, false, false, true);
        boolean result = tr.southExit();
        assertTrue(result);
    }


    /**
     * Test to check the south exit does not exist.
     * @throws Exception
     */
    @Test
    public void testSouthExitNotExist() throws Exception {
        Room tr = new Room(false, false, false, false, false);
        boolean result = tr.southExit();
        assertFalse(result);
    }

    /**
     * Test to check two same rooms with same descriptions.
     * @throws Exception
     */
    @Test
    public void testGetDescriptionSame() throws Exception {
        Room tr1 = new Room(false, true, false, false, true);
        String result1 = tr1.getDescription();

        Room tr2 = new Room(false, true, false, false, true);
        String result2 = tr2.getDescription();

        assertNotEquals(result1, result2);
    }

    /**
     * Test to check two different rooms with different descriptions.
     * @throws Exception
     */
    @Test
    public void testGetDescriptionDiff() throws Exception {
        Room tr1 = new Room(false, false, false, false, false);
        String result1 = tr1.getDescription();

        Room tr2 = new Room(true, true, true, true, true);
        String result2 = tr2.getDescription();

        assertNotEquals(result1, result2);
    }

}