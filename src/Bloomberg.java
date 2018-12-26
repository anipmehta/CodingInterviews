import java.util.*;

public class Bloomberg {
    public static void main(String [] args){
        List<String> input = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine())
        {
            input.add((stdin.nextLine()));
        }
        stdin.close();
        int guards = Integer.parseInt(input.get(0));
        int size = Integer.parseInt(input.get(1));
        int arr [] = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(input.get(2+i));
        }
        for(int out : groupCount(arr, guards)){
            System.out.print(out + " ");
        }

    }
    public static int[] groupCount(int [] arr, int size){
        int [] count = new int[size];
        int [] current = new int[size];
        Queue<Integer> q = new LinkedList<>();
        for (int i : arr)
            q.add(i);
        while(!q.isEmpty()){
            boolean flag = false;
            for(int i=0;i<current.length;i++){
                if(current[i]==0) {
                    current[i] = q.poll();
                    count[i]++;
                    if(count[i]%10==0){
                        current[i] = current[i]+5;
                    }
                    flag = true;
                }
            }
            if(!flag){
                int min = Integer.MAX_VALUE;
                for(int i : current){
                    min = Math.min(i, min);
                }
                for(int i=0;i<current.length;i++){
                    current[i] = current[i] - min;
                }
            }
        }
    return count;
    }

}
