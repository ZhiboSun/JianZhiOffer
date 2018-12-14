package newtest.offer;
public class offer20 {
    public static int inx;
    public static void main(String[] args){
        String string= "123+e6";
        char[] temp= string.toCharArray();
        boolean ans = isNumeric(temp);
        System.out.println(ans);
    }

    /**
     * 利用正则表达式
     * [\\+\\-]?                    正或负符号出现与否
     * \\d*                         整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?                   如果出现小数点，那么小数点后面必须有数字；否则一起不出现
     * ([eE][\\+\\-]?\\d+)?         如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数；或者整个部分都不出现
     *
     * @param str
     * @return
        public boolean isNumeric(char[] str) {
            return new String(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
        }
     */



    //常规方法 剑指offer
    // 数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，其中A和C都是
    // 整数（可以有正负号，也可以没有），而B是一个无符号整数
    public static boolean isNumeric(char[] str) {
        if(str==null || str.length==0){
            return false;
        }
        inx= 0;
        boolean numeric= scanInteger(str);

        /* 如果出现'.'，接下来是数字的小数部分 */
        if(inx< str.length&& str[inx]== '.'){
            inx++;

            //之所以使用||，而没有使用&&的原因。
            // 小数可以没有整数部分，如.123等于0.123；
            // 小数点后面可以没有数字，如233.等于233.0；
            // 当然，小数点前后都可以有数字，如1.123；
            numeric= scanUnsignedInteger(str)|| numeric;
        }

        /* 如果出现'e'或者'E'，接下来跟着的是数字的指数部分 */
        if(inx< str.length&& (str[inx]== 'e'|| str[inx]== 'E')){
            inx++;

            // 下面一行代码用&&的原因：
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            numeric= numeric&& scanInteger(str);
        }
        return numeric&& inx== str.length;
    }
    /* 匹配B部分 */
    private static boolean scanInteger(char[] str) {
        if(inx< str.length&& (str[inx]=='+'|| str[inx]=='-')){
            inx++;
        }
        return scanUnsignedInteger(str);
    }
    /* 匹配A、C部分 */
    private static boolean scanUnsignedInteger(char[] str) {
        int before= inx;
        while(inx< str.length&& str[inx]> '0'&& str[inx]< '9'){
            inx++;
        }
        return before< inx;
    }
}
