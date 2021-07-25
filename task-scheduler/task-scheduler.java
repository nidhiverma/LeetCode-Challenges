class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int[] freq = new int[26];
        int maxFreq = 0;
        
        for(char task: tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task-'A']);
        }
        
        int tasksWithMaxFreq = 0;
        for(int f : freq) {
            if(f == maxFreq) {
                tasksWithMaxFreq++;
            }
        }
        
        return Math.max(tasks.length, (maxFreq-1) * (n+1) + tasksWithMaxFreq);
    }
}