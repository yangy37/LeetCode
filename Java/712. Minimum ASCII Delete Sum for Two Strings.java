class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        int m = s1.length(), n=s2.length();
        int dp[][] = new int[m+1][n+1];
        
        for(int k =m-1;k>=0;k--){
            dp[k][n]= dp[k+1][n]+s1.charAt(k);
        }
        for(int k =n-1;k>=0;k--){
            dp[m][k]= dp[m][k+1]+s2.charAt(k);
        }
        
        for(int i =m-1; i>=0; i--){
            for(int j=n-1;j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j]= dp[i+1][j+1];
                }else{
                    dp[i][j]= Math.min(s2.charAt(j)+dp[i][j+1], s1.charAt(i)+dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
}