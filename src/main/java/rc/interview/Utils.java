package rc.interview;

import rc.interview.comparator.ExtypeComparator;
import java.util.*;
import static java.util.stream.Collectors.toList;

public class Utils {


    /**
     * Question1, sort by firstName , lastName and  ext,
     * if firstName is the same then sort by lastName and
     * ext, please note lastName and ext can be empty string or null
     **/
    public static List<Extension> sortByName(List<Extension> extensions) {
        if (extensions == null || extensions.size() == 0)
            return null;

        Collections.sort(extensions, Comparator.comparing(Extension::getFirstName)
                .thenComparing(Extension::getLastName, Comparator.nullsFirst(String::compareTo))
                .thenComparing(Extension::getExt, Comparator.nullsFirst(String::compareTo)));

        return extensions;
    }


    /**
     * Question2, sort extType, extType is a string and can
     * be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     * There might be new extType value, it will be in last order is it's not in prefined list.
     **/
    public static List<Extension> sortByExtType(List<Extension> extensions) {

        if (extensions == null || extensions.size() == 0)
            return null;
        Collections.sort(extensions, new ExtypeComparator());
        return extensions;

    }


    /**
     * Question3, sum all sales items by quarter, sum the amount for the same quarter item.
     **/
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
        if (saleItems == null || saleItems.size() == 0)
            return null;

        List<QuarterSalesItem> quarterSalesItems = new ArrayList<>();
        //group by quarter --> hashMap result
        Map<String, List<SaleItem>> resultMap = separateByQuarter(saleItems);
        if (resultMap.size() == 0)
            return null;

        resultMap.forEach((key, value) -> {
            double amount = value.stream().map(SaleItem::getAmount).reduce(0.0, Double::sum);
            QuarterSalesItem quarterSalesItem = new QuarterSalesItem(Integer.parseInt(key), amount);
            quarterSalesItems.add(quarterSalesItem);
        });

        return quarterSalesItems;
    }


    /**
     * Question4, max all sales items by quarter, get the max amount from the item belongs to the same quarter
     **/
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        if (saleItems == null || saleItems.size() == 0)
            return null;

        List<QuarterSalesItem> quarterSalesItems = new ArrayList<>();
        //group by quarter --> hashMap result
        Map<String, List<SaleItem>> resultMap = separateByQuarter(saleItems);
        resultMap.forEach((key, value) -> {
            Optional<SaleItem> saleItemOptional = value.stream().max(Comparator.comparingDouble(SaleItem::getAmount));
            QuarterSalesItem quarterSalesItem = new QuarterSalesItem(Integer.parseInt(key), saleItemOptional.get().getAmount());
            quarterSalesItems.add(quarterSalesItem);
        });

        return quarterSalesItems;

    }

    //Question5

    /**
     * We have all Keys like 0-10000 with random order, it can be other keys in real cases;
     * usedKeys is an array to store all used keys like :[2,3,4] with random order;
     * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,....]
     */

    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {

        List<Integer> allKeysList = Arrays.stream(allKeys).boxed().collect(toList());
        List<Integer> usedKeysList = Arrays.stream(usedKeys).boxed().collect(toList());

        List<Integer> results = allKeysList.stream().filter(item -> !usedKeysList.contains(item)).collect(toList());
        return results.stream().mapToInt(Integer::valueOf).toArray();

    }


    /**
     * given List<SaleItem> saleItems like --> [{1,1,22.2},{5,2,44.4},{11,4,10.0}]
     * resultMap like -->
     * {1,[1,1,22.2]}  {2,[5,2,44.4]}  {4,[11,4,10.0]}
     */
    private static Map<String, List<SaleItem>> separateByQuarter(List<SaleItem> saleItems) {
        Map<String, List<SaleItem>> resultMap = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            int y = i;
            // 4 quarters in 1 year, fetch the each quarter in a loop by (SaleItem.getMonth()+2)/3
            List<SaleItem> temp = saleItems.stream().filter(x -> (x.getMonth() + 2) / 3 == y).collect(toList());
            resultMap.put(String.valueOf(y), temp);
        }
        return resultMap;
    }

}
