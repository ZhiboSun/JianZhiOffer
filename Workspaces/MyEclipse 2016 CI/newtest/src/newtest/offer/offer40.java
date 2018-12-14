package newtest.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
/*
最小的K个数(用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。)
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class offer40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res= new ArrayList<>();
        if(input== null|| input.length< k|| k== 0){
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i= 0; i< input.length; i++){
            if(maxHeap.size()< k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek()> input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            res.add(integer);
        }
        return res;
    }
}
