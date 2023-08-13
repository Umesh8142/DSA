public class Queue {
   static class Node{
        int data;
        Node next;
        Node(int a){
            this.data=a;
            next=null;
        }
    }
    static class queue{
        Node head;
        Node tail;
        int currsize;
        queue(){
            head=null;
            tail=null;
            currsize=0;
        }
        void push(int a){
            Node n= new Node(a);
            currsize++;
            if(head==null){
                head=n;
                tail=n;
            }
            else {
                tail.next = n;
                tail=n;
            }
        }
        int  peek(){
            if(currsize==0) return -1;
            return head.data;
        }
        int poll(){
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
