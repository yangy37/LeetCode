class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int product = 1;
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left <= i && product >= k) {
                product /= nums[left++];
            }
            answer += i - left + 1;
        }
        
        return answer;
    }
}