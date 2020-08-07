class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[n];
        
        for (String log : logs) {
            
            int firstColon = log.indexOf(':');
            int id = toInt(log, 0, firstColon);
            
            int lastColon = log.lastIndexOf(':');
            int time = toInt(log, lastColon + 1, log.length());
            
            if (log.charAt(firstColon + 1) == 's') {
                
                if (!stack.isEmpty()) {
                    int[] f = stack.getFirst();
                    result[f[0]] += time - f[1];
                }
                
                stack.addFirst(new int[] {id, time});
                
            } else {
                
                result[id] += time - stack.removeFirst()[1] + 1;
                
                if (!stack.isEmpty()) {
                    int[] f = stack.getFirst();
                    // wake
                    f[1] = time + 1;
                }
            }
        }
        
        return result;
    }
    
    private int toInt(String s, int start, int end) {
        
        int result = 0;
        
        while (start < end) {
            result = result * 10 + s.charAt(start) - '0';
            start++;
        }
        
        return result;
    }
}