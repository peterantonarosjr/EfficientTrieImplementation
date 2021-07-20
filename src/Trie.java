import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Trie {
    private TrieNode root;
    private ArrayList<String> nodeLevelStructure;


    //Constructor
    public Trie(){
        root = new TrieNode();
        nodeLevelStructure = new ArrayList<>();

    }

    //Return the trie root node -> points to level 0
    public TrieNode getRoot(){
        return root;
    }

    //Return the node value/level list
    public ArrayList<String> getNodeOutput(){
        return nodeLevelStructure;
    }

    //Print the node value/level list
    public void printNodeOutput(TrieNode root, int level){
        generateNodeOutput(root,level);
        for(int i=0; i<nodeLevelStructure.size(); i++){
            System.out.println(nodeLevelStructure.get(i));
        }
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

    //Prints words from file that have been populated in the trie -> Use to compare input Vs. received
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

    //Prints out node values and level of leaf nodes
    public void printTrie(TrieNode currNode, int level){
        TrieNode[] childNode = currNode.getChildren();
        for (TrieNode trieNode : childNode) {
            if (trieNode != null) {
                System.out.print(trieNode.getValue()+""+level+" ");
                printTrie(trieNode, level + 1);
                if(level==0){
                    System.out.println();
                }
            }
        }

    }

    //Export the node value/level list to file
    public void exportNodeOutput(TrieNode root,int level){
        generateNodeOutput(root,level);
        try{
            String path ="D:\\IntelliJ-Workspace\\BetterTrieImplementation\\nodeStructure.txt";
            PrintWriter writer = new PrintWriter(path, StandardCharsets.UTF_8);
            for(int i=0; i<nodeLevelStructure.size(); i++){
                writer.print(nodeLevelStructure.get(i));
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Generate the Node arrayList in preparation for writing to file
    private void generateNodeOutput(TrieNode currNode, int level){
        TrieNode[] children = currNode.getChildren();
        if(currNode.getChildren() == null){
            return;
        }
        //Possibly export nodes to file in here and get rid of exportNodeOutPut
        for(TrieNode currChild : children){
            if(currChild!=null){
                nodeLevelStructure.add(Character.toString(currChild.getValue())+""+level);
                nodeLevelStructure.add(",");
                generateNodeOutput(currChild,level+1);
                if(level==0){
                    nodeLevelStructure.remove(nodeLevelStructure.size()-1);
                    nodeLevelStructure.add("\n");
                }
            }
        }
    }


}
