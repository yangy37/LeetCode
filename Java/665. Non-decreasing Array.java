class Solution {
     public boolean checkPossibility(int[] nums) {
        int n = nums.length, found = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (found > 0) return false;
                if (i + 1 < n && nums[i + 1] < nums[i - 1] //try increase i;
                    && i - 2 >= 0 && nums[i] < nums[i - 2]) return false;  // try decrease i - 1;
                found = i;
            }
        }
        return true;
    }
}