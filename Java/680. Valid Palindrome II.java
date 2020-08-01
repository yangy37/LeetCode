class Solution {
    public boolean validPalindrome(String s) {
        
        int length = s.length();
        
        int start = 0;
        int end = length - 1;
        
        boolean excuse = true;
                
        // Middle character doesn't matter
        while (start < length / 2) {
            
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            
            if (c1 == c2) {
                start++;
                end--;
            } else {
                if (!excuse) {
                    return false;
                }
                
                if (end - start == 1) return true;
                
                // Decide which pointer to increment
				// Edge case:  Check the next two chars or fails eg., "cuppucu"
                if (s.charAt(start + 1) == c2 && s.charAt(start + 2) == s.charAt(end - 1)) {
                    start++;
                } else if (c1 == s.charAt(end - 1) && s.charAt(start + 1) == s.charAt(end - 2)) {
                    end--;
                } else {
                    return false;
                }
                
			    excuse = false;
            }    
        }
        return true;
    }
}