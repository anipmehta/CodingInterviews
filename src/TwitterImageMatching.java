import java.lang.reflect.Array;
import java.util.*;

public class TwitterImageMatching {
    public static void main(String [] args){
        List<String> grid1 = new ArrayList<>();
        grid1.add("001");
        grid1.add("011");
        grid1.add("100");
        List<String> grid2 = new ArrayList<>();
        grid2.add("001");
        grid2.add("011");
        grid2.add("101");

        int result = countMatches(grid1, grid2);
        System.out.println(result);
    }

    public static int countMatches(List<String> grid1, List<String> grid2){

        int region=0;
        boolean flag = true;
        for(int i=0;i<grid1.size();i++){
            for(int j=0;j<grid1.get(i).length();j++){
                if(grid1.get(i).charAt(j)=='1' && grid2.get(i).charAt(j)=='1'){
                    Set<String> set1 = new HashSet<>();
                    Set<String> set2 = new HashSet<>();
                    helper(set1, i, j, grid1);
                    helper(set2, i, j, grid2);
                    if(set1.size()!=set2.size()){
                        flag = false;
                    }
                    else{
                        for(String coord : set1){
                            if(!set2.contains(coord)) {
                                flag = false;
                                break;
                            }
                    }
                    }
                    if(flag){
                        region++;
                    }
                    flag=true;
                }
            }
        }
        return region;
    }
    public static void helper(Set<String> set, int i, int j, List<String> grid){
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid.get(i).length() || grid.get(i).charAt(j)!='1') return;
        int[] coord = new int[] { i, j };
        set.add(Arrays.toString(coord));
        StringBuilder str = new StringBuilder(grid.get(i));
        str.setCharAt(j, '0');
        grid.set(i, str.toString());
        helper(set, i-1, j, grid);
        helper(set, i+1, j, grid);
        helper(set, i, j+1, grid);
        helper(set, i, j-1, grid);

    }
    public static class Coordinate{
        public int x;
        public int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
