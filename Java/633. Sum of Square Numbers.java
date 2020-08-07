class Solution {
    public boolean judgeSquareSum(int c) {
        
        boolean twoInts = false;

        int part1 = 0; 
        int part2 = (int)Math.sqrt(c);
        
        while (part1 <= part2) {
            int sum = part1*part1 + part2*part2;
              if (sum == c) {
                twoInts = true;
                break;
            } else if (sum < c)
                part1++;
            else if (sum > c)
                part2--;
        }
      
        return twoInts;
    }
}