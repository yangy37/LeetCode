class Solution {
     public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String input:paths) {
            String[] files = input.split(" |\\(");
            String dir = files[0];
            for(int i=1;i<files.length-1;i++) {
                map.putIfAbsent(files[i+1], new ArrayList<>());
                map.get(files[i+1]).add(dir+"/"+files[i]);
            }
        }
        return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());  
    }
}