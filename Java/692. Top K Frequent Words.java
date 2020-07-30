class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        
        for (String word : words) {
            int frequency = wordFrequency.getOrDefault(word, 0) + 1;
            wordFrequency.put(word, frequency);
        }
        
        Queue<String> heap = new PriorityQueue<String>(new FrequencyComparator(wordFrequency));
        
        for (String word : wordFrequency.keySet()) {
            heap.add(word);
            
            if (heap.size() > k)
                heap.poll();
        }
        
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) result.add(heap.poll());
        Collections.reverse(result);
        return result;
    }
    
    private static class FrequencyComparator implements Comparator<String> {
        private Map<String, Integer> wordFrequency;
        
        public FrequencyComparator(Map<String, Integer> wordFrequency) {
            this.wordFrequency = wordFrequency;
        }
        
        @Override
        public int compare(String l, String r) {
            if (wordFrequency.get(l) == wordFrequency.get(r)) {
                return r.compareTo(l);
            }
            
            return Integer.compare(wordFrequency.get(l), wordFrequency.get(r));
        }
    }
}