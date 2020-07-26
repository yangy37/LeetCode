class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        
        boolean oneBitChar = false;
        for(int i = 0; i<bits.length;i++){
            if(bits[i]!=0){
                i++;
                oneBitChar = false;
            } else {
                oneBitChar = true;
            }
        }
        return oneBitChar;
    }
}