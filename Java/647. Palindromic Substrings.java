class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int res =0;
        for(int i =0; i< s.length();i++){
            res += countPalind(s,i,i);             //palindrom substring length is odd, so center will be single letter
            res += countPalind(s,i,i+1);       //palindrom substring length is even, center will be two letters
        }
        return res;        
    }
    
    public int countPalind(String s, int left,int right){
        int count =0;
        //lef move to left dir，right run to more right, check s[left-1, right+1] is palindrom
        while(left >=0 && right < s.length() && s.charAt(left)== s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}