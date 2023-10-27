import java.util.Queue;

class Solution {
    public int nums[];
    public static void main(String[] args){
        int t1[] = new int[]{1,1,1,1};
        Solution t1Class = new Solution();
        System.out.println(t1Class.canJump(t1));

        int t2[] = new int[]{1,1,0,1};
        Solution t2Class = new Solution();
        System.out.println(t1Class.canJump(t2));
    }
    public boolean canJump(int[] nums) {
        this.nums = nums;
        return jumpHelper(0);
    }

    public boolean jumpHelper(int i){
        if (i == nums.length-1){
            return true;
        } else if (i >= nums.length){
            return false;
        } else {
            if (nums[i] == -1){
                return false;
            } else {
                for (int j = 1; j <= nums[i]; j++){
                    if (jumpHelper(i+j)){
                        return true;
                    }
                }
                nums[i] = -1;
                return false;
            }
        }
    }

}