class Solution {
    public int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0) return 0;
        
        int totalRabbits = 0;
        int[] map = new int[1000];
        for(int answer : answers){
            if(answer == 0){
                totalRabbits += 1;
                continue;
            }
            //if map doesn't contain anything or the answer given by any other rabbit has exhausted it's limit of having the same color
            if(map[answer] - 1 <= 0){
                totalRabbits += (answer + 1);
                map[answer] = answer + 1;
            } else {
                map[answer]--;
            }
        }        
        return totalRabbits;
    }
}