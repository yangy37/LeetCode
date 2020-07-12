class Solution {
    public String findReplaceString(String S, int[] index, String[] sources, String[] targets) 
    {
        Map<Integer,Integer>mp=new HashMap<>();
        int i,j;
        StringBuilder sb=new StringBuilder();
        for(i=0;i<index.length;i++)
        {
            if(S.substring(index[i],index[i]+sources[i].length()).equals(sources[i])){
				mp.put(index[i],i);
			}
        }
        for(i=0;i<S.length();i++)
        {
            if(mp.containsKey(i))
            {
                sb.append(targets[mp.get(i)]);
                i+=sources[mp.get(i)].length()-1;
            }
            else
            {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}