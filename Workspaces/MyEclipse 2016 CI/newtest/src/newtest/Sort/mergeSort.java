package newtest.Sort;

import javax.sound.sampled.AudioSystem;

public class mergeSort {
    // This class should not be instantiated.
    private mergeSort() { }

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

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        /* 每次都要重新拷贝数组a */
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i= lo, j= mid+ 1;
        for(int k= lo; k<= hi; k++){
            if(i> mid){
                a[k] = aux[j];
                j++;
            }
            else if(j> hi){
                a[k] = aux[i];
                i++;
            }
            else if(less(aux[i], aux[j])){
                a[k] = aux[i];
                i++;
            }else{
                a[k] = aux[j];
                j++;
            }
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(hi<= lo){
            return;
        }
        int mid= lo+ (hi- lo)/ 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+ 1, hi);
        merge(a, aux, lo, mid, hi);
    }


    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }



    public static void main(String args[]){
        Integer[] a= {5,8,9,36,5,2,5,3,5,4,0};
        mergeSort.sort(a);
        show(a);
    }
}
