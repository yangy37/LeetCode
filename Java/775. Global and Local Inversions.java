class Solution {
    public boolean isIdealPermutation(int[] A) {
        /*All local inversions are global inversions but vice versa is not true
        thus if difference between idx & value at idx (i.e. A[idx]) is greater than 1
        then its global inversion which is not local */
        
        for(int i=0;i<A.length;i++){
            if(Math.abs(i-A[i])>1)return false;
        }
        return true;
    }
}