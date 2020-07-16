class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String k : words) {
            StringBuilder sb = new StringBuilder();
            for(int l = 0; l<k.length(); l++){
                char c = k.charAt(l);
                int temp = (int) c;
                temp = temp - 96;
                sb.append(code[temp-1]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}