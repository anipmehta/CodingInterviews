import tree.Tree;
import util.Trie;
import util.TrieNode;

import java.util.*;

public class SixSense {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        List<String> board = new ArrayList<>();
        List<String> wordsList = new ArrayList<>();
        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            input = input.trim();
            input = input.toLowerCase();
            if (input.isEmpty()){
                break;
            }
            board.add(input);
        }
        while (scanner.hasNextLine()){
            wordsList.add(scanner.nextLine().trim().toLowerCase());
        }
        char [][] grid = new char[board.size()][];
        for(int i=0;i<board.size();i++){
            grid[i] = board.get(i).toCharArray();
        }
        String [] words = wordsList.toArray(new String[wordsList.size()]);
        SixSense sixSense = new SixSense();
//        char [][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'t', 'e', 'n', 't'},
//                {'i', 'a', 'e', 'n'},
//                {'i', 'p', 'r', 'v'}
//        };
//        String [] words = {"ten", "tEnT", "tenure", "tap", "pet", "pen", "IanN12n"};
//        System.out.println(sixSense.findWords(grid, words));
    }
    int [] X = new int[]{0,0,1,-1,1,-1,1,-1};
    int [] Y = new int[]{-1,1,0,0,1,-1,-1,1};
    public List<List<Integer>> findWords(List<List<Character>> board, String[] words){
        Trie trie = new Trie();
        TrieNode trieNode = trie.buildTrie(words);
        List<List<Integer>> out = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board.get(i).size();j++){
//                boolean [][] visited = new boolean[board.size()][board.get(i).length];
                List<String> wordsFound = new ArrayList<>();
                if(trieNode.getChildren()[board.get(i).get(j)-'a'] == null){
                    continue;
                }
                dfs(board, i, j, trieNode, wordsFound, -1);
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

    public void dfs(List<List<Character>> board, int row, int col, TrieNode trieNode, List<String> out, int dir){
        if(row<0 || col<0 || row>=board.size() || col>=board.get(row).size()){
            return;
        }
//        if(visited[row][col]){
//            return;
//        }
        if(trieNode.getChildren()[board.get(row).get(col)-'a']==null){
            return;
        }
        if(trieNode.getChildren()[board.get(row).get(col)-'a'].getWord()!=null){
            out.add(trieNode.getChildren()[board.get(row).get(col)-'a'].getWord());
            trieNode.getChildren()[board.get(row).get(col)-'a'].setWord(null);
        }
//        visited[row][col] = true;
        if(dir==-1){
            for(int i=0;i<X.length;i++){
                dfs(board, getNextX(i, row), getNextY(i, col), trieNode.getChildren()[board.get(row).get(col)-'a'], out, i);
            }
        }
        else{
            dfs(board, getNextX(dir, row), getNextY(dir, col), trieNode.getChildren()[board.get(row).get(col)-'a'], out, dir);
        }
//        visited[row][col] = false;
    }
    public int getNextX(int index, int currentX){
        return currentX + X[index];
    }
    public int getNextY(int index, int currentY){
        return currentY + Y[index];
    }
}
