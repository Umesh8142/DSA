
import java.util.*;

class Main{
    static void printList(DoublyLL.Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        DoublyLL.Node first = new DoublyLL.Node(val);
        DoublyLL.Node tail = first;
        for(int i=0; i<n-1; i++)
        {
            val = sc.nextInt();
            tail.next = new DoublyLL.Node(val);
            tail = tail.next;
        }
        int m = sc.nextInt();
        val = sc.nextInt();
        DoublyLL.Node second = new DoublyLL.Node(val);
        tail = second;
        for(int i=0; i<m-1; i++)
        {
            val = sc.nextInt();
            tail.next = new DoublyLL.Node(val);
            tail = tail.next;
        }

        Solution g = new Solution();
        DoublyLL.Node res = g.subtract(first, second);
        printList(res);
    }
}

class Solution{
    static	int length(DoublyLL.Node l1){
        int count=1;
        DoublyLL.Node temp=l1;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    static DoublyLL.Node subtract(DoublyLL.Node l1, DoublyLL.Node l2)
    {
        int n1=length(l1);
        int n2=length(l2);
        if(n2>n1){
            DoublyLL.Node temp=l2;
            l2=l1;
            l1=temp;
        }
        if(n1==n2){
            DoublyLL.Node t1=l1,t2=l2;
            while(t1.data==t2.data){
                t1=t1.next;
                t2=t2.next;
                if(t1==null){
                    return new DoublyLL.Node(0);
                }

            }
            if(t2.data>t1.data){
                DoublyLL.Node temp=l2;
                l2=t1;
                l1=temp;
            }
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        DoublyLL.Node t1 = l1,t2 = l2,ans =null;
        while(t1!=null){
            int b = 0;
            if(t2 != null)
                b = t2.data;
            if(t1.data < b){
                t1.next.data = t1.next.data - 1;
                t1.data = t1.data+10;
            }
            DoublyLL.Node n = new DoublyLL.Node(t1.data - b);
            n.next = ans;
            ans = n;
            t1 = t1.next;
            if(t2!=null)
                t2 = t2.next;
        }
        //remove trailing zero
        while(ans.next!=null && ans.data == 0)
            ans = ans.next;

        return ans;


    }
    static DoublyLL.Node reverse(DoublyLL.Node l){
        DoublyLL.Node curr=l;
        DoublyLL.Node forw=l;
        DoublyLL.Node pre=null;
        while(curr!=null){
            forw=curr.next;
            curr.next=pre;
            pre=curr;
            curr=forw;
        }
        return pre;
    }
}