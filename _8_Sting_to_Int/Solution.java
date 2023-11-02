

public class Solution {
    public static void main(String args[]){
        String testName = "test 1";
        String test = "-1054";
        int expected = -1054;
        int result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d\n", testName, expected, result);
        }

        testName = "test 2";
        test = "1000000000000000000000000000";
        expected = Integer.MAX_VALUE;
        result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d\n", testName, expected, result);
        }

        testName = "test 3";
        test = String.valueOf(Integer.MIN_VALUE);
        expected = Integer.MIN_VALUE;
        result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d\n", testName, expected, result);
        }

        testName = "test 4";
        test = "       785643     Fraser loves math";
        expected = 785643;
        result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d\n", testName, expected, result);
        }

        testName = "test 4";
        test = "+1";
        expected = 1;
        result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d\n", testName, expected, result);
        }
    }

    public static int atoi(String s){
        // strip leading white space
        s = s.stripLeading();
        // set initial values
        int result = 0;
        boolean isNeg = false;
        int index = 0;
        int limitValue = Integer.MAX_VALUE/10;
        // test first char is '+' or '-'
        if (s.length() > 0){
            if (s.charAt(0) == '-'){
                isNeg = true;
                limitValue = Integer.MIN_VALUE/10;
                index++;
            } else if (s.charAt(0) == '+'){
                index++;
            }
        }
        // iterate through
        while (index < s.length()){
            if (! isDigit(s.charAt(index))){
                return result;
            }
            int digit = Character.getNumericValue(s.charAt(index));
            // can we add digit?
            // we cannot multiply by 10
            if (result < limitValue && isNeg){
                System.out.printf("Return MINVALUE with result: %d and digit %d\n", result,digit);
                return Integer.MIN_VALUE;
            }
            // we cannot multiply and add the digit
            if (result == limitValue && digit > 7 && isNeg){
                return Integer.MIN_VALUE;
            }
            //cannot multiply by 10
            if (result > limitValue && !isNeg){
                return Integer.MAX_VALUE;
            }
            // cannot multiply by 10 and add digit
            if (result == limitValue && digit > 7 && !isNeg){
                return Integer.MAX_VALUE;
            }

            result = result*10;
            if (isNeg){
                result -= digit;
            } else {
                result += digit;
            }
            index++;
        }

        return result;
    }

    public static boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
