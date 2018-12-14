package newtest.offer;

import java.util.Arrays;

/* 机器人的运动范围 剑指offer13题
地上有一个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，它每次可以向左、右、上、下移动一个，
但不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入放个(35,37)，因为3+5+3+7=18。
但它不能进入(35,38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子
 */
public class movingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold< 0|| rows< 1|| cols< 1)
            return 0;
        boolean[] visited= new boolean[rows* cols];
        Arrays.fill(visited, false);
        int count= movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }
    public static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count= 0;
        if(row>= 0&& row< rows&& col>= 0&& col< cols && !visited[row*cols+ col] && less(row, col, threshold)){
            visited[row*cols+ col]= true;
            count= 1+ movingCountCore(threshold, rows, cols, row- 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col+ 1, visited)
                    + movingCountCore(threshold, rows, cols, row+ 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col- 1, visited);
        }
        return count;
    }
    public static boolean less(int row, int col, int threshold){
        int sum= 0;
        while(row> 0){
            sum+= row% 10;
            row /=10;
        }
        while(col> 0){
            sum+= col% 10;
            col /=10;
        }
        sum-= threshold;
        return (sum<= 0)? true: false;
    }

}
