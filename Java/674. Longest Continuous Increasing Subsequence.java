class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        for (int right = 0, left = 0; right < nums.length - 1; ) {
            if (nums[right] >= nums[right + 1]) {
                left = right + 1;
            }
            right++;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}