package edu.neu.info6205.sorts;

import edu.neu.info6205.utils.SortUtils;

public class DualPivotQuickSort {



    public static void sort (String[] arr, int low, int high){
        if(low < high){
            int[] pivot = partition(arr, low, high);
            sort(arr, low, pivot[0] -1);
            sort(arr, pivot[0]+1, pivot[1]-1);
            sort(arr, pivot[1]+1, high);

        }
    }

    public static void doSort(String[] arr){
        sort(arr, 0, arr.length-1);
    }

    public static int[] partition(String[] arr, int low, int high){

        if(SortUtils.greaterThan(arr[low], arr[high])){
            SortUtils.swap(arr, low, high);
        }

        int j = low+1;
        int g = high - 1;
        int k = low + 1;
        String p = arr[low];
        String q = arr[high];

        while (k <= g){
            if(SortUtils.lessThan(arr[k], p)){
                SortUtils.swap(arr, k, j);
                j++;
            }

            else if (SortUtils.greaterThanOrEqualTo(arr[k], q)){
                while(SortUtils.greaterThan(arr[g], q) && (k < g)){
                    g--;
                }
                SortUtils.swap(arr, k,g);
                g--;
                if(SortUtils.lessThan(arr[k], p)){
                    SortUtils.swap(arr, k, j);
                    j++;
                }
            }
            k++;

        }
        j--;
        g++;

        SortUtils.swap(arr, low, j);
        SortUtils.swap(arr, high, g);
        return new int[] {j,g};
    }


}
