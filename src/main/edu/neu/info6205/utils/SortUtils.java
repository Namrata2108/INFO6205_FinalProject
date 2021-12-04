package edu.neu.info6205.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.CollationKey;
import java.text.Collator;
import java.util.*;
import java.util.function.Function;

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
            "阿安",
            "刘持平",
            "洪文胜",
            "樊辉辉",
            "苏会敏",
            "高民政",
            "曹玉德",
            "袁继鹏",
            "阿鼎",
            "阿",
            "阿彬",
            "阿斌",
            "阿滨",
            "阿兵",
            "阿冰",
            "阿冰冰",
            "刘持平",
            "洪文胜",
            "樊辉辉",
            "苏会敏",
            "高民政",
            "曹玉德",
            "袁继鹏",
            "阿鼎",
            "白龙玉",
            "白龙珠",
            "白隆",
            "白鲁",
            "白麓",
            "白露",
            "白露露",
            "白露明",
            "白露萍",
            "白路",
            "白路路",
            "白路遥",
            "白鹿",
            "白鹿鸣",
            "白鹿园",
            "白潞",
            "白陆",
            "白绿",
    };
    public static void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean lessThan(String s1, String s2){

        return (coll.compare(s1,s2)<0);
    }
    public static boolean greaterThan(String s1, String s2){

        return (coll.compare(s1,s2)>0);
    }
    public static boolean greaterThanOrEqualTo(String s1, String s2){

        return (coll.compare(s1,s2)>=0);
    }
    public static boolean lessThanOrEqualTo(String s1, String s2){

        return (coll.compare(s1,s2)<=0);
    }

    public static <T> T[] asArray(Collection<T> ts) {
        if (ts.isEmpty()) throw new RuntimeException("ts may not be empty");
        @SuppressWarnings("unchecked") T[] result = (T[]) Array.newInstance(ts.iterator().next().getClass(), 0);
        return ts.toArray(result);
    }

    /**
     * Create a string representing an double, with three decimal places.
     *
     * @param x the number to show.
     * @return a String representing the number rounded to three decimal places.
     */
    public static String formatDecimal3Places(double x) {
        double scaleFactor = 1000.0;
        return String.format("%.3f", round(x * scaleFactor) / scaleFactor);
    }

    /**
     * Create a string representing an integer, with commas to separate thousands.
     *
     * @param x the integer.
     * @return a String representing the number with commas.
     */
    public static String formatWhole(int x) {
        return String.format("%,d", x);
    }

    public static String asInt(double x) {
        final int i = round(x);
        return formatWhole(i);
    }

    public static int round(double x) {
        return (int) (Math.round(x));
    }

    public static <T> T[] fillRandomArray(Class<T> clazz, Random random, int n, Function<Random, T> f) {
        @SuppressWarnings("unchecked") T[] result = (T[]) Array.newInstance(clazz, n);
        for (int i = 0; i < n; i++) result[i] = f.apply(random);
        return result;
    }

    /**
     * Method to calculate log to tbe base 2 of n.
     *
     * @param n the number whose log we need.
     * @return lg n.
     */
    public static double lg(double n) {
        return Math.log(n) / Math.log(2);
    }

    public static String[] readFromFile(String filename){
        String[] arr;
        try{
            Scanner sc = new Scanner(new File(filename));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            arr = lines.toArray(new String[0]);
            return  arr;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
       return null;
    }

    public static String[] chineseExampleSorted = {
            "阿",
            "阿鼎",
            "曹玉德",
            "樊辉辉",
            "高民政",
            "洪文胜",
            "刘持平",
            "苏会敏",
            "袁继鹏",
    };
}



/**
 * Usage for benchmark
 *
 * String[] chinese =SortUtils.readFromFile("src/resources/shuffledChinese.txt");
 *         Supplier<String[]> supplier = () -> Arrays.copyOf(chinese, chinese.length);
 *
 *
 *         int n = chinese.length;
 *
 *         BenchmarkTarget.benchmarkTarget(supplier,MSDRadixSort::doSort,1, n, "Dual Pivot Quick Sort");
 */
