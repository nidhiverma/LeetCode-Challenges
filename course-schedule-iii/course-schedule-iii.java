/*
    [[100,200],[200,1300],[1000,1250],[2000,3200]]
    [[100,200], [1000, 1250], [200, 1300], [2000, 3200]]
    0           100            1100         1300    3300  
    [[3,2] [4,3]]
    
    100, 200, 1000
*/

class Solution {
    
    
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> c1[1]-c2[1]);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int maxCoursesTaken = 0, completionDay = 0;
        
        for(int i = 0; i < courses.length; i++) {
            completionDay += courses[i][0];
            pq.offer(courses[i][0]);
            
            while(!pq.isEmpty() && completionDay > courses[i][1]) {
                completionDay -= pq.poll();
            }
            maxCoursesTaken = Math.max(maxCoursesTaken, pq.size());
        }
        
        return maxCoursesTaken;
    }
}