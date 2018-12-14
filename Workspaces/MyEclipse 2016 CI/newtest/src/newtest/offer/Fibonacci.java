package newtest.offer;

public class Fibonacci {
    public static void main(String[] args){
        long start=System.currentTimeMillis(); //获取开始时间
        Long ans = fibonacci(10);
        System.out.println(ans);
        long end=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(end-start)+"ms");
    }

    private static Long fibonacci(int n) {
        Long[] result={new Long(0), new Long(1)};
        if(n< 2){
            return result[n];
        }
        Long fibNMinusOne= new Long(0);
        Long fibNMinusTwo= new Long(1);
        Long fibN= new Long(0);
        for(int i= 2; i<= n; i++){
            fibN= fibNMinusOne+ fibNMinusTwo;
            fibNMinusTwo= fibNMinusOne;
            fibNMinusOne= fibN;
        }
        return fibN;
    }


//    //递归
//    private static Long fibonacci(int n) {
//        if(n<= 0){
//            return new Long(0);
//        }
//        if(n== 1){
//            return new Long(1);
//        }
//        return fibonacci(n-1)+fibonacci(n-2);
//    }
}
