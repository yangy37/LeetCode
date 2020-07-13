class Solution {

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int[] allProfit = new int[100000];
		int lOfJobs = difficulty.length;
		for(int i = 0; i < lOfJobs; i++) {
			if(profit[i] > allProfit[difficulty[i]]) {
				allProfit[difficulty[i]] = profit[i];
			}
		}
		
		int lOfAllProfit = allProfit.length;
		int max = allProfit[0];
		for(int i = 1; i < lOfAllProfit; i++) {
			max = Math.max(max, allProfit[i]);
			allProfit[i] = max;
		}
		
		int res = 0;
		int numOfWorker = worker.length;
		for(int i = 0; i < numOfWorker; i++) {
			res += allProfit[worker[i]];
		}
		return res;
	}
}