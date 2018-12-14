package newtest.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
/*
    二叉树的镜像
 */
public class offer27 {
    /*
    递归
     */
    public class Solution1{
        public void Mirror(TreeNode root) {
            if(root== null){
                return;
            }
            if(root.left== null && root.right== null){
                return;
            }
            TreeNode temp= root.left;
            root.left= root.right;
            root.right= temp;
            if(root.left!= null){
                Mirror(root.left);
            }
            if(root.right!= null){
                Mirror(root.right);
            }

        }
    }
    /*
    循环
     */
    public class Solution2 {
        public void Mirror(TreeNode root) {
            List<String> res= new ArrayList<>();
            if(root== null){
                return;
            }
            if(root.left== null && root.right== null){
                return;
            }
            Stack<TreeNode> stack= new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode tempNode= stack.pop();
                TreeNode temp= tempNode.left;
                tempNode.left= tempNode.right;
                tempNode.right= temp;
                if(tempNode.left!= null){
                    stack.push(tempNode.left);
                }
                if(tempNode.right!= null){
                    stack.push(tempNode.right);
                }
            }
        }
    }
}
