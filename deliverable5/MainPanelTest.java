/**
 * Created by xiaokaiwang on 4/2/16.
 */

import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

import org.junit.Assert;
import org.junit.Test;

public class MainPanelTest {
    MainPanel mp = new MainPanel(15);
    /*
        check if getNumNeighbors() returns the same as convertToInt()
     */
    @Test
    public void test1(){
        int i = mp.getNumNeighbors(2,3);

        assertTrue(mp.convertToInt(mp.getNumNeighbors(2,3))== i );

    }

    /*
        check pass negative number to getNumberNeighbors(), it will throw IndexOutOfBoundsException
    */
    @Test
    public void test2(){
        Throwable e = null;
        try {
            int i = mp.getNumNeighbors(-1, -2);
        }catch (Throwable ex){
            e = ex;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

    }

    /*
        check pass 0s to getNumberNeighbors(), it will not throw exceptions.
    */
    @Test
    public void test3(){

        Throwable e = null;
        try {
            int i = mp.getNumNeighbors(0, 0);
        }catch (Throwable ex){
            e = ex;
        }
        assertFalse(e instanceof IndexOutOfBoundsException);
    }

    // Manual Tests for runContinuous() method:
    /*
     *   --------#1-----------------
     *   1) click cells to make the pattern like this:
	 *
	 *  				. X .
	 *  				. X .
	 *  				. X .
	 *
	 *   2) Click the "Run Continuous" button.  The cells should alternate rapidly between red and green
	 *      ('o' represents a green cell):
	 *
	 *   				. X .		. o .
	 *  				o X o  <->	X X X
	 *  				. X .		. o .
	 *
	 *
	 *
	 * 	 3) Click the "Stop" button.  The cells should stop changing.
	 *
	 * 	--------#2-----------------
     *   1) Click the "Run Continuous" button.
     *
	 *   2) The command prompt should show the following words:
	 *
	 *	   	  "Running...
	 *       			Calculating..
	 *       			Displaying..."
	 *
	 *
     *
     *  --------#3-----------------
     *  1) Click the "Run" button.
     *
     *  2) Click the upper left corner cell make it turn to red.
     *
     *  3) Click the "Run Continuous" button.
     *
     *  4) The upper left corner cell should turn to green.
     *  
     *  5) The command prompt should show the following words continuously in a rapid speed:
	 *
	 *	   	  "Running...
	 *       			Calculating..
	 *       			Displaying..."
     *
     *  6) Click "Stop", step 5's sentences will stop generating.
     *
     */




}
