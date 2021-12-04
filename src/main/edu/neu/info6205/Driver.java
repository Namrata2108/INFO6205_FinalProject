package edu.neu.info6205;

import edu.neu.info6205.sorts.LSDRadixSort;
import edu.neu.info6205.sorts.MSDRadixSort;
import edu.neu.info6205.utils.SortUtils;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Driver {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        /**
         * TODO: Polish this up after other sorts are implemented
         */
        String[] chinese = SortUtils.chineseExample;
        String[] chineseConv = SortUtils.convertToPinyin(chinese);
        MSDRadixSort.sort(chineseConv, chinese);
        int n = chinese.length;
        for (int i = 0; i < n; i++) {
            System.out.println(chinese[i]);
        }
    }
}
