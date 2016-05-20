import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
/**
 * Created by Xiaokai on 2/09/2016.
 */
public class RoomsTest {


    Rooms r = new Rooms(6);




    @Mock

    Player mockPlayer = mock(Player.class);



    @Test
    public void testGetCurrentRoomInfo()  {
        String st = r.getCurrentRoomInfo();

        assertNotNull(st);
    }

    /**
     * test to check coffee
     * @throws Exception
     */

    @Test
    public void testLookCoffee()  {
        r.moveNorth();
        r.moveNorth();

        r.look(mockPlayer);
        verify(mockPlayer).getCoffee();
    }

    /**
     * test to check sugar
     * @throws Exception
     */

    @Test
    public void testLookSugar()  {
        r.moveNorth();
        r.moveNorth();
        r.moveNorth();
        r.moveNorth();
        r.moveNorth();

        r.look(mockPlayer);
        verify(mockPlayer).getSugar();
    }


    /**
     * test to check sugar
     * @throws Exception
     */

    @Test
    public void testLookCream()  {
        r.look(mockPlayer);
        verify(mockPlayer).getCream();
    }

    /**
     * Test to check all 6 rooms generated
     */
    @Test
    public void testGenerateRooms() {
        assertNotNull(r.getCurrentRoomInfo());

        r.moveNorth();
        assertNotNull(r.getCurrentRoomInfo());
        r.moveNorth();
        assertNotNull(r.getCurrentRoomInfo());

        r.moveNorth();
        assertNotNull(r.getCurrentRoomInfo());

        r.moveNorth();
        assertNotNull(r.getCurrentRoomInfo());

        r.moveNorth();
        assertNotNull(r.getCurrentRoomInfo());
    }
}