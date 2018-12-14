package newtest.Sort;

import java.time.chrono.AbstractChronology;

public class mergeX {
    private mergeX() { }
    private static final int CUTOFF = 7;

    // is v < w ?
    public static boolean less(Comparable v, Comparable w){
        return(v.compareTo(w))< 0;
    }

    // exchange a[i] and a[j]
    public static void exchange(Object[] a, int i, int j){
        Object swap= a[i];
        a[i]= a[j];
        a[j]= swap;
    }

    //juage the array is sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i= lo+ 1; i<= hi; i++) {
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public  static void insertionSort(Comparable[] dst, int lo, int hi){
        for (int i= lo; i<= hi; i++){
            for(int j= i; j> lo&& less(dst[j], dst[j- 1]); j--){
                exchange(dst, j, j-1);
            }
        }
    }

    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        int i= lo, j= mid+ 1;
        for (int k = lo; k <= hi; k++) {
            if(i> mid){
                dst[k]= src[j++];
            }
            else if(j> hi){
                dst[k]= src[i++];
            }
            else if(less(src[i], src[j])){
                dst[k]= src[i++];
            }else{
                dst[k]= src[j++];
            }
        }
    }

    public  static void sort(Comparable[] src, Comparable[] dst, int lo, int hi){
        if(lo+ CUTOFF>= hi){
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo+ (hi- lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+ 1, hi);
        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length-1);
    }



    public static void main(String args[]){
        Integer[] a= {5,8,9,36,5,2,5,3,5,4,0};
        mergeX.sort(a);
        show(a);
    }
}
