class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        boolean pos = true;
        int maxInd = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != max && !(nums[i] >= 2 * max || max >= 2 * nums[i])) {
                pos = false;
            }
            if(max < nums[i]) {
                maxInd = i;
                if(nums[i] >= 2 * max) {
                    pos = true;
                }
                max = nums[i];
            }
        }
        if(pos) return maxInd;
        return -1;
    }
}