package newtest.offer;

public class offer23 {
    /*找到链表中环的入口
     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
*/
    public static  void main(String[] args){
        ListNode pHead = new ListNode(1);
        ListNode pAhead = new ListNode(3);
        ListNode pBhead = new ListNode(5);
        ListNode pChead = new ListNode(7);
        pHead.next = pAhead;
        pAhead.next = pBhead;
        pBhead.next = pChead;
        pChead.next = pAhead;
        ListNode ans= EntryNodeOfLoop(pHead);
        System.out.println(ans.value);
    }
    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meetingNode= MeetingNode(pHead);
        if(meetingNode== null){
            return null;
        }
        ListNode tempNode= meetingNode;
        int nodeLoop= 1;
        while(tempNode.next!= meetingNode){
            tempNode= tempNode.next;
            nodeLoop++;
        }
        ListNode pNode1= pHead;
        for(int i= 0;i< nodeLoop; i++){
            pNode1= pNode1.next;
        }
        ListNode pNode2= pHead;
        while(pNode1!= pNode2){
            pNode1= pNode1.next;
            pNode2= pNode2.next;
        }
        return pNode1;
    }
    public static ListNode MeetingNode(ListNode pHead){
        if(pHead== null){
            return null;
        }
        ListNode pSlow= pHead;
        ListNode pFast= pSlow.next;
        while(pSlow!= null&& pFast!= null){
            if(pFast== pSlow){
                return pFast;
            }
            pSlow= pSlow.next;
            pFast= pFast.next;
            if(pFast!= null){
                pFast= pFast.next;
            }
        }
        return null;
    }
}
