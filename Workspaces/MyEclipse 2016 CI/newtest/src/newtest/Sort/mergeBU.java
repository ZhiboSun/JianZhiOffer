package newtest.Sort;

public class mergeBU {
    private mergeBU() { }

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

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i= lo, j= mid+ 1;
        for (int k = lo; k <= hi; k++) {
            if(i> mid){
                a[k]= aux[j++];
            }
            else if(j< mid){
                a[k]= aux[i++];
            }
            else if(less(aux[i], aux[j])){
                a[k]= aux[i++];
            }else{
                a[k]= aux[j++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for(int len= 1; len< n; len*=2){
            for(int lo= 0; lo< n-len; lo+= len+ len){
                int mid= lo+ len- 1;
                int hi = Math.min(lo+ len+ len-1, n-1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }



    public static void main(String args[]){
        Integer[] a= {5,8,9,36,5,2,5,3,5,4,0};
        mergeX.sort(a);
        show(a);
    }
}
