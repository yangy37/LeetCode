class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
		return !Arrays.stream(ghosts).anyMatch(g -> Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]) <= Math.abs(target[0]) + Math.abs(target[1]));
	}
}