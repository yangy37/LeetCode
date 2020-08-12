class Solution {
     public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer max = 0;
        int[] values = {1, -1};
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                int oldCount = map.get(key);
                map.put(nums[i], oldCount + 1);
            } else map.put(key, 1);
            
            
            for (Integer val : values) {
                if (map.containsKey(key + val)) max = Math.max(max, map.get(key) + map.get(val + key));
            }
        }
        
        return max;
    }
}