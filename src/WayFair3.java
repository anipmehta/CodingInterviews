import java.util.ArrayList;
import java.util.List;

public class WayFair3 {
    public int solution(int [] A){
        int castle = 0;
        List<Integer> list = new ArrayList<>();
       for(int i=1;i<A.length;i++){
           int diff = A[i-1] - A[i];
           if(diff==0){
               continue;
           }
           list.add(diff);
       }
       if(list.size()==0){
           return 1;
       }
       for(int i=1;i<list.size();i++){
           if(list.get(i)*list.get(i-1)<0){
               castle += 1;
           }
       }

       return castle+2;
    }
}
