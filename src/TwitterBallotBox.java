import java.util.*;

public class TwitterBallotBox {
    public static void main(String [] args){
        String [] votes = {"Joe", "Mary", "Mary", "Joe"};
        System.out.println(electionWinner(votes));
    }
    static String electionWinner(String [] votes){
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(String vote : votes){
            map.put(vote, map.getOrDefault(vote, 0 )+1);
            max = Math.max(max, map.get(vote));
        }
        List<String> tied = new ArrayList<>();
        for(String candidate : map.keySet()){
            if(map.get(candidate)==max){
                tied.add(candidate);
            }
        }
        Collections.sort(tied);
        return tied.get(tied.size()-1);
    }
}
