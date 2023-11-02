package _8_Sting_to_Int;

public class Solution {
    public static void main(String args[]){
        String testName = "test 1";
        String test = "-1054";
        int expected = -1054;
        int result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d", testName, expected, result);
        }

        testName = "test 2";
        test = "1000000000000000000000000000";
        expected = Integer.MAX_VALUE;
        result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d", testName, expected, result);
        }

        testName = "test 3";
        test = String.valueOf(Integer.MIN_VALUE);
        expected = Integer.MIN_VALUE;
        result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d", testName, expected, result);
        }

        testName = "test 4";
        test = "       785643     Fraser loves math";
        expected = 785643;
        result = atoi(test);
        if (expected != result){
            System.err.printf("Error in %s. Expected: %d but got %d", testName, expected, result);
        }
    }

    public static int atoi(String s){
        return 0;
    }
}
