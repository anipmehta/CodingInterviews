import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bloomberg3 {
    public static void main(String[] args)
    {
        List<String> input = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine())
        {
            input.add((stdin.nextLine()));
        }
        stdin.close();
        int [] num = new int [input.get(0).length()];
        int i = 0;
        for(char ch : input.get(0).toCharArray()){
            num[i] = Integer.parseInt(String.valueOf(ch));
            i++;
        }
        System.out.println(bitFlip(num, 1));
    }
    public static int bitFlip(int []arr, int m){
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
