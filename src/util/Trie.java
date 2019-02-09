package util;

public class Trie{

    public TrieNode buildTrie(String [] words){
        TrieNode root = new TrieNode();
        for (String word : words){
            word = word.toLowerCase();
            addWord(root, word);
        }
        return root;
    }
    public void addWord(TrieNode root, String word){
        TrieNode current = root;
        for(Character ch : word.toCharArray()){
            int index = ch - 'a';
            if (index<0){
                return;
            }
            if(current.getChildren()[index]==null){
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setWord(word);
    }
}
