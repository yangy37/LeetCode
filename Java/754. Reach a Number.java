class Solution {
    public int reachNumber(int T) {
        long sum=0;
        int step=1;
        if(T<0)T=-T;
        while(sum<T){
            sum+=step;
            step++;
        }
        while((sum-T)%2!=0){
            sum+=step;
            step++;
        }
        return step-1;
    }
}