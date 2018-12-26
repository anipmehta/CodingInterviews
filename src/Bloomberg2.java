import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bloomberg2 {
    public static void main(String[] args)
    {
        List<String> input = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine())
        {
            input.add((stdin.nextLine()));
        }
        stdin.close();
        int size = Integer.parseInt(input.get(0));
        String [] arr = input.get(1).split(" ");
        int [] num = new int [arr.length];
        int i = 0;
        for(String str: arr){
            num[i] = Integer.parseInt(arr[i]);
            i++;
        }
        System.out.println(fing(num));
    }
    public static String fing(int [] arr){
        int count = 0;
        for (int num : arr){
            if(num%2==0){
                count++;
            }
            if(count>1){
                return "YES";
            }
        }
        return "NO";
    }
    public int bitFlip(int []arr, int m){
        int wL = 0, wR = 0;

        // Left index and size of the widest window
        int bestL = 0, bestWindow = 0;

        // Count of zeroes in current window
        int zeroCount = 0;
        int max = Integer.MIN_VALUE;
        // While right boundary of current window doesn't cross
        // right end
        while (wR < arr.length)
        {
            // If zero count of current window is less than m,
            // widen the window toward right
            if (zeroCount <= m)
            {
                if (arr[wR] == 0)
                    zeroCount++;
                wR++;
            }

            // If zero count of current window is more than m,
            // reduce the window from left
            if (zeroCount > m)
            {
                if (arr[wL] == 0)
                    zeroCount--;
                wL++;
            }

            // Update widest window if this window size is more
            if ((wR-wL > bestWindow) && (zeroCount<=m))
            {
                bestWindow = wR-wL;
                bestL = wL;
            }
            max = Math.max(max, zeroCount);
        }
        return max;
    }
}
