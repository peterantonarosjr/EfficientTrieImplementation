public class Main {

    public static void main(String[] args){

        String testWord1 = "hello";
        String testWord2 = "world";
        Trie testTrie = new Trie();
        testTrie.insertWord(testWord1);
        testTrie.insertWord(testWord2);
        System.out.println(testTrie.isWordIn("world"));
        System.out.println(testTrie.isWordIn("hello"));

    }

}
