class Solution {
    private static final int MOD = 1000000007;
    
    public int numTilings(int n) {
        int[] complete = new int[n + 2];
        int[] incomplete = new int[n + 2];
        complete[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            // transitions from complete prev column
            
            // use Y's to complete current column
            // XY
            // XY
            complete[i] += complete[i - 1];
            
            // use Y's and Z's to fill up current column (but skip from calc) and complete next column
            // XYY
            // XZZ
            complete[i + 1] += complete[i - 1];
            
            // use either (hence *2) Y's or Z's to fill up current column (but skip from calc) and leave next column incomplete
            // XYY and XZ
            // XY      XZZ
            incomplete[i + 1] += (complete[i - 1] * 2) % MOD;
            
            // transitions from incomplete current column
            
            // use Y's or Z's to fill up current incomplete column (but skip from calc) and complete next column
            // XY or ZZ
            // YY    XZ
            complete[i + 1] += incomplete[i];
            // use Y's or Z's to fill up current incomplete column (but skip from calc) and leave next column incomplete
            // X  or ZZ
            // YY    X
            incomplete[i + 1] += incomplete[i];
            
            // mods
            complete[i + 1] %= MOD;
            complete[i] %= MOD;
            incomplete[i + 1] %= MOD;
        }
        
        return complete[n];
    }
}