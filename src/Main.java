import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String path = "D:\\IntelliJ-Workspace\\BetterTrieImplementation\\words.txt";
        Trie trie = new Trie();
        try {
            Scanner scanner = new Scanner(new File(path));
            while(scanner.hasNextLine()) {
                trie.insertWord(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        trie.printTrie(trie.getRoot(),0);


    }

}
