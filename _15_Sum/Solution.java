import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public static void main(String args[]){
        int nums1[] = new int[]{-1, -1, -4, 2, 1, 0};
        System.out.println(threeSum(nums1).toString());

        int nums2[] = new int[]{0, 0, 0, 0, 0};
        System.out.println(threeSum(nums2).toString());

        int nums3[] = new int[]{1, 1, 1};
        System.out.println(threeSum(nums3).toString());

        int nums4[] = new int[]{7, 18, 22, 33, 0, -11, -17, 28, 100, 6, -2, -1, -13, 10, 16, 12, -10, -5, -3, 4};
        System.out.println(threeSum(nums4).toString());

        int nums5[] = new int[]{-1, -1, -1, -1, -1, -1, 2};
        System.out.println(threeSum(nums5).toString());
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        assert (nums.length>=3);
        // sort array first
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int a = 0;
        int b = 1;
        int c = nums.length-1;
        int aStop = c;
        int bStop = c;
        while (a <= c-2){
            b = a+1;
            c = aStop;
            while (b <= c-1){
                c = bStop;
                // System.out.printf("a: %d, b:%d, c: %d\n", a, b, c);
                while (nums[a] + nums[b] + nums[c] >= 0 && b < c){
                    if (nums[a] + nums[b] + nums[c] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        result.add(list);
                        break;
                    }
                    if (b-a == 1){
                        aStop = c;
                    }
                    bStop = c;
                    c--;
                }
                int bHold = b;
                while (nums[bHold] == nums[b] && b < bStop){
                    b++;
                }
            }
            bStop = aStop;
            int aHold = a;
            while (nums[aHold] == nums[a] && a < aStop){
                a++;
            }
        }

        return result;
    }


}
