import java.util.ArrayList;

public class TrieFileGenerator {
    public Trie trie;
    public ArrayList<String> info;

    public TrieFileGenerator(Trie trie){
        this.trie = trie;
        info = trie.getNodeOutput();
    }

    public void printOutput(){
        for(int i=0; i<info.size(); i++){
            System.out.println(info.get(i));
        }

    }

}
