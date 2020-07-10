class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        Arrays.sort(hand);  
        int[] buckets = new int[W];
        buckets[hand[0] % W]++;
        for (int i = 1; i < hand.length; i++) {
            if (i % W != 0 && hand[i] - hand[i-1] > 1) {
                return false;
            }
            buckets[hand[i] % W]++;
        }
        int count = buckets[0];
        for (int bucket: buckets) {
            if (bucket != count) {
                return false;
            }
        }
        return true;
    }
}