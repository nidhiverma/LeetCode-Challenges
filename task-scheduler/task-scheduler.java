class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int[] freq = new int[26];
        int maxFreq = 0;
        
        for(char task: tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(freq[task-'A'], maxFreq);
        }
        
        Arrays.sort(freq);
        int idleTime = (freq[25] - 1) * n;
        
        for(int i = 24; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(freq[i], maxFreq-1);
        }
        idleTime = Math.max(0, idleTime);
        return idleTime + tasks.length;
    }
}