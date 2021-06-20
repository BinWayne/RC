import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rc.interview.Utils;

import java.util.*;

public class UtilsGetUnUsedKeysTest {

    int[] allKeys, usedKeys, expected, emptyKeys, duplicatedKeys, expectedDup;

    @Before
    public void setUp() {
        allKeys = new int[]{4, 10, 9, 5, 6, 7};
        usedKeys = new int[]{3, 4};
        expected = new int[]{5, 6, 7, 9, 10};


        emptyKeys = new int[]{};
        duplicatedKeys = new int[]{10, 34, 3, 3, 5, 5, 6, 7};
        expectedDup = new int[]{5, 5, 6, 7, 10, 34};

    }

    @Test
    public void getUnUsedKeysTest() {
        /**
         * allKeys contains usedKeys
         * */


        int[] results = Utils.getUnUsedKeys(allKeys, usedKeys);


        Assert.assertArrayEquals(expected, results);
    }

    @Test
    public void allKeysIsEmpty() {
        /**
         * allKeys contains usedKeys
         * */

        int[] results = Utils.getUnUsedKeys(emptyKeys, usedKeys);
        Assert.assertEquals(0, results.length);

    }

    @Test
    public void usedKeysIsEmpty() {
        /**
         * allKeys contains usedKeys
         * */

        int[] results = Utils.getUnUsedKeys(allKeys, emptyKeys);
        Assert.assertEquals(allKeys.length, results.length);

    }

    @Test
    public void allKeysDuplicated() {
        /**
         * allKeys contains usedKeys
         * */


        int[] results = Utils.getUnUsedKeys(duplicatedKeys, usedKeys);
        Assert.assertArrayEquals(expectedDup, results);

    }


}
