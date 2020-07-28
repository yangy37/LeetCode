class KthLargest {
    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int _k, int[] nums) {
        this.k=_k; q=new PriorityQueue<>();
        for(int i:nums) add(i);
    }

    public int add(int val) {
        if(q.size()<k) q.add(val);
        else if(q.peek()<val){q.poll(); q.add(val);}
        return q.peek();
    }   
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */