package org.demo1;

public class LinkedList {

    // data, current, next
    //
    public Node head;
    public Node current;
    public Node tail;
    public class Node {
        public Node next;
        int data;
        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }


    public void insertNode(int data){
            if(head==null){
                head = new Node(data);
                current = head;
            }
            else{
                current = head;
                while(current.next !=null){
                    current = current.next;
                }
                current.next = new Node(data);
                current = current.next;
            }
    }

    public void deleteNode(int data){
        if (head==null){
            System.out.println("Unable to delete the node as the linked list is empty");
        }
        current = head;
        if(current.data==data){
            head = current.next;
        }
        else{
            while(current.next != null){
                if(current.next.data==data){
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
    }

    public void displayList(){
        if (head == null){
            System.out.println("No node available to display.");
        }
        current = head;
        while (current!=null){
            System.out.print(" "+current.data);
            current = current.next;
        }
        System.out.println();
    }


}
