package edu.neu.info6205.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class SortUtils {
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
}
