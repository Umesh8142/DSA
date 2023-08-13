public class Tree {
    class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    private static Node root;

    public  Tree(){
        root=null;
    }
    void insert(int key){
        root=insertRec(root,key);
    }
    private Node insertRec(Node root, int key){
        if(root==null) {
            root=new Node(key);
            return root;
        }
        if(root.data>key){
            root.left = insertRec(root.left,key);
        }
        if(root.data<key){
            root.right=insertRec(root.right,key);
        }
        return root;
    }
    void inorder(){
        inorderRec(root);
    }
    private void inorderRec(Node root){
        if(root==null ) return;
        inorderRec(root.left);
        System.out.print(root.data+"  ");
        inorderRec(root.right);
        return;
    }
    public static void main(String [] args){
        Tree t= new Tree();
        t.insert(5);
        t.insert(8);
        t.insert(1);
        t.insert(89);
        t.insert(-1);
        t.inorder();

    }
}

