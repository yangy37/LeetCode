class Solution {
    double memo[][][];
    double avg(int a[], int start, int end){
        int n = end-start;
        double sum = 0;
        for(int i=start;i<end;i++) sum += a[i];
        return sum/n;
    }
    double partition(int A[], int k, int start, int end){
        if(memo[start][end][k] != 0) return memo[start][end][k];
        double max = avg(A,start,end);
        if(k==1 || start>=end) return memo[start][end][k] = max;
        for(int i=start+1;i<end;i++){
           double left = avg(A,start,i);
           double right = partition(A,k-1,i,end);
           max = Math.max(left+right,max);
        }
        return memo[start][end][k] = max;
    }
    
    public double largestSumOfAverages(int[] A, int K) {
       memo = new double[A.length+1][A.length+1][K+1];
       return partition(A,K,0,A.length);
    }
}