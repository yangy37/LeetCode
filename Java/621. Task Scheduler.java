class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        if(tasks.length == 1) return 1;

        int[] arr = new int[26];
        int maxSum= 0;

        for(char t: tasks) {
            arr[t - 'A']++;
        }

        int maxCount = 0;
        int maxCt = 0;

        for(int i = 0; i < arr.length; i++) {
            maxSum += arr[i];
            if(arr[i] < maxCount) continue;
            maxCount = arr[i];
        }
        int total;

        for(int i = 0; i < arr.length; i++) if(maxCount == arr[i]) maxCt++;

        int maxGap = (maxCount - 1) * n;

        total = maxCount + maxGap;
        total += (maxCt - 1);
        maxSum -= (maxCt * maxCount);

        maxGap -= (maxCt - 1) * (maxCount - 1);
        if(maxSum > maxGap) maxSum -= maxGap;
        else maxSum = 0;

        total += maxSum;


        return total;
    }
}