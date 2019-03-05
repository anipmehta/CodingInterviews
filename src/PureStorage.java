import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2,3,4,5,6 ,3
// 0+5+1/2 = 3
// right = 2
// 0 + 2 +1 /2 = 1
//left = 2

public class PureStorage{
    public static void main(String [] args){
        List<String> list = new ArrayList<>();
        list.add("ACQUIRE 364");
        list.add("ACQUIRE 84");
        list.add("RELEASE 364");
        list.add("RELEASE 84");
        System.out.println(check_log_history(list));
    }
    public static int check_log_history(List<String> events){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<events.size();i++){
            String event = events.get(i);
            String [] arr = event.split(" ");
            String number = arr[1];
            if (arr[0].equalsIgnoreCase("ACQUIRE")){
                if(stack.contains(number)){
                    return i+1;
                }
                stack.push(number);
            }
            else if(arr[0].equalsIgnoreCase("RELEASE")){
                String top = stack.peek();
                if(!stack.equals(number)  || !stack.contains(number)) {
                    return i + 1;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? 0 : events.size() + 1;
    }
}
