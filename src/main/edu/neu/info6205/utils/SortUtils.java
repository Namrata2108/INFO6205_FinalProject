package edu.neu.info6205.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

public class SortUtils {

    private static Collator coll = Collator.getInstance(Locale.CHINA);

    public static String[] convertToPinyin(String[] a) throws BadHanyuPinyinOutputFormatCombination {
        String[] temp = new String[a.length];
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        long length = a.length;
        for(int i =0; i< length; i++){
            String s = a[i];
            String tempString ="";
            for(int j=0; j<s.length();j++){
                String[] pinArr = PinyinHelper.toHanyuPinyinStringArray(s.charAt(j), format);
                tempString = tempString.concat(pinArr[0]);
            }
            temp[i] = tempString;
        }
        return temp;
    }

    public static String[] chineseExample ={
                "刘持平",
                "洪文胜",
                "樊辉辉",
                "苏会敏",
                "高民政",
                "曹玉德",
                "袁继鹏",
                "阿鼎",
                "阿"
    };
    public static void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean lessThan(String s1, String s2){
        CollationKey ck1 = coll.getCollationKey(s1);
        CollationKey ck2 = coll.getCollationKey(s2);
        return (ck1.compareTo(ck2)<0);
    }
    public static boolean greaterThan(String s1, String s2){
        CollationKey ck1 = coll.getCollationKey(s1);
        CollationKey ck2 = coll.getCollationKey(s2);
        return (ck1.compareTo(ck2)>0);
    }
    public static boolean greaterThanOrEqualTo(String s1, String s2){
        CollationKey ck1 = coll.getCollationKey(s1);
        CollationKey ck2 = coll.getCollationKey(s2);
        return (ck1.compareTo(ck2)>=0);
    }
    public static boolean lessThanOrEqualTo(String s1, String s2){
        CollationKey ck1 = coll.getCollationKey(s1);
        CollationKey ck2 = coll.getCollationKey(s2);
        return (ck1.compareTo(ck2)<=0);
    }
}
