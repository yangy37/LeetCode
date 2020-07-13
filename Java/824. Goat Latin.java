class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split("\\W+");
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char cur = Character.toLowerCase(word.charAt(0));
            
            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                word += "m" + "a".repeat(i + 2);
            } else {
                word = word.substring(1) + word.substring(0, 1) + "m" + "a".repeat(i + 2);
            }
            
            words[i] = word;
        }

        return String.join(" ", words);
    }
}