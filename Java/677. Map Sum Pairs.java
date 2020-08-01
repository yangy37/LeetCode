class MapSum {
    static class Trie {
        Map<Character, Trie> child;
        int sum;

        Trie(int num) {
            sum = num;
            child = new HashMap<>();
        }
    }


    Trie root;
    Map<String, Integer> map;
    boolean nullKey;
    int nullVal;

    boolean emptyKey;
    int emptyVal;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Trie(0);
        map = new HashMap<>();
    }

    public void insert(String key, int v) {
        if (key == null) {
            nullKey = true;
            nullVal = v;
            return;
        } else if (key.length() == 0) {
            emptyKey = true;
            emptyVal = v;
            return;
        }


        int val = v - map.getOrDefault(key, 0);
        map.put(key, v);

        Trie cur = root;

        for (char c : key.toCharArray()) {
            if (!cur.child.containsKey(c)) {
                cur.child.put(c, new Trie(val));
            } else {
                cur.child.get(c).sum += val;
            }
            cur = cur.child.get(c);
        }
    }

    public int sum(String prefix) {
        if (prefix == null) return nullKey ? nullVal : 0;
        if (prefix.length() == 0) return emptyKey ? emptyVal : 0;

        Trie cur = root;
        int ans = 0;
        for (char c : prefix.toCharArray()) {
            if (!cur.child.containsKey(c)) return 0;
            cur = cur.child.get(c);
            ans = cur.sum;
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */