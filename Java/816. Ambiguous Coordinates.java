class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> ambiguousCoordinates(String S) {
        S=S.substring(1,S.length()-1);
        for(int ind= 1;ind<S.length();ind++){
            String s1=S.substring(0,ind);
            String s2=S.substring(ind,S.length());
            List<String> l1=evaluate(s1);
            if(l1.isEmpty()) continue;
            List<String> l2=evaluate(s2);
            if(l2.isEmpty()) continue;
            merge(l1,l2);
            
        }
        return ans;
    }
    public List<String> evaluate(String s1){
        List<String> l1 = new ArrayList<>();
        boolean isZero=false;
            if(s1.charAt(0)=='0'){
                isZero=true;
            }
            if(s1.length()>1){
                int end=s1.length()-1;
                if(s1.charAt(end)=='0'){
                    end=0;
                }
                for(int i=1;i<=end;i++){
                    String temp1=s1.substring(0,i);
                    String temp2=s1.substring(i,end+1);
                    String res=temp1 +"."+temp2;
                    l1.add(res);
                    if(isZero) break;
                }
            }
            if(!isZero || s1.length()==1){
                l1.add(s1);
            }  
            return l1;
    }
    public void merge(List<String> l1,List<String> l2){
        String s="(";
        String e=")";
        for(String fir: l1){
            for(String sec: l2){
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(fir);
                sb.append(", ");
                sb.append(sec);
                sb.append(e);
                ans.add(sb.toString());
            }
        }
    }
}