class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> dist = new HashSet<>();
        Set<Pair<Integer, Integer>> points = new HashSet<>();
        
        
        points.add(new Pair(p1[0], p1[1]));
        points.add(new Pair(p2[0], p2[1]));
        points.add(new Pair(p3[0], p3[1]));
        points.add(new Pair(p4[0], p4[1]));
        
        dist.add(calc(p1, p2));
        dist.add(calc(p1, p3));
        dist.add(calc(p1, p4));
        dist.add(calc(p2, p3));
        dist.add(calc(p2, p4));
        dist.add(calc(p3, p4));
        
        return dist.size() == 2 && points.size() == 4;
    }
    
    private int calc(int[] p1, int[] p2)
    {
        int dx= Math.abs(p1[0] - p2[0]);
        int dy = Math.abs(p1[1] - p2[1]);
        
        return dx*dx + dy*dy;
    }
}