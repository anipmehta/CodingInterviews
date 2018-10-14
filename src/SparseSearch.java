/*
Given a sorted array of strings which is interspersed with empty strings,
write a method to find the location of a given string.
*/
public class SparseSearch {
    public static void main(String [] args){
       SparseSearch sparseSearch = new SparseSearch();
       String arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"};
       int answer = sparseSearch.search(arr, "geeks");
       System.out.println(answer);
    }
    public int search(String [] arr, String key) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low  + (high-low)/2;
            if(arr[mid]==""){
                int left = mid-1;
                int right = mid+1;
                while(true){
                    if(left<low || right>high){
                        return -1;
                    }
                    if(left>=low && arr[left]!=""){
                        mid = left;
                        break;
                    }
                    if(right<=high && arr[right]!=""){
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid].compareTo(key)>0){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return -1;
    }
}
