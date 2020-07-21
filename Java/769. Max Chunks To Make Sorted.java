class Solution {
    public int maxChunksToSorted(int[] arr) {
        int sum = 0;
        int numChunks = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i] - i;
            numChunks += sum == 0 ? 1 : 0;
        }
        return numChunks;
    }
}