import tree.Tree;
import util.Trie;
import util.TrieNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SixSense {
    public static void main(String [] args){
        SixSense sixSense = new SixSense();
        char [][] board = {
                {'o', 'a', 'a', 'n'},
                {'t', 'e', 'n', 't'},
                {'i', 'a', 'e', 'n'},
                {'i', 'p', 'r', 'v'}
        };
        String [] words = {"ten", "tEnT", "tenure", "tap", "pet", "pen", "IanN12n"};
        System.out.println(sixSense.findWords(board, words));
    }
    int [] X = new int[]{0,0,1,-1,1,-1,1,-1};
    int [] Y = new int[]{-1,1,0,0,1,-1,-1,1};
    public List<List<Integer>> findWords(char [][] board, String[] words){
        Trie trie = new Trie();
        TrieNode trieNode = trie.buildTrie(words);
        List<List<Integer>> out = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                boolean [][] visited = new boolean[board.length][board[i].length];
                List<String> wordsFound = new ArrayList<>();
                if(trieNode.getChildren()[board[i][j]-'a']==null){
                    continue;
                }
                dfs(board, i, j, trieNode, visited, wordsFound, -1);
                List<Integer> coordinates = new ArrayList<>();
                coordinates.add(i);
                coordinates.add(j);
                for(String word : wordsFound){
                    map.put(word, coordinates);
                }
            }
        }
        List<Integer> notFoundCoordinates = new ArrayList<>();
        notFoundCoordinates.add(-1);
        notFoundCoordinates.add(-1);
        for(String word : words){
            word = word.toLowerCase();
            if(map.containsKey(word)){
                out.add(map.get(word));
            }
            else {
                out.add(notFoundCoordinates);
            }
        }
        return out;
    }

    public void dfs(char [][] board, int row, int col, TrieNode trieNode,  boolean[][] visited, List<String> out, int dir){
        if(row<0 || col<0 || row>=board.length || col>=board[row].length){
            return;
        }
        if(visited[row][col]){
            return;
        }
        if(trieNode.getChildren()[board[row][col]-'a']==null){
            return;
        }
        if(trieNode.getChildren()[board[row][col]-'a'].getWord()!=null){
            out.add(trieNode.getChildren()[board[row][col]-'a'].getWord());
            trieNode.getChildren()[board[row][col]-'a'].setWord(null);
        }
        visited[row][col] = true;
        if(dir==-1){
            for(int i=0;i<X.length;i++){
                dfs(board, getNextX(i, row), getNextY(i, col), trieNode.getChildren()[board[row][col]-'a'], visited, out, i);
            }
        }
        else{
            dfs(board, getNextX(dir, row), getNextY(dir, col), trieNode.getChildren()[board[row][col]-'a'], visited, out, dir);
        }
        visited[row][col] = false;
    }
    public int getNextX(int index, int currentX){
        return currentX + X[index];
    }
    public int getNextY(int index, int currentY){
        return currentY + Y[index];
    }
}
