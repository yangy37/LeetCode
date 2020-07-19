class Solution {
    
    List<String> list = new ArrayList<>();
    
    public void dfs(char[] chs, int index, List<String> list) {
        if (index == chs.length){
            list.add(String.valueOf(chs));
            return;    
        }
        
        if (Character.isDigit(chs[index])) {
            dfs(chs, index+1, list);
            return;
        }
        
        chs[index] = Character.toUpperCase(chs[index]);
        dfs(chs, index+1, list);
        
        chs[index] = Character.toLowerCase(chs[index]);
        dfs(chs, index+1, list);
    }
    
    public List<String> letterCasePermutation(String S) {
        if (S == null)
            return new ArrayList<>();
        
        char[] chs = S.toCharArray();
        
        int index = 0;
        dfs(chs, index, list);
        
        return list;
    }
}