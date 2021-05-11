package com.syygl.test.study.leetCode;

public class MergeLinkedList {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        head1.next = node2;
        node2.next = node3;

        Node head2 = new Node(2);
        Node node22 = new Node(4);
        Node node33 = new Node(6);
        head2.next = node22;
        node22.next = node33;

        Node node = merge2(head2, head1);

        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }

    }



    //递归合并
    public static Node merge(Node head1, Node head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Node head = null;
        if(head1.data < head2.data){
            head = head1;
            head.next = merge(head1.next, head2);
        }else{
            head = head2;
            head.next = merge(head1, head2.next);
        }

        return head;
    }

    public static Node merge2(Node head1, Node head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Node head = head1.data < head2.data ? head1 : head2;

        Node smallNode = head == head1 ? head1 : head2;
        Node largeNode = head == head1 ? head2 : head1;

        Node pre = null;
        Node next = null;

        while (smallNode != null && largeNode != null){
            if(smallNode.data <= largeNode.data){
                pre = smallNode;
                smallNode = smallNode.next;
            }else{
                next = largeNode.next;
                pre.next = largeNode;
                largeNode.next = smallNode;
                pre = largeNode;
                largeNode = next;

            }
        }

        pre.next = smallNode == null ? largeNode : smallNode;

        return head;
    }






}







class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}