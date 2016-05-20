/**
 * Created by xiaokaiwang on 3/22/16.
 */

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;


public class arrayTest {

    /*
        test for at least 100 arrays of different items and sizes.
     */

    public static ArrayList<int[]> arrays = new ArrayList<int[]>();
    public static ArrayList<int[]> sorted = new ArrayList<int[]>();

    //create 100 arrays + corner & edge cases
    public static void createArrays() {
        int arrayNum = 100;

        int size;
        int[] cur;
        Random rand = new Random();
        for (int i = 0; i < arrayNum; i++) {
            size = rand.nextInt(66);
            cur = new int[size];

            for (int j = 0; j < cur.length; j++) {
                cur[j] = rand.nextInt();
            }

            arrays.add(cur);
            Arrays.sort(cur);
            sorted.add(cur);
        }

        //empty array
        int[] array1 = {};
        Arrays.sort(array1);
        sorted.add(array1);
        //array with same elements
        int[] array2 = {1, 1, 1, 1, 1, 1, 1};
        Arrays.sort(array2);
        sorted.add(array2);
        //array with all negative numbers
        int[] array3 = {-5, -6, -7, -100, -900};
        Arrays.sort(array3);
        sorted.add(array3);
    }





    //check size.
    @Test
    public void testSize(){
        boolean check = true;

        int s = 0;
        int aLen = 0;
        int sLen = 0;
        for (int m = 0; m < arrays.size(); m++){
            aLen = arrays.get(m).length;
            sLen = sorted.get(m).length;

            if (aLen != sLen){
                check = false;
                break;
            }
        }
        assertTrue(check);

    }

    //check original and sorted arrays contain same elements.
    @Test
    public void testSameElements(){

        boolean check = true;
        int[] c;
        int cVal;
        int[] s;
        int sVal;

        for (int i = 0; i < sorted.size(); i++){

            c = arrays.get(i);
            s = sorted.get(i);

            for(int j=0; j<c.length; j++)
            {
                cVal = c[j];

                boolean same = false;
                for(int n=0; n<s.length; n++)
                {
                    sVal = s[n];

                    if(cVal == sVal)
                    {
                        same = true;
                        break;
                    }
                }
                if(same = false){
                    check = false;
                    break;
                }

            }

        }
        assertTrue(check);
    }
    //check if one array is sorted twice, they result the same.
    @Test
    public void testSameResult() {
        boolean check = true;

        for (int i = 0; i < arrays.size(); i++) {

            int[] temp = arrays.get(i);
            int[] std = sorted.get(i);

            Arrays.sort(temp);

            if(!(temp.equals(std))){
                check = false;
                break;
            }
        }
        assertTrue(check);

    }
   
}
