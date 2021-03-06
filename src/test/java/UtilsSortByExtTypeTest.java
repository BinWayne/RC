import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rc.interview.Extension;
import rc.interview.Utils;

import java.util.ArrayList;
import java.util.List;

public class UtilsSortByExtTypeTest {

    List<Extension> emptyList, fullList, expectedList;

    @Before
    public void setUp() {


        emptyList = new ArrayList<>();
        fullList = new ArrayList<>();
        expectedList = new ArrayList<>();
        Extension ext1 = new Extension("B", "Wu", "ext1", "Dept");
        Extension ext2 = new Extension("B", "Au", "auExt", "extType2");
        Extension ext3 = new Extension("A", "Wu", "ext2", "User");
        Extension ext4 = new Extension("A", "", "ext2", "TMO");
        Extension ext5 = new Extension("A", "", "", "Other");
        Extension ext6 = Extension.builder().firstName("B").ext("ext6").extType("AO").build();//lastName is null

        fullList.add(ext1);
        fullList.add(ext2);
        fullList.add(ext3);
        fullList.add(ext4);
        fullList.add(ext5);
        fullList.add(ext6);

        expectedList.add(ext3);
        expectedList.add(ext1);
        expectedList.add(ext6);
        expectedList.add(ext4);
        expectedList.add(ext5);
        expectedList.add(ext2);

        //expect ext3> ext1>ext6>ext4>ext5>ext2
    }

    @Test
    public void sortByNameIfListIsNull() {
        /**
         * if extensions list is null ,should return null
         * */

        List<Extension> results = Utils.sortByName(emptyList);
        Assert.assertNull(results);
    }

    @Test
    public void sortByExtType() {

        List<Extension> results = Utils.sortByExtType(fullList);
        Assert.assertArrayEquals(expectedList.toArray(), results.toArray());

    }

    @After
    public void tearDown() {
        emptyList = null;
        fullList = null;
    }


}
