public class Coinbase {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        System.out.println(printComment("// this is a single line comment\n" +
                "\n" +
                "int x = 1; // a single line comment after code"));
    }
    public static String printComment(String source){
        StringBuilder str = new StringBuilder("");;;
        char [] ch = source.toCharArray();
        for(int i=0;i<source.length()-1;i++){
            if(ch[i]=='/' && ch[i+1]=='/'){
                // str.append("//")
                while(ch[i]!='\n' && i<source.length()-1){
                    str.append(ch[i]);
                    i++;
                }
                str.append("\n");
            }
            else if(ch[i]=='/' && ch[i+1]=='*'){
                while((ch[i]=='*' && ch[i+1]=='/') && i<source.length()-1){
                    str.append(ch[i]);
                    i++;
                }
            }
        }
        return str.toString();
    }
}
