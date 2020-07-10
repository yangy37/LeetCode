class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] arr = S.toCharArray();
        
        for(int i=shifts.length-1;i>=0;i--){
            if(i!=shifts.length-1)
              shifts[i]=shifts[i]+shifts[i+1];
            shifts[i]=shifts[i]%26;
        }
        
        for(int i=0;i<arr.length;i++){
            int temp = arr[i]-'a'+shifts[i];
            if(temp>=26)
                temp=temp-26;
            arr[i]=(char)('a'+ temp);
        }
        return new String(arr);
    }
}