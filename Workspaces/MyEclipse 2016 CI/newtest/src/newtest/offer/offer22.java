package newtest.offer;

public class offer22 {
    /*链表中的倒数第K个节点。快慢指针
    public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    }*/
    public class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            if(head== null|| k== 0)
                return null;
            ListNode pAhead= head;
            ListNode pBhead= null;

            for(int i= 0; i< k-1; i++){
                if(pAhead.next!= null){
                    pAhead= pAhead.next;
                }else{
                    return null;
                }
            }
            pBhead= head;
            while(pAhead.next!= null){
                pAhead= pAhead.next;
                pBhead= pBhead.next;
            }
            return pBhead;
        }
    }

    /*
    找到链表的中间节点
     */
    public ListNode middleNode(ListNode head) {
        if(head== null){
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode= head;
        while(fastNode!= null&& fastNode.next!= null&& fastNode.next.next!= null){
            fastNode= fastNode.next.next;
            slowNode= slowNode.next;
        }

        /*如果题目有这个要求，偶数个节点，有两个中值，返回后面那个，则slowNode再往后移动一个
        输入：[1,2,3,4,5,6]
        输出：此列表中的结点 4 (序列化形式：[4,5,6])
        由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
         */
        if(fastNode.next!= null){
            slowNode= slowNode.next;
        }
        return slowNode;
    }




}
