import java.util.LinkedList;

public class Stack {

    static class  Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
       static class stack {

          Node head;
          Node tail;
          int currsize;

          stack(){
              head=null;
              tail=null;
              currsize=0;
          }

            void push(int data) {
              currsize++;
                Node n= new Node(data);
               if(head==null){
                   head=n;
                   tail=n;
               }
               else{
                   n.next=head;
                   head=n;
               }
            }

            int peek() {
              if(currsize==0) return -1;
                int b= head.data;
                return b;
            }

            int pop() {
                if(currsize==0){
                    System.out.println("empty");
                    return -1;
                }
                currsize--;
                int a=head.data;
                head=head.next;
                return a;
            }
           int size(){
               if(currsize==0){
                   return 0;
               }
               else{
                   return currsize;
               }
           }
           boolean isEmpty(){
               if(currsize==0){
                   return true;
               }
               return false;
           }
        }

    }



