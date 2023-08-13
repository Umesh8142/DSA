import java.util.*;


public class LinkedList {


    public static void main(String [] args){
        Node head=null;
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a= sc.nextInt();
           head= insertAtTail(head,a);
        }

               //head= delete(head,2);
        head=InsertAtK(head,5,6);



        print(head);

    }
        public  static Node insertAtHead(Node head, int data){
        Node n = new Node(data);
        n.next=head;
        head=n;
        return head;


    }
    public static Node insertAtTail(Node head, int data){
        Node n= new Node(data);
        if(head==null){
            head=n;
            return head;

        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=n;

       return head ;
    }
    public static Node delete(Node head, int k){
        int i=k-1;
        if(i==0){
            head=head.next;
            return head;
        }
        Node curr=head;
        Node pre=null;
        while(i!=0){
            pre=curr;
            curr=curr.next;
            i--;
        }
        pre.next=curr.next;
        return head ;
    }
    public static void print( Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
    }
    public static Node InsertAtK(Node head, int k, int data){
        Node n= new Node(data);
        if(k==1){
            n.next=head;
            head=n;
            return head;
        }
        Node curr =head;
        Node pre=null;
        while(k-1>0){
            pre=curr;
            curr=curr.next;
            k--;
        }
        pre.next=n;
        n.next=curr;
        return head;

    }
}



