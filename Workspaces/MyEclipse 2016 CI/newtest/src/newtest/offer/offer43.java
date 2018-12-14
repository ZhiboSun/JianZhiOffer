package newtest.offer;

/*
    数字1的个数
    给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 */
public class offer43 {
    public static void main(String[] args){
        System.out.println(countDigitOne(13));
    }
    public static int countDigitOne(int n) {
        int res= 0;
        long left, right, base= 1;
        if(n<= 0){
            return 0;
        }
        while(n>= base){
            left= n/ base;/* left包含当前位 */
            right= n% base;/* right为当前位的右半边 */

            /* 判断当前位置是不是等于1*/
                /*
                举个例子54215，比如现在求百位上的1，54215的百位上是2。
                可以看到xx100到xx199的百位上都是1，这里xx从0到54，即100->199, 1100->1199...54100->54199,
                这些数的百位都是1，因此百位上的1总数是55*100
                 */
                if((left%10)> 1){
                    res+= (left/10 +1)* base;
                }

                /*
                如果n是54125,这时由于它的百位是1，
                先看xx100到xx199，其中xx是0到53，即54*100, 然后看54100到54125，这是26个。
                所以百位上的1的总数是54*100 + 26.
                 */
                else if((left%10)== 1){
                    res+= (left/10 )* base+ (right+1);
                }
                /*
                如果n是54025，那么只需要看xx100到xx199中百位上的1，这里xx从0到53，总数为54*100
                 */
                else{
                    res+= (left / 10) * base;
                }
            base *= 10;
        }
        return res;
    }
}
