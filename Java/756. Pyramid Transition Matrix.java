class Solution {
    Map<String, List<String>> map = new HashMap<>();
    
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String str: allowed) {
            List<String> list = map.getOrDefault(str.substring(0, 2), new ArrayList<>());
            list.add(str.substring(2));
            map.put(str.substring(0, 2), list);
        }
        return doable(bottom);
    }
    
    private boolean doable(String bottom) {
        if(bottom.length() == 1) return true;
        List<String> list = new ArrayList<>();
        int l = 0;
        int r = 1;
        List<String> froms = new ArrayList<>();
        while(r < bottom.length()) {
            froms.add(bottom.substring(l, r + 1));
            l++;
            r++;
        }
        dfs(froms, 0, "", list);
        boolean res = false;
        for(String bot: list) {
            res = res || doable(bot);
        }
        return res;
    }
    
    private void dfs(List<String> list, int idx, String str, List<String> res) {
        if(idx >= list.size()) {res.add(str);return;}
        
        String from = list.get(idx);
        if(!map.containsKey(from)) return;
        List<String> tos = map.get(from);
        for(String to: tos) {
            dfs(list, idx + 1, str + to, res);
        }
    }
}