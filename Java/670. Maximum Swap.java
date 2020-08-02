class Solution {
    public int maximumSwap(int num) {
        int max = -1;
        int index = 0;
        
        char[] nums = Integer.toString(num).toCharArray();
        
        for(int i=0;i< nums.length; i++){
            for(int j= nums.length-1; j > i; j--){
                if( (nums[j]-'0') > (nums[i] - '0')){
                    if((nums[j]-'0') > max){
                        max = nums[j]-'0'; 
                        index = j;
                    }
                }
            }
            if(max != -1){
                char tmp = nums[i];
                nums[i] = (char)(max + '0');
                nums[index] = tmp;
                return Integer.valueOf(new String(nums)); 
            }
        }
        
        return num;
    }
}