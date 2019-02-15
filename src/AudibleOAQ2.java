import java.util.*;

public class AudibleOAQ2 {
    public static void main(String [] args){
        AudibleOAQ2 audibleOAQ2 = new AudibleOAQ2();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(8);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
//        list.add(11);
//        list.add(15);
//        list.add(9);
//        list.add(7);
//        list.add(8);
        System.out.println(AudibleOAQ2.teamFormation(list, 3, 4));
    }
    public static long teamFormation(List<Integer> score, int team, int m) {
        // Write your code here

        long totalSum = 0;
        int pillar1 = m-1;
        int pillar2 = score.size() - m;
        boolean [] visited = new boolean[score.size()];
        PriorityQueue<Integer> heap1 = createMaxHeap(m, score, 0, pillar1, visited);
        PriorityQueue<Integer> heap2 = createMaxHeap(m, score, pillar2, score.size()-1, visited);
        while (team!=0){
            int number1 = heap1.isEmpty() ? 0 : heap1.peek();
            int number2 = heap2.isEmpty() ? 0 : heap2.peek();
            if(number1>=number2){
                heap1.poll();
                totalSum += number1;
                pillar1++;
                if(pillar1<score.size() && !visited[pillar1]){
                    heap1.offer(score.get(pillar1));
                }
            }
            else{
                heap2.poll();
                totalSum += number2;
                pillar2--;
                if(pillar2>=0 && !visited[pillar2]){
                    heap2.offer(score.get(pillar2));
                }
            }
            team--;
        }
        return totalSum;

    }
    public static PriorityQueue<Integer> createMaxHeap(int size, List<Integer> scores, int start, int end, boolean[] visited){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=start;i<=end;i++){
            priorityQueue.offer(scores.get(i));
            visited[i] = true;
        }
        return priorityQueue;
    }
}
