import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> result = new LinkedList<>();
    String digits;
    public static void main(String args[]){

    }

    public List<String> letterCombination(String digits){
        this.digits = digits;

        return result;
    }

    public void letterHelper(int j, String s){
        if (j == digits.length()){
            result.add(s);
        } else {

        }
    }


}
