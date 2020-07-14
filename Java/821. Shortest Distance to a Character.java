class Solution {
    public int[] shortestToChar(String S, char C) {
        int strLen = S.length();
        int[] result = new int[strLen];
        if(S == null || strLen == 0) {
            return result;
		}
        
        int i = 0;
		//fill the array with max value
        Arrays.fill(result, Integer.MAX_VALUE);
        
		//run the while loop till string length
        while(i < strLen){
		//each time you find the character, to calculate the distance between that poisition and all other positions.
            if(S.charAt(i) == C){
                result[i] = 0;
                int j = 0;
				//looping to find the position distance from given char to rest
                while(j < strLen){
				//update the min distance, so that for new char we find the lowest distance.
                    result[j] = Math.min(result[j], Math.abs(i - j));
                    j++;
                }
            }
            i++;
        }
        return result;
    }
}