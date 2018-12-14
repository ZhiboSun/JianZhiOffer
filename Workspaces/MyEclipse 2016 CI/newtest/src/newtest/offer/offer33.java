package newtest.offer;

/*
    二叉搜索树的后序遍历序列
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class offer33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return VerifySquenceOfBSTCore(sequence, 0, sequence.length- 1);
    }
    public static boolean VerifySquenceOfBSTCore(int [] sequence, int start, int end){
        if(end< start){
            return false;
        }
        int root= sequence[end];

        /* 在二叉搜索树中左子树节点值小于根节点
        * i是右子树的开始位置
        * */
        int i= start;
        for(; i< end- 1; i++){
            if(sequence[i]> root)
                break;
        }

        /* 在二叉搜索树中右子树节点值小于根节点 */
        int j= i;
        for(; j< end- 1; j++){
            if(sequence[j]< root)
                return false;
        }
        /*经过以上遍历，分开了左右子树，i是右子树的开始位置，最后一个是根节点*/


        /* 判断左子树是不是搜索二叉树 */
        boolean left= true;
        /*i==start,说明左子树为空；i==start+1,说明左子树只有一个节点。这两种情况自然不用判断左子树是不是排序二叉树 */
        if(i> start+ 2){
            left= VerifySquenceOfBSTCore(sequence, start, i- 1);
        }

        /* 判断右子树是不是搜索二叉树 */
        boolean right= true;
        /*i==end- 1,说明右子树只有一个节点；i==end，说明右子树为空。上面两种情况自然不用判断右子树是不是排序二叉树 */
        if(i< end- 1){
            right= VerifySquenceOfBSTCore(sequence, i, end- 1);
        }
        return (left&& right);
    }
}

