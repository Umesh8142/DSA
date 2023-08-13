import java.util.*;
public class Dryrun {
    public static void main(String[] args) {
    LRUCache c = new LRUCache(2);
    c.put(1,1);
    c.put(2,2);
   System.out.println( c.get(1));
    c.put(3,5);
        System.out.println( c.get(2));
    c.put(4,6);
        System.out.println( c.get(1));
        System.out.println( c.get(3));
        System.out.println( c.get(4));
        c.put(8,6); c.put(9,6);
        System.out.println( c.get(3));
        System.out.println( c.get(4));

    }
}
class LRUCache {
    class Node{
        int key ;
        int value;
        Node next;
        Node pre;
        Node (int key,int value){
            this.key = key;
            this.value = value;
            next=null;
            pre=null;
        }
    }
    Node head;
    Node tail;
    HashMap<Integer, Node> cache;
    int cap;
    private Node remove(Node curr){
        curr.pre.next=curr.next;
        curr.next.pre=curr.pre;
        curr.next=null;
        curr.pre=null;
        return curr;
    }
    private void addFirst(Node n){
        head.pre=n;
        n.next=head;
        head=head.pre;
    }

    public LRUCache(int capacity) {
        head= new Node (-1,-1);
        tail=head;

        cache= new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node curr=cache.get(key);
            curr=remove(curr);
            addFirst(curr);
            return curr.value;
        }
        return -1;
    }


    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node curr=cache.get(key);
            remove(curr);
            cache.remove(key);
        }

        Node node=new Node(key,value);
        addFirst(node);
        cache.put(key, node);

        if (cache.size() > cap) {
            Node evictedKey =tail.pre;
            cache.remove(evictedKey.key);
            remove(evictedKey);

        }
    }
}
