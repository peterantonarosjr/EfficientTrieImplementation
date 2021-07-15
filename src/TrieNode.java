public class TrieNode {
    private char value;
    private boolean isWord;
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
    public void setWord(boolean isWord){
        this.isWord = isWord;
    }
    public boolean isWord(){
        return isWord;
    }

    public TrieNode[] getChildren(){
        return children;
    }

}
