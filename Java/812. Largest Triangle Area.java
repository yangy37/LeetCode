class Solution {
     public double largestTriangleArea(int[][] points) {
        double maxArea = Double.MIN_VALUE;
        
        for (int i = 0; i < points.length - 2; i++) 
            for (int j = i + 1; j < points.length - 1; j++)
                for (int k = j + 1; k < points.length; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];
                    
                    double area = 0.5 * (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1] - p1[0]*p3[1] - p3[0]*p2[1] - p2[0]*p1[1]);
                    maxArea = Math.max(Math.abs(area), maxArea);
                }
        
        return maxArea;
    }
}