class Solution {
    public String replaceWords(List<String> dict, String s) {
     HashSet<String> set = new HashSet();
        for(String str:dict) set.add(str);
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
           String word = arr[i];
            for(int j=0;j<word.length();j++){
                String pre = word.substring(0,j);
                if(set.contains(pre)){ arr[i] = pre; break;}
            }
            
            
            
        }
        String ans = arr[0];
        for(int i=1;i<arr.length;i++){
            ans = ans + " " + arr[i];
        }
        
        return ans;
        
    }
}