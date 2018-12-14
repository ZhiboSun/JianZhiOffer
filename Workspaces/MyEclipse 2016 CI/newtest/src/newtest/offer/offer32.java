package newtest.offer;

import java.util.ArrayList;

public class offer32 {
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> reslist = new ArrayList<>();
            ArrayList<TreeNode> queue = new ArrayList<>();
            if(root== null){
                return reslist;
            }
            queue.add(root);
            while(queue.size()!= 0){
                TreeNode temp = queue.remove(0);
                if(temp.left!= null){
                    queue.add(temp.left);
                }
                if(temp.right!= null){
                    queue.add(temp.right);
                }
                reslist.add(temp.val);
            }
            return reslist;
        }
    }
}
