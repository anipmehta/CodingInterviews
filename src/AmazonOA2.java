import java.util.*;

class ProductReviewScore{
    public int productId;
    public double reviewScore;
    public ProductReviewScore(int productId, double reviewScore){
        this.productId = productId;
        this.reviewScore = reviewScore;
    }
}
public class AmazonOA2{
    public Map<Integer, Double> calculateHighestFive(int scoreCount, List<ProductReviewScore> reviewScoresOfProduct){
        Map<Integer, PriorityQueue<Double>> map = new HashMap<>();
        for(ProductReviewScore productReviewScore : reviewScoresOfProduct){
            if(!map.containsKey(productReviewScore.productId)){
               addNewEntry(map, productReviewScore);
            }
            updateEntry(map, productReviewScore);
        }
        Map<Integer, Double> productToReview = new HashMap<>();
        for(int id : map.keySet()){
            productToReview.put(id, getAggregate(map, id));
        }
        return productToReview;
    }

    private void updateEntry(Map<Integer, PriorityQueue<Double>> map, ProductReviewScore productReviewScore) {
        PriorityQueue<Double> heap = map.get(productReviewScore.productId);
        heap.offer(productReviewScore.reviewScore);
        if(heap.size()>5){
            heap.poll();
        }
    }

    private void addNewEntry(Map<Integer, PriorityQueue<Double>> map, ProductReviewScore productReviewScore) {
        map.put(productReviewScore.productId, new PriorityQueue<>(5));
    }

    private double getAggregate(Map<Integer, PriorityQueue<Double>> map, int id) {
        double average = 0;
        PriorityQueue<Double> heap = map.get(id);
        while(!heap.isEmpty()){
            average += heap.poll();
        }
        return average/5;
    }

}
