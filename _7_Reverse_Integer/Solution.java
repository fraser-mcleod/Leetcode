package _7_Reverse_Integer;

public class Solution {
    public int reverse(int x) {
        boolean isPos;
        if (x>=0){
            isPos = true;
        } else {
            isPos = false;
            x = (-1)*x;
        }
        int result = 0;

        while (x > 0){
            // get rightmost digit
            int digit = x % 10;
            // subtract digit from x and then divide by 10 (moves all digit right)
            x = x - digit;
            x = x/10;
            // shift the result digits left 1 and add the new digit
            result = result*10;
            result = result+digit;
        }
        if (isPos){
            return result;
        }

        return -result;
    }
}
