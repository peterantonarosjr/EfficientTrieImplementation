public class TrieNode {
    private char value;
    private boolean isLeaf;
    private TrieNode[] children = new TrieNode[26];

    public TrieNode(){

    }
    public TrieNode(char value){
        this.value = value;
    }

    public void setValue(char value){
        this.value = value;
    }
    public char getValue(){
        return value;
    }
    public void setLeaf(boolean isLeaf){
        this.isLeaf = isLeaf;
    }
    public boolean getLeaf(){
        return isLeaf;
    }

    public TrieNode[] getChildren(){
        return children;
    }

}
