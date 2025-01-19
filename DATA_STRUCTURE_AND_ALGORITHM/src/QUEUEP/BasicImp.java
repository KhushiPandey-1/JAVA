/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QUEUEP;

/**
 *
 * @author khushi pandey
 */
public class BasicImp {

    static class Queue{
        static int arr[];
        static int  size;
        static int rear = -1;
        static int front = -1;
        Queue(int size){
            
            this.size = size;
            arr = new int[size];
        }
        public static boolean isEmpty(){
//            return rear == -1;
              return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }
//        public static void add(int data){
//            if(rear == size - 1){
//                System.out.println("full");
//                return;
//            }
//            rear++;
//            arr[rear] = data;
//            
//        }
        public static void add(int data){
            
            //normal que-------
//            if(rear == size - 1){
//                System.out.println("full");
//                return;
//            }
//            rear++;
//            arr[rear] = data;
               if(isFull()){
                   return;
               }
               if(front == -1)
               {
                   front = 0;
               }
               
               rear = (rear + 1)%size;
               arr[rear] = data;
            
        }
        public static int remove(){
              //normal que-------
//            if(isEmpty()){
//                return -1;
//            }
//            int front = arr[0];
//            for(int i = 0;i < rear;i++){
//                arr[i] = arr[i + 1];
//            }
//            rear--;
//            return front;
              if(isEmpty()){
                  return -1;
              }
              int res = arr[front];
              if(rear == front){
                  rear = front = -1;
              }else{
                  front = (front + 1) %size;
              }
              return res;
              
        }
        public static int peek(){
//            normal --- ------
//             if(isEmpty()){
//                return -1;
//            }
//             return arr[0];
             if(isEmpty()){
                return -1;
            }
             return arr[front];
        }
        
    }
    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println( q.remove());
        q.add(5);
        System.out.println( q.remove());
        q.add(6);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
            
        }
        
    }
    
}
