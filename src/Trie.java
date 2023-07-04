public class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(node.children[index]==null) return false;
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(node.children[index]==null) return false;
            node = node.children[index];
        }
        return true;
    }
}
