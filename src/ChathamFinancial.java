import java.util.HashSet;
import java.util.Set;

public class ChathamFinancial {
    public static void main(String [] args){
        int [] ranks = {};
        System.out.println(solution(ranks));
    }
    public static int solution(int[] ranks) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        int countSoldiers = 0;
        for(int rank : ranks){
            set.add(rank);
        }
        for(int rank : ranks){
            if(set.contains(rank+1)){
                countSoldiers++;
            }
        }
        return countSoldiers;
    }
}
