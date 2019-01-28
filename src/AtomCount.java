import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class AtomCount {
    public static void main(String [] args){
        AtomCount atomCount = new AtomCount();
        System.out.println(atomCount.countOfAtoms("CH2Cl"));
    }
    public String countOfAtoms(String formula) {
    Map<String, Integer> map = new TreeMap<>();
    Stack<String> stack = new Stack<>();
    char [] formulaArr = formula.toCharArray();
    int start = 0;
    int end = 0;
    String atom = "";
    int count = 1;
    for (int i = 1;i < formulaArr.length ; i++){
        if(!Character.isDigit(formulaArr[i]) && !Character.isUpperCase(formulaArr[i])){
           end = i;
        }
        else if(formulaArr[i]=='('){
            i++;
        }
        else{
            atom = formula.substring(start, end+1);
            start = i;
            while(i<formulaArr.length && Character.isDigit(formulaArr[i])){
                i++;
            }
            count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
            addToMap(map, atom, count);
            start = i;
            end = i;
        }
    }
    if(start<=formulaArr.length-1){
        addToMap(map, formula.substring(start), 1);
    }
    StringBuilder str = new StringBuilder();
    for( String atomKey : map.keySet()){
        str.append(atomKey);
        count = map.get(atomKey);
        if (count > 1){
            str.append(count);
        }
    }
    return str.toString();
    }

    private void addToMap(Map<String, Integer> map, String atom, int count) {
        map.put(atom, map.getOrDefault(atom, 0)  + count);
    }
}
