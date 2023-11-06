
public class Solution {
    public static void main(String args[]){
        int test = 3;
        int expected = 5;
        int result = uniqueTrees(test);
        if (expected != result){
            System.out.printf("Error with input %d. Expected: %d but got: %d", test, expected, result);
        }

        test = 4;
        expected = 14;
        result = uniqueTrees(test);
        if (expected != result){
            System.out.printf("Error with input %d. Expected: %d but got: %d", test, expected, result);
        }
    }

    public static int uniqueTrees(int n){
        // initialize array
        int values[] = new int[n+1];
        values[0] = 1;
        values[1] = 1;

        // calculate values of n from 2 to n and then return values[n]
        for (int i = 2; i <= n; i++){
            for (int j = 0; j < (i+1)/2; j++){
                if (j == i-1-j){
                    values[i] += values[j]*values[i-1-j];
                } else {
                    values[i] += values[j]*values[i-1-j]*2;
                }

            }
        }

        return values[n];
    }
}
