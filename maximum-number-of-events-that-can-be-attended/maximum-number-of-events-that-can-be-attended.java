/*
    Approach:
        Greedy Approach
        Sort events in increasing order of their start day.
        Maintain a priority queue of storing events end day in increasing order.
        Discard all the events which have expired.
        Add all the events starting at current day
        Attend events if there's any available in the priority queue.
        
        Time Complexity: O(n)     
        Space Complexity: O(n)  
        where n = events count
*/

/*

    1 2 3 4
    [1,2] [1 2] [2 3] [3 4]
    
    [1 2] --> [1 1]
    [1 2] --> [2 2]
    [2 3] --> [3 3]
    [3 4] --> [4 4]
    
    
    1 2 3 4
    [[1 1] [1,4] [2,2] [3,4] [4,4]]
    [1 1] --> [1 1]
    [1 4] --> [2 2]
    [2 2] --> -
    [3 4] --> [3 3]
    [4 4] --> [4 4]

*/

class Solution { 
    public int maxEvents(int[][] events) {
        int totalEvents = events.length;
        
        // sort jobs with increasing finishing time
        Arrays.sort(events, (e1, e2) -> e1[0]-e2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        int eventIndex = 0, count = 0;
        
        for(int day = 1; day <= 100000; day++) {
            // discard expired events
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            
            // add all the events that starts today
            while(eventIndex < totalEvents && events[eventIndex][0] == day) {
                pq.offer(events[eventIndex++][1]);
            }
            
            // attend event
            if(!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }
        
        return count;
    }
}