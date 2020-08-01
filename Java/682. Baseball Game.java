class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> stack=new LinkedList();
        int sum=0;
        for(String op:ops){
            if(op.matches("^-?\\d+")){
               stack.push(Integer.parseInt(op));
               sum+=stack.peek();
            }
            if(op.equals("+")){
               Integer last=stack.pop();
               if(last!=null){
                  int curr=last.intValue();
                  curr+=stack.peek()!=null?stack.peek():0; 
                  stack.push(last);
                  stack.push(curr);
                  sum+=stack.peek(); 
               } 
            }
            if(op.equals("D")){
               stack.push(stack.peek()!=null?2*stack.peek():0);
               sum+=stack.peek();  
            }
            if(op.equals("C")){
               sum-=stack.peek()!=null?stack.pop():0; 
            }
        }//~
        
        return sum;
    }
}