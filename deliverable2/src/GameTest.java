import org.junit.*;

import org.mockito.*;



import static org.mockito.Mockito.*;
/**
 * Created by Xiaokai on 2/09/2016.
 */
public class GameTest {

    Game g;

    @Mock
    Rooms mockRooms = mock(Rooms.class);
    Player mockPlayer = mock(Player.class);


    /**
     * Test invalid instruction
     * @throws Exception
     */
    @Test
    public void testDoSomethingInvalid() throws Exception {
        g = new Game(mockPlayer, mockRooms);
        g.doSomething("trt65");
        verifyZeroInteractions(mockPlayer);
        verifyZeroInteractions(mockRooms);
    }

    /**
     * Test valid instruction H
     * @throws Exception
     */
    @Test
    public void testDoSomethingValid1() throws Exception {
        g = new Game(mockPlayer, mockRooms);
        g.doSomething("H");
        verifyZeroInteractions(mockPlayer);
        verifyZeroInteractions(mockRooms);
    }


    /**
     * Test empty input
     * @throws Exception
     */
    @Test
    public void testDoSomethingEmpty() throws Exception{
        g = new Game(mockPlayer, mockRooms);
        g.doSomething("");
        verifyZeroInteractions(mockPlayer);
        verifyZeroInteractions(mockRooms);
    }


}