class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i], freq = 1;
            while (!pq.isEmpty()) {
                int[] temp = pq.poll();
                if (temp[0] + 1 == nums[i]) {
                    freq = temp[1] + 1;
                    break;
                }
                else if (temp[0] + 1 < nums[i]) {
                    if (temp[1] < 3) return false;
                }
                else {
                    pq.offer(temp); 
                    break;
                }
            }
            pq.offer(new int[] {num, freq});
        }
        
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[1] < 3) return false;
        }
        return true;
    }
    
    private static class MyComparator implements Comparator<int[]> {
        public int compare(int[] arr1, int[] arr2) {
            if (arr1[0] != arr2[0]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        }
    }
}