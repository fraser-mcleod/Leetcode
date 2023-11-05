import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> result = new LinkedList<>();
    String digits;
    public static void main(String args[]){
        Solution test = new Solution();
        String digits = "23";
        System.out.println(digits);
        System.out.println(test.letterCombination(digits));

        digits = "2";
        System.out.println(digits);
        System.out.println(test.letterCombination(digits));

        digits = "";
        System.out.println(digits);
        System.out.println(test.letterCombination(digits));
    }

    public List<String> letterCombination(String digits){
        this.digits = digits;
        this.result.clear();
        letterHelper(0, "");
        return result;
    }

    public void letterHelper(int j, String s){
        if (j == digits.length()){
            result.add(s);
        } else {
            char d = digits.charAt(j);
            if (d == '2'){
                letterHelper(j+1, s+"a");
                letterHelper(j+1, s+"b");
                letterHelper(j+1, s+"c");
            } else if (d == '3'){
                letterHelper(j+1, s+"d");
                letterHelper(j+1, s+"e");
                letterHelper(j+1, s+"f");
            } else if (d == '4'){
                letterHelper(j+1, s+"g");
                letterHelper(j+1, s+"h");
                letterHelper(j+1, s+"i");
            } else if (d == '5'){
                letterHelper(j+1, s+"j");
                letterHelper(j+1, s+"k");
                letterHelper(j+1, s+"l");
            } else if (d == '6'){
                letterHelper(j+1, s+"m");
                letterHelper(j+1, s+"n");
                letterHelper(j+1, s+"o");
            } else if (d == '7'){
                letterHelper(j+1, s+"p");
                letterHelper(j+1, s+"q");
                letterHelper(j+1, s+"r");
                letterHelper(j+1, s+"s");
            } else if (d == '8'){
                letterHelper(j+1, s+"t");
                letterHelper(j+1, s+"u");
                letterHelper(j+1, s+"v");
            } else if (d == '9'){
                letterHelper(j+1, s+"w");
                letterHelper(j+1, s+"x");
                letterHelper(j+1, s+"y");
                letterHelper(j+1, s+"z");
            } else {
                System.err.println("Error digit was not in [2-9]");
            }
        }
    }


}
