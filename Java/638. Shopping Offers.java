class Solution {
   public int shoppingOffers(List<Integer> p, List<List<Integer>> s, List<Integer> n) {
       return get(p,s,n,0);                                             //initalizing the recursive function
   }
   public int get(List<Integer> p, List<List<Integer>> s, List<Integer> n, int a){
       int c=direct(n,p);                   
       for (int i=a;i<s.size();i++){ 
           List<Integer> l=s.get(i);                                   //storing all the special values
           List<Integer> temp=new ArrayList<>();   
           for (int j=0;j<n.size();j++){ 
               if (n.get(j)<l.get(j)){                                 //if value of l is greater then value of need array put null
                   temp=null;
                   break;
               }
               temp.add(n.get(j)-l.get(j));                            //else add the sub value to new need for next recursion
           }
           if (temp!=null){                                  
               c=Math.min(c,l.get(l.size()-1)+get(p,s,temp,i));        //getting the min cost   
           }
       }
       return c;
   }
   public int direct(List<Integer>n, List<Integer>p){                  //getting the value without offer 
       int t=0;
       for (int i=0;i<n.size();i++){
           t+=p.get(i)*n.get(i);
       }
       return t;
   }
}