package com.rahul.dsalgo.datastructureImpl.physical;

import com.rahul.dsalgo.datastructure.physical.LinkedList;
import com.rahul.dsalgo.datastructureImpl.physical.components.Node;

/**
 * Created by Rahul on 10/17/19
 */
public class LinkedListImpl implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListImpl() {
        this.head = new Node();
        this.tail = new Node();
        this.size = 0;
    }

    @Override
    public void insert(int element) {
        if (head.next == null ) {
            head.element = element;
            head.next=tail;
            tail.previous=head;
            size = 1;
        } else if (tail.element == Integer.MIN_VALUE) {
            tail.element=element;
            size = 2;
        }
        else {
            Node newNode = new Node();
            newNode.element = element;
            newNode.previous = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = tail.next; // or tail = newNode;
            size++;
        }
    }

    @Override
    public void insert(int position, int element) {
        int index = position-1;
        if (head.next == null ) {
            head.element = element;
            head.next=tail;
            tail.previous=head;
            size = 1;
        } else if (tail.element == Integer.MIN_VALUE) {
            tail.element=element;
            size = 2;
        } else if (index < size){
            Node newNode = new Node();
            newNode.element=element;
            Node tHead = head;
            for (int i=0; i<index; i++) {
                tHead = tHead.next;
            }
            newNode.next = tHead;
            newNode.previous = tHead.previous;
            tHead.previous = newNode;
            newNode.previous.next=newNode;
            size++;
        } else {
            Node newNode = new Node();
            newNode.element = element;
            newNode.previous = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = tail.next; // or tail = newNode;
            size++;
        }
    }

    @Override
    public int deleteLast() {
        int element;
        if (tail.element == Integer.MIN_VALUE){
            if (tail.previous == head) {
                element = head.element;
                head.element=Integer.MIN_VALUE;
                head.next=null;
                tail.previous=null;
                size--;
                return element;
            } else if (tail.previous == null) {
                return Integer.MIN_VALUE;
            }
        }
        element = tail.element;
        tail = tail.previous;
        tail.next = null;
        size--;
        return element;
    }

    @Override
    public int delete(int position) {  // TODO fix code to delete elements correctly
        if (position < 1 || position > size){
            return Integer.MIN_VALUE;
        } else if (position == 1) {
            return deleteFirst();
        } else {
            int index = position-1;
            int element = Integer.MIN_VALUE;
            Node tHead = head;
            for (int i=1; i<=index; i++){
                if (tHead.next != null){
                    tHead = tHead.next;
                }
                element = tHead.element;
                tHead.previous.next = tHead.next;
                tHead.next.previous = tHead.previous;
            }
            return element;
        }
    }

    @Override
    public int deleteFirst() {
        int element = Integer.MIN_VALUE;
        if (head.element != Integer.MIN_VALUE){
            element = head.element;
            if (head.next!=null){
                head = head.next;
            }
        }
        size--;
        return element;
    }

    @Override
    public int findPosition(int element) {
        Node tHead = head;
        if (element == tHead.element) {
            return 1;
        } else {
            int position = 1;
            while (tHead.next != null) {
                tHead = tHead.next;
                position++;
                if (element == tHead.element){
                    return position;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public int findElement(int position) {
        if (position < 1 || position > size) {
            return Integer.MIN_VALUE;
        }
        Node tHead = head;
        int index = position-1;
        if(index == 0){
            return tHead.element;
        }
        else {
            for (int i=0; i<index; i++) { // TODO will this ever run into a null pointer exception ?
                if (tHead.next != null) {
                    tHead = tHead.next;
                }
            }
            return tHead.element;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Node tNode = head;

        while (tNode.next != null) {
            System.out.print(tNode.element + " ");
            tNode = tNode.next;
        }
        System.out.println(tNode.element);
    }

    @Override
    public void printReverse() {
        Node tNode = tail;

        while (tNode.previous != null) {
            System.out.print(tNode.element + " ");
            tNode = tNode.previous;
        }
        System.out.println(tNode.element);
    }
}
