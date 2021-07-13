public class Main {

    public static void main(String[] args){

        String testWord = "hello";
        Trie testTrie = new Trie();
        testTrie.insertWord(testWord);
        System.out.println(testTrie.isWordIn("Hello"));

    }

}
