class Solution {
      public int[] findErrorNums(int[] nums) {
        int expected = (int) ( Math.pow(nums.length, 2) + nums.length ) / 2; // gausses property 
        int duplicate = 0, actualSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) duplicate = nums[i];
            set.add(nums[i]);
            actualSum += nums[i];
        }
        int differential =  expected - actualSum;
        return new int[] {duplicate, duplicate + differential};
    }
}