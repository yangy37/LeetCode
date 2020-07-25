class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
         }
        for(int i=0;i<nums.length;i++) {
            sum=sum-2*nums[i];
            if(sum==(-nums[i]))
                return i;
        }
    return -1;
    }
}