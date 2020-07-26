class Solution {
    public List<String> removeComments(String[] source) {
        boolean block = false;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String str : source) {
            for (int i = 0; i < str.length(); i++) {
                if (block) {
                    if (str.charAt(i) == '*' && i + 1 < str.length() && str.charAt(i + 1) == '/' ) {
                        block = false;
                        i++;
                    }
                } else {
                    if (str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i + 1) == '*' ) {
                        block = true;
                        i++;
                    } else if (str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i + 1) == '/' ) {
                        break;
                    } else sb.append(str.charAt(i));
                }
            }
            if (!block && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}