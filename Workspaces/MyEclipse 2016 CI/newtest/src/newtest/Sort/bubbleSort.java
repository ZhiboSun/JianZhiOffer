package newtest.Sort;

public class bubbleSort {
    private  bubbleSort(){};
    public static boolean less(Comparable a,  Comparable b){
        return a.compareTo(b)< 0;
    }
    public static void exchange(Object[] a, int i, int j){
        Object temp= a[i];
        a[i]= a[j];
        a[j]= temp;
    }
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(Integer[] a) {
        for (int i= 1; i < a.length; i++){
            for (int j= 1; j< a.length-i+1; j++){
                if(less(a[j], a[j- 1])){
                    exchange(a, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args){
        Integer[] a= {5,8,9,36,5,2,5,3,5,4,0};
        bubbleSort.sort(a);
        show(a);
    }


}
