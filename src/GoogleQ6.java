import java.util.Arrays;

public class GoogleQ6 {
    public static void main(String [] args){
        GoogleQ6 googleQ6 = new GoogleQ6();
        int [] stores = {1, 5, 20, 11, 16};
        int [] houses = {5, 10, 50};
        int [] out = googleQ6.solution(stores, houses);
        System.out.print(Arrays.toString(out));
    }
    public int [] solution(int[] stores, int[] houses){
        Arrays.sort(stores);
        int [] output =  new int[houses.length];
        for(int i=0;i<houses.length;i++){
            output[i] = findNearestStore(stores, houses[i]);
        }
        return output;
    }

    private int findNearestStore(int[] stores, int house) {
        if(house<stores[0]){
            return stores[0];
        }
        if(house>stores[stores.length-1]){
            return stores[stores.length-1];
        }
        int start = 0;
        int end = stores.length-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(stores[mid]==house){
                return stores[mid];
            }
            if(stores[mid]>house){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        int d1 = Math.abs(stores[start] - house);
        int d2 = Math.abs(stores[end] - house);
        return d2<=d1 ? stores[end] : stores[start];
    }
}
