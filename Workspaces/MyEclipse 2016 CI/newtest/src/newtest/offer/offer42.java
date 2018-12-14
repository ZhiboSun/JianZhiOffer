package newtest.offer;
/*
[编程题]连续子数组的最大和
 */
public class offer42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length== 0){
            return 0;
        }
        int res= Integer.MIN_VALUE;
        int curSum= 0;
        for(int i=0; i< array.length; i++){
            if(curSum<= 0){
                curSum= array[i];
            }else{
                curSum+= array[i];
            }
            res= curSum> res? curSum:res;
        }
        return res;
    }
}
