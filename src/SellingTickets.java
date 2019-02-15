import java.util.Comparator;
import java.util.PriorityQueue;

public class SellingTickets {
    public int sellingKTickets(int [] windows, int k){
        int revenue=0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(windows.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int ticket : windows){
            heap.offer(ticket);
        }
        while (k!=0){
            int max = heap.poll();
            revenue += max;
            heap.offer(max-1);
            k--;
        }
        return revenue;
    }
    public static void main(String [] args){
        int [] tickets  = {5,10,11,2};
        SellingTickets sellingTickets = new SellingTickets();
        System.out.println(sellingTickets.sellingKTickets(tickets, 2));
    }
}
