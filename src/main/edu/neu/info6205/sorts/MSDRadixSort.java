package edu.neu.info6205.sorts;



public class MSDRadixSort {
    private static String[] aux;
    private static String[] aux1;
    private static int R = 65536;

    public static void sort(String[] a, String[] chinese)  {
        aux = new String[a.length];
        aux1 = new String[a.length];
        sort(a, chinese, aux, aux1, 0, a.length-1, 0);
    }

    private static int charAt(String s, int d)  {
       if(d < s.length()) {
           return s.charAt(d);
       }
       else
           return -1;
    }


    private static void sort(String[] a, String[] chinese, String[] aux, String[] aux1, int lo, int hi, int d) {
        if(hi<=lo) return;
        int[] count = new int[R+2];
        for(int i = lo; i <= hi; i++){
            int c = charAt(a[i], d);
            count[c+2]++;
        }
        for(int r =0; r< R+1; r++){
            count[r+1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            int c =charAt(a[i], d);
            aux1[count[c+1]] = chinese[i];
            aux[count[c+1]++] = a[i];
        }
        for(int i = lo; i<= hi ; i++){
            chinese[i] = aux1[i-lo];
            a[i] = aux[i-lo];

        }
        for(int r = 0; r <R; r++){
            sort(a, chinese, aux, aux1, lo+count[r], lo + count[r+1] -1, d +1);
        }
    }
}
