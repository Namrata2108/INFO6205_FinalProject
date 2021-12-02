package edu.neu.info6205;

import edu.neu.info6205.sorts.LSDRadixSort;
import edu.neu.info6205.utils.SortUtils;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Driver
{
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        String[] chinese =SortUtils.chineseExample;
        String[] chineseConv = SortUtils.convertToPinyin(chinese);
        LSDRadixSort.sort(chineseConv, chinese);
        int n = chinese.length;
    }
}
