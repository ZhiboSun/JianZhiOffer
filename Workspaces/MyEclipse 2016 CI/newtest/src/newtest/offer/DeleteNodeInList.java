package newtest.offer;

import java.util.Stack;

class ListNode{
    int value;
    ListNode next;
    ListNode(int value){
        this.value = value;
    }
}
/*
    平均复杂度为[(n-1)*O(1)+O(n)]/n, 结果还是O(1)
 */
public class DeleteNodeInList {
    public static void main(String[] args) {

        ListNode pHead = new ListNode(1);
        ListNode pAhead = new ListNode(3);
        ListNode pBhead = new ListNode(5);
        ListNode pChead = new ListNode(7);
        pHead.next = pAhead;
        pAhead.next = pBhead;
        pBhead.next = pChead;
        deleteNode(pHead,pChead);
        while (pHead != null) {
            System.out.print(pHead.value + ",");
            pHead = pHead.next;
        }
    }

    private static void deleteNode(ListNode pHead, ListNode pBhead) {
        if(pHead== null || pBhead== null){
            return;
        }
        ListNode pNode= pHead;

        //删除的不是尾节点,复杂度为O（1）
        if(pBhead.next!= null){
            pBhead.value= pBhead.next.value;
            pBhead.next= pBhead.next.next;
        }
        //删除是尾节点,也是头结点，链表只有一个节点
        else if(pHead== pBhead){
            pHead= null;
        }
        //删除的节点是尾节点,复杂度是O(n)
        else{
            while(pNode.next!= pBhead){
                pNode= pNode.next;
            }
            pNode.next= null;
            Stack<Integer> integers= new Stack<>();
        }
    }
}
