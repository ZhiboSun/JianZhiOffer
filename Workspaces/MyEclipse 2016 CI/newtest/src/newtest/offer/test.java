package newtest.offer;

import com.sun.org.apache.xalan.internal.xsltc.compiler.LocationPathPattern;
import com.sun.org.apache.xpath.internal.operations.Equals;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;

public class test {
    public static void main(String[] args){
        /*有符号数右移测试
        int a = 0xffffffff;
        for (int i= 0; i< 100; i++){
            a= a>>>1;
            System.out.println(a);
        }
        */

        /*
        //15位还可以，16位就不行了
        double a=3.2222222222222221  ,b=3.2222222222222222;

        for(int i=0;i<10;i++){

            System.out.print(a<b);
            System.out.print(" ");
            System.out.print(a>b);
            System.out.print(" ");
            System.out.println(a==b);

        }

        //正确方法，加个精度
        double EPSILON=1e-6;
        double a = 0.3;
        double b = 0.4;
        double c = a + b;
        if (c == 0.7)
            System.out.println("a + b == 0.7\n");
        else
            System.out.println("a + b != 0.7\n");
        double fa = 0.3;
        double fb = 0.4;
        double fc = fa + fb;
        if (Math.abs(fc - 0.7) < EPSILON)
            System.out.println("fa + fb == 0.7\n");
        else
            System.out.println("fa + fb != 0.7\n");
        */

        /*
        ArrayList<Integer> path= new ArrayList<>();
        path.add(1);
        path.add(2);
        path.remove(path.size()-1);
        path.add(2);
        path.add(2);
        path.add(3);
        path.remove(path.size()-1);
        for (Integer temp:path
             ) {
            System.out.println(temp.intValue());
        }
        */
        int k= 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });


    }



}
