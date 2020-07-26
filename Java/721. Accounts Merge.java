class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> emailAndName = new HashMap();
        HashMap<String, List<String>> emails = new HashMap();
        
        for (List<String> account: accounts) {
            for (int i=1;i<account.size();i++) {
                emailAndName.putIfAbsent(account.get(i), account.get(0));
                emails.putIfAbsent(account.get(i), new ArrayList<String>());
                for (int j=1;j<account.size();j++) {
                    if (i == j) continue;
                    emails.get(account.get(i)).add(account.get(j));
                }
            }
        }
        HashSet<String> visited = new HashSet();
        List<List<String>> res = new ArrayList();
        List<String> curr;
        for (String email : emails.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                curr = new ArrayList();
                Queue<String> q = new LinkedList();
                curr.add(email);
                q.offer(email);
                while (!q.isEmpty()) {
                    String c = q.poll();
                    for (String next: emails.get(c)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            curr.add(next);
                            q.offer(next);
                        }
                    }
                }
                Collections.sort(curr);
                curr.add(0, emailAndName.get(email));
                res.add(curr);
            }
        }
        return res;
    }
}