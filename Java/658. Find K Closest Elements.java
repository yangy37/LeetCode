class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int closest = binarySearchClosest(arr,x);
        //Keep the high and low pointer on the same colsest index
        int high = closest;
        int low = closest;
        
        //from the cloest index exapand on both side of the array to find K closest elements
        while(high - low +1 < k && low > 0 && high < arr.length -1){
            if(Math.abs(arr[low - 1] - x) <= Math.abs(arr[high + 1] - x)){
                low--;
            }else{
                high++; 
            }
        }
        
        //If still both indices doesn't add up to K adjust the indices
        while(high - low + 1 < k){
           if(low > 0){
               low--; 
            }else{
               high++;  
            }
        }
      
        //Go from low to high and add to the answer list, since we've been asked to maintain order
        while(low <= high){
            ans.add(arr[low]);
            low++;
        }
      return ans;  
    }
    
   //Find the cloest element to x in the array,Just a regular binary search  and return it's index
   private int binarySearchClosest(int[]arr,int x){
       
       int closest = -1;
       int minDiff = Integer.MAX_VALUE;
       int low = 0;
       int high = arr.length - 1;
       
       while(low <= high){
           
           int mid = low + (high - low)/2;
           //Maintain minDiff to find the cloest 
           if(Math.abs(arr[mid] - x) < minDiff){
               minDiff = Math.abs(arr[mid]-x);
               closest = mid;
           }
           if(arr[mid] == x){
               return mid;
           }else if(arr[mid] > x){
               high = mid - 1;
           }else{
               low = mid + 1;
           }
           
       }
    return closest;   
   } 
    
}