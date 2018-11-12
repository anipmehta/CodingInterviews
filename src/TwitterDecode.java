public class TwitterDecode {
    public static void main(String [] args){
        String result = decode("701011792823411101701997927");
        System.out.println(result);
    }
public static String decode(String encoded){
    StringBuilder str = new StringBuilder(encoded);
    str = str.reverse();
    encoded = str.toString();
    char [] arr = encoded.toCharArray();
    int last = 0;
    str = new StringBuilder("");
    int i=0;
    while(i<arr.length){
        int firstTwo = Integer.parseInt(encoded.substring(i,i+2));
        if((firstTwo>=65 && firstTwo<=90) || firstTwo==32 || (firstTwo>=97 && firstTwo<=99)){
            str.append((char)firstTwo);
            i=i+2;
        }
        else if(i+2<arr.length){
            int firstThree = Integer.parseInt(encoded.substring(i, i+3));
            if(firstThree>=100 && firstThree<=122){
                str.append((char) firstThree);
                i=i+3;
            }
        }
    }
    return str.toString();
}
}

