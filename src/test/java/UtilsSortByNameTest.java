import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rc.interview.Extension;
import rc.interview.Utils;


import java.util.ArrayList;
import java.util.List;

public class UtilsSortByNameTest {

    List<Extension> emptyList, fullList;

    @Before
    public void setUp() {
        emptyList = new ArrayList<>();
        fullList = new ArrayList<>();
        Extension ext1 = new Extension("B", "Wu", "ext1", "extType1");
        Extension ext2 = new Extension("B", "Au", "auExt", "extType2");
        Extension ext3 = new Extension("A", "Wu", "ext2", "extType3");
        Extension ext4 = new Extension("A", "", "ext2", "extType4");
        Extension ext5 = new Extension("A", "", "", "extType5");
        Extension ext6 = Extension.builder().firstName("B").ext("ext6").extType("extType6").build();//lastName is null

        fullList.add(ext1);
        fullList.add(ext2);
        fullList.add(ext3);
        fullList.add(ext4);
        fullList.add(ext5);
        fullList.add(ext6);
        //sortByName expect --> ext5,ext4,ext3,ext6,ext2,ext1
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
    public void sortByName() {

        List<Extension> results = Utils.sortByName(fullList);
        Assert.assertEquals("extType2", results.get(4).getExtType());
        Assert.assertEquals("extType3", results.get(2).getExtType());

    }

    @After
    public void tearDown() {
        emptyList = null;
        fullList = null;
    }


}
