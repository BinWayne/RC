import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rc.interview.QuarterSalesItem;
import rc.interview.SaleItem;
import rc.interview.Utils;

import java.util.ArrayList;
import java.util.List;

public class UtilsSumByQuarterTest {

    List<SaleItem> emptyList,fullList;

    @Before
    public void setUp(){
        emptyList = new ArrayList<>();
        fullList = new ArrayList<>();
        SaleItem saleItem1 = new SaleItem(1, "2", 22.2);
        SaleItem saleItem2 = new SaleItem(2, "1", 22.2);
        SaleItem saleItem4 = new SaleItem(4, "1", 22.2);
        SaleItem saleItem8 = new SaleItem(8, "1", 22.2);
        SaleItem saleItem11 = new SaleItem(11, "1", 22.2);
        fullList.add(saleItem1);
        fullList.add(saleItem2);
        fullList.add(saleItem4);
        fullList.add(saleItem8);
        fullList.add(saleItem11);

    }
    @Test
    public void sumByQuarterIfListIsNull() {
        List<QuarterSalesItem> results = Utils.sumByQuarter(emptyList);
        Assert.assertNull(results);
    }

    @Test
    public void sumByQuarterIfListNotNull() {

        List<QuarterSalesItem> results = Utils.sumByQuarter(fullList);
        Assert.assertEquals(44.4, results.get(0).getAmount(), 0);
        Assert.assertEquals(22.2, results.get(1).getAmount(), 0);
        Assert.assertEquals(22.2, results.get(2).getAmount(), 0);
    }

    @After
    public void tearDown(){
        emptyList = null;
        fullList = null;
    }

}
