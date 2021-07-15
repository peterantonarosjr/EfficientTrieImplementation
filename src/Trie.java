import java.util.Iterator;
import java.util.Stack;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Insert a word into the tree if it's new
    public void insertWord(String value){
        String word=value.toLowerCase();
        //ASCII VALUES a=97, z=122
        TrieNode head = root;
        if(!isWordIn(word)){
            for(int i=0; i<word.length(); i++){
                char current = word.charAt(i);
                if(head.getChildren()[current-'a']==null){
                    head.getChildren()[current-'a'] = new TrieNode(current);
                }
                head = head.getChildren()[current-'a'];
                if(i==word.length()-1){
                    head.setWord(true);
                }
            }
        }
    }

    //Does the word exist already in Trie?
    public boolean isWordIn(String value){
        String word = value.toLowerCase();
        word = word.replaceAll("\\s+","");
        return searchTrie(word);
    }

    //Does the prefix exist already in Trie?
    public boolean isPrefixIn(String value){
        String prefix = value.toLowerCase();
        prefix = prefix.replaceAll("\\s+","");
        return searchTrie(prefix);
    }

    //Check if words from file have been populated
    public void checkTrieWords(TrieNode head, int depth, StringBuilder sequence){
        if(head == null){
            return;
        }
        for(int i=0; i<head.getChildren().length; i++){
            sequence.insert(depth,head.getValue());
            checkTrieWords(head.getChildren()[i],depth+1,sequence);
        }
        if(head.isWord()){
            for(int j=1; j<=depth; j++){
                System.out.print(sequence.charAt(j));
            }
            System.out.println();
        }
    }

    public void printTrie(TrieNode currNode, int level){
        TrieNode[] childNode = currNode.getChildren();
        for(int i=0; i<childNode.length;i++){
            if(childNode[i]!=null){
                System.out.println(childNode[i].getValue());
                if(childNode[i].isWord()){
                    System.out.println("word found at level " + level);
                }
                printTrie(childNode[i], level+1);
            }
        }

    }

    public TrieNode getRoot(){
        return root;
    }

    //Search for given string value
    private boolean searchTrie(String value){
        TrieNode head = root;
        for(int i=0; i<value.length(); i++){
            char current = value.charAt(i);
            if(head.getChildren()[current-'a']==null){
                return false;
            }
            head = head.getChildren()[current-'a'];
        }
        return true;
    }
}
