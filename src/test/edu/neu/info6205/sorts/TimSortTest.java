package edu.neu.info6205.sorts;


import edu.neu.info6205.utils.SortUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * Tests the basic sort functionality as well as the file reader and sort
 */
public class TimSortTest {
    @Test
    public void testSort() {
        String[] chinese = Arrays.copyOf(SortUtils.chineseExample, SortUtils.chineseExample.length);
        TimSort.doSort(chinese);
        for (int i = 0; i < chinese.length; i++) {
            assertEquals(chinese[i], SortUtils.chineseExampleSorted[i]);
        }
    }

    @Test
    public void readFileSortTest() {
        String[] chinese = SortUtils.readFromFile("src/resources/chineseExample.txt");
        assertEquals(chinese.length,SortUtils.chineseExample.length);
        TimSort.doSort(chinese);
        for (int i = 0; i < chinese.length; i++) {
            assertEquals(chinese[i], SortUtils.chineseExampleSorted[i]);
        }
    }
}

