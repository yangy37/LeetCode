class Solution {
    public boolean isRectangleOverlap(int[] a, int[] b) {
        if (a[0] > b[0])
            return isRectangleOverlap(b, a);
        
        if (a[0] == b[0] && a[1] > b[1])
            return isRectangleOverlap(b, a);
        
        if (a[2] <= b[0]) {
            return false;
        }
        
        if (a[3] <= b[1]) {
            return false;
        }
        
        if (a[1] >= b[3]) {
            return false;
        }
        
        return true;
    }
}