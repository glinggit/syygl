package com.syygl.test.study.leetCode;

import java.util.LinkedList;

public class Tree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        mirrorTree(treeNode1);
        printTree2(treeNode1); 





    }


    public static void mirrorTree(TreeNode root){
        if(null == root) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

    }


    public static void printTree2(TreeNode root){
        if(null == root) return;
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        linkedList.offer(root);
        while (!linkedList.isEmpty()){
            TreeNode poll = linkedList.poll();
            System.out.println(poll.data);
            if(poll.left != null){
                linkedList.offer(poll.left);
            }
            if(poll.right != null){
                linkedList.offer(poll.right);
            }
        }


    }



    public static void printTree(TreeNode root){
        if(null == root) return;

        System.out.println(root.data);
        //前序
        printTree(root.left);
        //中序
        printTree(root.right);
        //后序


    }




}


class TreeNode{
    public int data;

    public TreeNode left;

    public  TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}