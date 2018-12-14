package newtest.Sort;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.util.*;

public class quickSort {
    private quickSort() { }
    public static void exchange(Comparable[] a,  int i, int j){
        Comparable temp= a[i];
        a[i]= a[j];
        a[j]= temp;
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    public static int partition(Comparable[] a, int lo, int hi){
        Comparable key= a[lo];
        int i= lo, j= hi+ 1;
        while(true){
            while(less(a[++i], key)){
                if(i== hi)
                    break;
            }
            while(less(key, a[--j])){
                if(j== lo)
                    break;
            }
            if(i>= j)
                break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(lo>= hi){
            return;
        }
        int j= partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static void sort(Comparable[] a){
        shuffle(a);
        sort(a, 0, a.length- 1);
    }

    public static void show(Comparable[] a){
        for(int i= 0; i< a.length; i++){
            System.out.println(a[i]);
        }
    }
    public static void shuffle(Comparable[] a){
        List<Comparable> temp = Arrays.asList(a);
        Collections.shuffle(temp);
        a= (Comparable[]) temp.toArray();
    }
    public static void main(String args[]){
        Integer[] a= {5,8,9,50,56,78,89,654,25,44,12,2,25,25,36,5,2,5,3,5,4,0};
        quickSort.sort(a);
        show(a);
    }
}
