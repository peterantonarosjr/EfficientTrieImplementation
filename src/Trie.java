public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Insert a word into the tree if it's new
    public void insertWord(String word){
        if(!isWordIn(word)){
            //Insert the word into Trie Code
        }

    }

    //Does the word exist already in Trie?
    public boolean isWordIn(String word){
        if(searchTrie(word)) {
            return true;
        }
        return false;
    }

    //Does the prefix exist already in Trie?
    public boolean isPrefixIn(String prefix){
        if(searchTrie(prefix)){
            return true;
        }
        return false;
    }

    //Search for given value
    private boolean searchTrie(String value){

        return true;
    }



}
