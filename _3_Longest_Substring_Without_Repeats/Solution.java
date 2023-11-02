public class Solution {
    public static void main(String args[]){
        String t1 = "abcabcbb";
        int result = longestSub(t1);
        int expected = 3;
        if (result != expected){
            System.err.println("Error in test 1! Should return "+ String.valueOf(expected) + " but returned: "+ String.valueOf(result));
        }

        String t2 = "bbbb";
        result = longestSub(t2);
        expected = 1;
        if (result != expected){
            System.err.println("Error in test 2! Should return "+ String.valueOf(expected) + " but returned: "+ String.valueOf(result));
        }

        String t3 = "pwwkew";
        result = longestSub(t3);
        expected = 3;
        if (result != expected){
            System.err.println("Error in test 3! Should return "+ String.valueOf(expected) + " but returned: "+ String.valueOf(result));
        }
    }

    public static int longestSub(String s){
        if (s.length()==0){
            return 0;
        }
        int longest = 1;
        char[] sArray = s.toCharArray();
        int start = 0;
        int end = 1;
        for (int j=1; j< sArray.length; j++){
            // check if next char is in current longest
            for (int i=start;i < end; i++){
                // if true, then next char is already in subString
                if (sArray[i] == sArray[j]){
                    // longest should be the longest substring seen so far or the current length of the substring
                    longest = Math.max(longest, end-start);
                    // strat should be one past the first occurance
                    // the end should be j, then is index below
                    start = i+1;
                    end = j;
                    break;
                }
            }
            // char not in array
            end+=1;
        }
        longest = Math.max(longest, end-start);

        return longest;
    }
}
