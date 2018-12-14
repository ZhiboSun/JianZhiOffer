package newtest.offer;

/*数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class offer39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(checkInvalidArray(array)){
            return 0;
        }
        int result= array[0];
        int times= 1;
        for(int i=0; i<array.length; i++){
            if(times== 0){
                result= array[i];
                times= 1;
            }
            else if(array[i]== result)
                times++;
            else
                times--;
        }
        if(!CheackMoreThanhalf(array, result))
            return 0;
        return result;
    }
    /*检测输入数组是否合法*/
    public boolean checkInvalidArray(int[] array){
        boolean InputInvalid= false;
        if(array== null|| array.length== 0){
            InputInvalid= true;
        }
        return InputInvalid;
    }
    /*检测找到的数字出现次数是否大于一半*/
    public boolean CheackMoreThanhalf(int[] array, int result){
        boolean isMoreThanhalf= true;
        int times= 0;
        int len= array.length;
        for(int i= 0; i< len; i++){
            if(array[i]== result){
                times++;
            }
        }
        if(times* 2<= len){
            isMoreThanhalf= false;
        }
        return isMoreThanhalf;
    }
}
