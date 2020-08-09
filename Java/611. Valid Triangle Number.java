class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int max = -1;
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            //values >= nums[i] starts at i, lesser values prior this index
            if (!m.containsKey(nums[i])) { 
                for (int j = max + 1; j <= nums[i]; j++) {
                    m.put(j, i);
                }
                max = nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {
                int sum = nums[i] + nums[j];
                Integer endindex = m.get(sum);
                int temp = res;
                if (endindex != null) {
                    res += Math.max(0, endindex - (j+1));
                } else {
                    res += Math.max(0, nums.length - (j+1));
                }
            }
        }
        return res;
    }
}