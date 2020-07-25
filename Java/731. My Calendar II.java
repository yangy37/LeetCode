class MyCalendarTwo {
    TreeMap<Integer,Integer> calendar;
    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendar.put(start,calendar.getOrDefault(start,0)+1);
        calendar.put(end,calendar.getOrDefault(end,0)-1);
        int events = 0;
        for(int freq:calendar.values()) {
            events += freq;
            if(events>2) {
                calendar.put(start,calendar.get(start)-1);
                calendar.put(end,calendar.get(end)+1);
                return false;
            }
        }
        
        return true;
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */