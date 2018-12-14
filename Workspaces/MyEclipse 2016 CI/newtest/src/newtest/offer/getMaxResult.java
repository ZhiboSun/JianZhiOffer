package newtest.offer;
/*剪绳子
    剑指offer14
 */
public class getMaxResult {
    public static void main(String[] args){
        int length= 50;
        System.out.println(get_MaxResult1(length));
        System.out.println(get_MaxResult2(length));
    }
    /*
    动态规划
    */
    private static long get_MaxResult1(int length) {
        if(length< 2)
            return 0;
        if(length== 2)
            return 1;
        if(length== 3)
            return 2;
        long[] products= new long[length+ 1];
        products[0]= 0;
        products[1]= 1;
        products[2]= 2;

        long max= 0;
        for(int i=4; i<= length; i++){
            max= 0;
            for(int j= 1;j<= i/ 2; j++){
                long product= products[j]* products[i- j];
                if(max< product){
                    max= product;
                }
                products[i]= max;
            }
        }
        max= products[length];
        return max;
    }


    /*
    贪心算法
     */
    private static long get_MaxResult2(int length) {
        if(length< 2)
            return 0;
        if(length== 2)
            return 1;
        if(length== 3)
            return 2;
        int timesOf3= length/3;
        if(length- 3*timesOf3== 1){
            timesOf3-= 1;
        }
        int timesOf2=(length-timesOf3*3)/2;
        return (long) (Math.pow(3, timesOf3))*(long)(Math.pow(2, timesOf2));
    }
}
