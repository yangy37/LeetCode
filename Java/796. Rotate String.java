class Solution {
    public boolean rotateString(String A, String B) {
        int i=0;
        if(A.equals("") && B.equals(""))
            return true;
        while(i<A.length())
        {
            A=shift(A);
            if(A.equals(B))
                return true;
            i++;
        }
        return false;
    }
	
    public String shift(String s) {
        StringBuilder str=new StringBuilder(s);
        char c = str.charAt(0);
        str.deleteCharAt(0);
            str.append(c);
        return str.toString();
    }
}