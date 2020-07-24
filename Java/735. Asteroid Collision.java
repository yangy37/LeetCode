class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // answer list
        List<Integer> list = new ArrayList<>();
        // store all remainging positive values
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            boolean same = false;
            // collide with previous positive values
            while (i < 0 && !stack.isEmpty()) {
                int p = stack.pop();
                if (Math.abs(p) > Math.abs(i)) {
                    i = p;
                } else if (Math.abs(p) == Math.abs(i)) {
                    same = true;
                    break;
                }
            }
            // both exploded
            if (same) continue;
            // push positive value into stack or add negetive value to answer list
            if (i < 0) list.add(i);
            else stack.push(i);
        }
        int[] ans = new int[list.size() + stack.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        int j = ans.length - 1;
        while (!stack.isEmpty()) ans[j--] = stack.pop();
        return ans;
    }
}