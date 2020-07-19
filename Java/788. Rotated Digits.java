class Solution {
    int dp[]=new int[10000+1];

    static boolean change[]={false, false, true, false, false, true, true, false, false, true};
    static boolean invalid[]={false, false, false, true, true, false, false, true, false, false};

    public int rotatedDigits(int n)  {
        if(n<=dp[0])
            return dp[n];
        else
        {
            for(int i=dp[0]+1;i<=n;i++)
            {
                dp[i]= dp[i-1]+ check(i);
            }
            dp[0]= n;
            return dp[n];
        }        
    }

    static int check(int n) {
        boolean one=false;
        while(n!=0)
        {
            if(invalid[n%10])
                return 0;
            else
            {
                if(change[n%10])
                    one=true;
            }
            n/=10;
        }

        if(one)
            return 1;
        return 0;
    }
}
