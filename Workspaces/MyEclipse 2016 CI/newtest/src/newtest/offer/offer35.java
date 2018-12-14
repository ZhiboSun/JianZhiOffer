package newtest.offer;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};
public class offer35 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head== null){
            return null;
        }
        cloneNode(head);
        connectRandomNode(head);
        return splitLink(head);

    }
    public static void cloneNode(RandomListNode head){
        RandomListNode pNode= head;
        while(pNode!= null){
            RandomListNode pCloneNode= new RandomListNode(pNode.label);
            pCloneNode.next= pNode.next;
            pCloneNode.random= null;

            pNode.next= pCloneNode;
            pNode= pCloneNode.next;
        }
    }

    public static void connectRandomNode(RandomListNode head){
        RandomListNode pNode= head;
        while(pNode!= null){
            RandomListNode pCloneNode= pNode.next;
            if(pNode.random!= null){
                pCloneNode.random= pNode.random.next;
            }
            pNode= pCloneNode.next;
        }
    }
    public static RandomListNode splitLink(RandomListNode head){
        RandomListNode pNode= head;
        RandomListNode pCloneNodeHead= null;
        RandomListNode pCloneNode= null;


        pCloneNodeHead= pCloneNode= pNode.next;
        pNode.next= pCloneNode.next;
        pNode= pNode.next;          //pNode 比CloneNode快

        while(pNode!= null){
            pCloneNode.next= pNode.next;
            pCloneNode= pCloneNode.next;
            pNode.next= pCloneNode.next;
            pNode= pNode.next;
        }
        return pCloneNodeHead;
    }
}
