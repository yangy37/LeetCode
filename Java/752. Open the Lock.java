class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> d = new HashSet<>();
        for(String s: deadends) {
            d.add(s);
        }
        if(d.contains("0000")) {
            return -1;
        }
        Deque<char[]> q = new ArrayDeque<>();
        q.offer(new char[]{'0', '0', '0', '0'});
        int ans = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            ans++;
            for(int i = 0; i < len; i++) {
                char[] c = q.poll();
                for(int j = 0; j < c.length; j++) {
                    char pre = c[j];
                    c[j] = pre + 1 > '9' ? '0' : (char)(pre + 1);
                    String s1 = new String(c);
                    c[j] = pre - 1 < '0' ? '9' : (char)(pre - 1);
                    String s2 = new String(c);
                    c[j] = pre;
                    if(s1.equals(target) || s2.equals(target)) {
                        return ans;
                    }
                    if(d.add(s1)) q.offer(s1.toCharArray());
                    if(d.add(s2)) q.offer(s2.toCharArray());
                }
            }
        }
        return -1;
    }
}