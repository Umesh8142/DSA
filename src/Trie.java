class TrieNode{
    TrieNode [] child;
    boolean end;
    public TrieNode (){
        child = new TrieNode[26];
        end=false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root= new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        if(word==null || word.length()==0) return;
        for(int i=0;i<word.length();i++){
            int id =word.charAt(i)-'a';
            if(curr.child[id]==null){
                curr.child[id]=new TrieNode();
            }
            curr=curr.child[id];
        }
        curr.end=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        if(word==null || word.length()==0) return false;
        for(int i=0;i<word.length();i++){
            int id =word.charAt(i)-'a';
            if(curr.child[id]==null){
                return false;
            }
            curr=curr.child[id];
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        if(prefix==null || prefix.length()==0) return false;
        for(int i=0;i<prefix.length();i++){
            int id =prefix.charAt(i)-'a';
            if(curr.child[id]==null){
                return false;
            }
            curr=curr.child[id];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
