package newtest.offer;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
/*字符串的所有组合
 最容易想到的方式是递归，遍历字符串，每个字符串只能取或不取。若取该字符，就把它放到结果字符串中，遍历完毕后，输出结果字符串。
 */
public class offer38plus {
    private static ArrayList<String> res;
    public static void main(String[] args) {
        res= new ArrayList<String>();
        String input= "abcefghi";
        for (int j=1; j<input.length();j++){
            Group(input, j);
        }
        System.out.println(res.toString());
    }

    public static void Group(String str, int m) {
        if (str != null && str.length() > 0) {
            StringBuffer  sb=new StringBuffer("");
            GroupCore(str.toCharArray(), 0, m, sb);
            Collections.sort(res);
        }
    }

    public static void GroupCore(char[] cs, int i, int m, StringBuffer sb) {
        if (m== 0) {
            String val = sb+"";
            if (!res.contains(val))
                res.add(val);
        }
        if(i== cs.length){
            return;
        }
        //取该字符
        sb.append(cs[i]);
        GroupCore(cs, i+1, m- 1, sb);

        //不取该字符，先删除掉
        sb.deleteCharAt(sb.length()- 1);
        GroupCore(cs, i+1, m, sb);
    }
}