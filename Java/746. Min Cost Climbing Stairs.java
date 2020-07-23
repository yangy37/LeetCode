class Solution {
    int[] cost;
    Integer[] memoization;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        memoization = new Integer[cost.length+1];
        return minStairN(cost.length);
    }
    
    public int minStairN(int n){
        if(n == 0||n==1)
            return 0;
        if(memoization[n] ==null)
            memoization[n]= 
            Math.min(minStairN(n-1)+cost[n-1],minStairN(n-2)+cost[n-2]);
        return memoization[n];
    }
}