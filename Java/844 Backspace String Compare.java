class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder strS = new StringBuilder();
        StringBuilder strT = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) != '#') strS.append(S.charAt(i));
            else if(strS.length() != 0) strS.deleteCharAt(strS.length() - 1);
        }
        for(int j = 0; j < T.length(); j++){
            if(T.charAt(j) != '#') strT.append(T.charAt(j));
            else if(strT.length() != 0) strT.deleteCharAt(strT.length() - 1);
        }
        return strS.toString().equals(strT.toString());
    }
}