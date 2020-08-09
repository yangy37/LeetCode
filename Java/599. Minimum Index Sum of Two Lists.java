class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<list1.length;i++){
            
            map.put(list1[i],i);
            
        }
        
        int min=Integer.MAX_VALUE;
        
        List<String> answer=new ArrayList<>();
        
        for(int i=0;i<list2.length;i++){
            
            if(map.containsKey(list2[i])){
                
                int temp= map.get(list2[i])+i;
                
                if(min>temp){
                    
                    min=temp;
                    
                    answer.clear();
                    
                    answer.add(list2[i]);
                    
                }else if(min == temp){
                    answer.add(list2[i]);
                }
                
            }
             
        }
        
        return answer.toArray(new String[answer.size()]);
            
    }
}