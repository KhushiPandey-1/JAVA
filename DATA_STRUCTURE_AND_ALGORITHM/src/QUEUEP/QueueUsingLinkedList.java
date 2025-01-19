/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QUEUEP;

/**
 *
 * @author khushi pandey
 */
public class QueueUsingLinkedList {

     static class Node{
         int data;
         Node next;
         Node(int data){
             this.data = data;
             this.next = null;
         }
     }
     static class queue{
         static Node head;
         static Node tail;
           public static boolean isEmpty(){
//            return rear == -1;
              return head == null && tail == null;
        }
      
//      
        public static void add(int data){
            Node n = new Node(data);
            if(tail == null){
                tail = head = n;
                return;
            }
            tail.next = n;
            tail = n;
        }         
        public static int remove(){
          if(isEmpty()){
              return -1;
          }
          int front = head.data;
          if(head == tail){
              tail = null;
          }
          head = head.next;
          return front;
              
        }
        public static int peek(){
             return head.data;
        }
     }
    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
//        System.out.println( q.remove());
//        q.add(5);
//        System.out.println( q.remove());
//        q.add(6);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
            
        }
    }
    
}
