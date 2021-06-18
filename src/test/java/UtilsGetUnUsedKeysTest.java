import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rc.interview.Utils;
import java.util.*;

public class UtilsGetUnUsedKeysTest {

    int[] allKeys, usedKeys, emptyKeys, duplicatedKeys;

    @Before
    public void setUp() {
        allKeys = new int[]{2, 3, 4, 5, 6, 7};
        usedKeys = new int[]{3, 4};
        emptyKeys = new int[]{};
        duplicatedKeys = new int[]{2, 3, 3, 5, 5, 6, 7};

    }

    @Test
    public void getUnUsedKeysTest() {
        /**
         * allKeys contains usedKeys
         * */


        int[] results = Utils.getUnUsedKeys(allKeys, usedKeys);
        Assert.assertEquals(4, results.length);
        Assert.assertFalse(Arrays.asList(results).contains(3));
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

        Assert.assertEquals(5, results.length);
        Assert.assertFalse(Arrays.asList(results).contains(3));

    }


}
