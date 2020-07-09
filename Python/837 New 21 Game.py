class Solution:
    def new21Game(self, N: int, K: int, W: int) -> float:
        # use a deque and tot to track sum of next W dp values
        q = deque([i<=N for i in range(K, K+W)])
        tot = sum(q)
        # from K+W-1
        # the last one we can draw is K-1
        for _ in range(K-1,-1,-1):
            q.appendleft(tot/W)
            tot += q[0] - q.pop()
        return q[0]