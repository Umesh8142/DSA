
public class DoublyLL {
    static class Node{
        int data;
        Node next;
        Node pre;
        Node(int a){
            this.data=a;
            next=null;
            pre=null;
        }

    }
    public static void print( Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");

            curr=curr.next;
        }
        System.out.println();
    }

    public static Node insertAtHead(Node head,int data){
        Node n= new Node(data);
        if(head==null){
            return n;
        }

        n.next=head;
        head.pre=n;
        n.pre=null;
        head=n;
        return head;
    }
    public static Node delete(Node head,int k){
        if(k==1){
            return head.next;
        }
        Node curr=head;
        while(k>1){
            curr=curr.next;
            k--;
        }
        curr.pre.next=curr.next;
        curr.next.pre=curr.pre;
        curr=null;
        return head;
    }
}
