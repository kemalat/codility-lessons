package com.baykalsoft;

class Node {
  public int data;
  public Node next;

  public void displayNodeData() {
    System.out.println("{ " + data + " } ");
  }
}

public class SinglyLinkedList {

  private Node head;


  public boolean isEmpty() {
    return (head == null);
  }

  // used to insert a node at the start of linked list
  public void insertFirst(int data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = head;
    head = newNode;
  }

  public Node deleteFirst() {
    Node temp = head;
    head = head.next;
    return temp;
  }
  public static void main(String args[])
  {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    System.out.println(singlyLinkedList.isEmpty());
    singlyLinkedList.insertFirst(2);
    singlyLinkedList.insertFirst(5);
    singlyLinkedList.deleteFirst();
  }

}