class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=IntStream.of(nums).sum();
        if(sum%k!=0)
            return false;
        return canPartition(0,nums,new boolean[nums.length],k,0,sum/k);
    }
    
    public boolean canPartition(int start,int[] nums,boolean used[],int k,int cur,int target){
        if(k==1)
            return true;
        if(cur==target){
            return canPartition(0,nums,used,k-1,0,target);
        }
        for(int i=start;i<nums.length;i++){
            if(!used[i] && cur+nums[i]<=target){
                used[i]=true;
                if(canPartition(i+1,nums,used,k,cur+nums[i],target))
                    return true;
                used[i]=false;
            }
        }
        return false;
    }
}