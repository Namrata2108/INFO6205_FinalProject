package edu.neu.info6205.sorts;

import edu.neu.info6205.utils.SortUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DualPivotQuickSortTest {
    @Test
    public void testSort(){
        String[] chinese = Arrays.copyOf(SortUtils.chineseExample,SortUtils.chineseExample.length);
        DualPivotQuickSort.doSort(chinese);
        for (int i = 0; i < chinese.length; i++) {
            assertEquals(chinese[i], SortUtils.chineseExampleSorted[i]);
        }
    }

    @Test
    public void testPartition(){
        String[] chinese = Arrays.copyOf(SortUtils.chineseExample,SortUtils.chineseExample.length);
        int[] pivot;
        pivot = DualPivotQuickSort.partition(chinese, 0, chinese.length-1);
        assertEquals(0,pivot[0]);
        assertEquals(6, pivot[1]);
        pivot = DualPivotQuickSort.partition(chinese, 1, 5);
        assertEquals(2,pivot[0]);
        assertEquals(5, pivot[1]);
        pivot = DualPivotQuickSort.partition(chinese, 3, 4);
        assertEquals(3,pivot[0]);
        assertEquals(4, pivot[1]);
        pivot = DualPivotQuickSort.partition(chinese, 7, 8);
        assertEquals(7,pivot[0]);
        assertEquals(8, pivot[1]);
    }

    @Test
    public void readFileSortTest() {
        String[] chinese = SortUtils.readFromFile("src/resources/chineseExample.txt");
        assertEquals(chinese.length,SortUtils.chineseExample.length);
        DualPivotQuickSort.doSort(chinese);
        for (int i = 0; i < chinese.length; i++) {
            assertEquals(chinese[i], SortUtils.chineseExampleSorted[i]);
        }
    }
}
