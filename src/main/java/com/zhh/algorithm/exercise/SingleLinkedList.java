package com.zhh.algorithm.exercise;

public class SingleLinkedList {

    private Node head;

    public SingleLinkedList(){
        head = new Node(null,null);
    }

    class Node<E>{
        private E data;
        private Node next;

        public Node(Node next) {
            this.next = next;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
