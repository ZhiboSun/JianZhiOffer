package newtest.offer;

import java.util.ArrayList;

/*
二叉树中和为某一值的路径

输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class offer34 {
    private static ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<Integer> path= new ArrayList<>();
        if(root== null){
            return res;
        }
        FindPathCore(root, target, path);
        return res;
    }
    public static void FindPathCore(TreeNode root, int target, ArrayList<Integer> path){
        target-= root.val;
        path.add(root.val);

        boolean isLeaf= root.left== null&& root.right== null;
        if(target== 0&& isLeaf){
            //不重新new的话从始至终res中所有引用都指向了同一个一个list.
            res.add(new ArrayList<>(path));
        }
        if(root.left!= null){
            FindPathCore(root.left, target, path);
        }
        if(root.right!= null){
            FindPathCore(root.right, target, path);
        }
        path.remove(path.size()-1);
    }
    public static void main(String[] args){
        TreeNode root= new TreeNode(10);
        TreeNode node5= new TreeNode(5);
        TreeNode node12= new TreeNode(12);
        TreeNode node4= new TreeNode(4);
        TreeNode node7= new TreeNode(7);
        root.left= node5;
        root.right=node12;
        node5.left= node4;
        node5.right= node7;
        ArrayList<ArrayList<Integer>> res= FindPath(root, 22);
        for (int i=0;i<res.size(); i++){
            ArrayList<Integer> temp= res.get(i);
            for(Integer j: temp) {
                System.out.print(j.intValue() + " ");
            }
            System.out.println("");
        }
    }
}
