class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer>res=new ArrayList();
        helper(S,0,res);
        return res;
    }
    
    private boolean helper(String str,int pos,List<Integer>list) {
        if(pos==str.length()) {
            if(list.size()>2)
                return true;
            return false;
        }
        
         int num=0;
        for(int i=pos;i<str.length();i++) {
            num=num*10+(str.charAt(i)-'0');
            
            if(num<0)
                return false;
            if(list.size()<2||list.get(list.size()-1)+list.get(list.size()-2)==num) {
                list.add(num);
                if(helper(str,i+1,list))
                    return true;
                list.remove(list.size()-1);
            }
            
            if(i==pos&&str.charAt(i)=='0')
                return false;
        }
        return false;
    }
}