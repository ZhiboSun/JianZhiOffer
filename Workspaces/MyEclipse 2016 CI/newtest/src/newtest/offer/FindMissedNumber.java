package newtest.offer;

/*
   2018/12/13 百度面试 在有序数组中找到缺失的一个数字
 */
public class FindMissedNumber {
    public static void main(String[] args){
        int[] nums= new int[]{ 0, 2, 3, 4, 5, 6, 7};
        int lostNum= findMissedNumber(nums, 0, nums.length- 1);
        System.out.println(lostNum);
    }
    private static int findMissedNumber(int[] nums, int left, int right) {
        int i= 1;
        while(left< right){
            System.out.print("No."+i+"次循环 ："+"left:"+left+" "+"right:"+right);
            int mid= left+ (right-left)/ 2;
            //缺失数字在后半部分
            if(mid== nums[mid]){
                System.out.print("缺失数字在后半部分");
                left= mid+ 1;
            }
            //缺失数字在前半部分
            if(mid< nums[mid]){
                System.out.print("缺失数字在前半部分");
                right= mid;
            }
            System.out.println(" mid:"+mid+" "+"nums[mid]:"+nums[mid]);
            i++;
        }
        return nums[left]-1 ;
    }
}
