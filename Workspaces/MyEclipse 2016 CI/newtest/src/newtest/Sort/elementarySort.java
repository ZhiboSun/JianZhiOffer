package newtest.Sort;

public class elementarySort {
    // This class should not be instantiated.
    private elementarySort() { }

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

    /**
     *
     * @选择排序
     */
    public static void selectSort(Comparable[] a) {
        for (int i= 0; i< a.length; i++){
            int min = i;
            for(int j= i+1; j< a.length; j++){
                if(less(a[j], a[min])){
                    min= j;
                }
                exchange(a, i, min);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     *
     * @插入排序
     */
    public static void insertSort(Comparable[] a) {
        int n= a.length;
        for (int i=1; i< n; i++){
            for(int j= i; j>= 1&& less(a[j], a[j- 1]); j--){
                exchange(a, j- 1, j);
            }
        }
    }

    /**
     *
     * @希尔排序（插入排序的变种）
     */
    public static void shellSort(Comparable[] a) {
        int n= a.length;
        int h= n/2;
        while(h>=1){
            for (int i= h; i< n; i++){
                for(int j= i; j>= h&& less(a[j], a[j-h]); j-= h){
                    exchange(a, j- h, j);
                }
            }
            h= h/ 2;
        }
    }

    public static void main(String args[]){
        Integer[] a= {5,8,9,36,5,2,5,3,5,4,0};
        elementarySort.shellSort(a);
        show(a);
    }
}

