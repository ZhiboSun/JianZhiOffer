package newtest.offer;

import java.util.Stack;

class listNode{
    int data;
    listNode next;
}

public class printListReverse {
    public static void main(String[] args){
        listNode node1=new listNode();
        listNode node2=new listNode();
        listNode node3=new listNode();
        node1.data=1;
        node2.data=2;
        node3.data=3;
        node1.next=node2;
        node2.next=node3;
        printListReverse(node1);
    }
    public static void printListReverse(listNode node){
        if(node== null){
            System.out.println("node is null");
        }
        Stack<listNode> stack = new Stack<listNode>();
        while(node!= null){
            stack.push(node);
            node= node.next;
        }
        while(!stack.isEmpty()){
            listNode pop = stack.pop();
            System.out.println(pop.data);
        }
    }
}
