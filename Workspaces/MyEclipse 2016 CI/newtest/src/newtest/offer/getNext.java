package newtest.offer;

import sun.swing.StringUIClientPropertyKey;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class TreeLinkNode {
    char val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode par = null;

    TreeLinkNode(char val) {
        this.val = val;
    }
}

/*
    分三种情况
    1、该节点已有右子树，下一个就是右子树最左节点
    2、该节点没有右子树，且是父节点的右节点。向上遍历寻找父节点，直到找到一个父节点，是它的父节点的左子节点
    3、该节点没有右子树，且是父节点的左节点。直接输出父节点
 */
public class getNext {
    public static TreeLinkNode getNext(TreeLinkNode pNode){
        TreeLinkNode ansNode= null;
        if(pNode== null){
            return ansNode;
        }
        //节点已有右子树，下一个就是右子树最左节点
        if(pNode.right!= null){
            TreeLinkNode temp= pNode.right;
            while(temp.left!= null){
                temp= temp.left;
            }
            ansNode= temp;
        }
        else if(pNode.par!= null){
            TreeLinkNode parNode= pNode.par;
            TreeLinkNode curNode= pNode;
            //节点没有右子树，且是父节点的右节点。找到是它父节点的左子节点的节点
            while(parNode.right== curNode){
                curNode= parNode;
                parNode= curNode.par;
            }
            //节点没有右子树，且是父节点的左节点
            ansNode= parNode;
        }
        return ansNode;
    }
    public static void main(String[] args){
        TreeLinkNode nodea= new TreeLinkNode('a');
        TreeLinkNode nodeb= new TreeLinkNode('b');
        TreeLinkNode nodec= new TreeLinkNode('c');
        TreeLinkNode noded= new TreeLinkNode('d');
        TreeLinkNode nodee= new TreeLinkNode('e');
        TreeLinkNode nodef= new TreeLinkNode('f');
        TreeLinkNode nodeg= new TreeLinkNode('g');
        TreeLinkNode nodeh= new TreeLinkNode('h');
        TreeLinkNode nodei= new TreeLinkNode('i');
        nodea.left= nodeb;
        nodea.right= nodec;
        nodeb.left= noded;
        nodeb.right= nodee;
        nodec.left= nodef;
        nodec.right= nodeg;
        nodee.left= nodeh;
        nodee.right= nodei;
        nodeb.par= nodea;
        nodec.par= nodea;
        noded.par= nodeb;
        nodee.par= nodeb;
        nodef.par= nodec;
        nodeg.par= nodec;
        nodeh.par= nodee;
        nodei.par= nodee;
        System.out.println("二叉树中序遍历的下一个节点是："+getNext(nodei).val);
    }
}
