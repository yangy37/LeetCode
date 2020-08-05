class Solution {
    public int minSteps(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 0;
        
        int gcd = gcd(n);
        
        return gcd == n ? n : minSteps(gcd) + n/gcd;
    }
    
    private int gcd(int n){
        if(n % 2 == 0)
            return n/2;
        else{
            for(int i = 3; i < n/2; i = i + 2){
                if(n % i == 0)
                    return n/i;
            }
            return n;
        }
    }
}