class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        double sum = 0D;
        double maxAvgSoFar = 0D;
        double maxAvg = -Double.MAX_VALUE;
        while(left<=right){
            sum+=nums[left++];
        }
        left = 0;
        right++;
        maxAvgSoFar = sum/k;
        maxAvg = Math.max(maxAvg, maxAvgSoFar);
        while(right<nums.length) {
            sum-=nums[left++];
            sum+=nums[right++];
            maxAvgSoFar = sum/k;
            maxAvg = Math.max(maxAvg, maxAvgSoFar);
        }
        return maxAvg;
    }
}
