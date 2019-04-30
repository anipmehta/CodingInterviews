import java.util.*;

/*
[1,2,3,1,2,2,3] k = 2
2,3
2 ->3
1->2
3->2
class HeapItem{
    int val;
    int count;
}
min_heap = [(2,3), (3,2)]
[3,2][2,3]
N-> unique integer values
T- o(NlogK + N)
S - o(N)
 */
public class FacebookTopKFrequent {
    public List<Integer> topK(List<Integer> list, int k){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num : list){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<HeapItem> heap = new PriorityQueue<>(k, new Comparator<HeapItem>() {
            @Override
            public int compare(HeapItem o1, HeapItem o2) {
                return o1.count - o2.count;
            }
        });
        for(int num : map.keySet()){
            if(heap.size()==k){
                HeapItem top = heap.peek();
                if(top.count > map.get(num)){
                    continue;
                }
                else{
                    heap.poll();
                }
            }
            heap.offer(new HeapItem(num, map.get(num)));
        }

        while (!heap.isEmpty()){
            list.add(heap.poll().val);
        }
        return list;
    }
    class HeapItem{
        public int val;
        public int count;
        public HeapItem(int val, int count){
            this.val = val;
            this.count = count;
        }
    }
}
