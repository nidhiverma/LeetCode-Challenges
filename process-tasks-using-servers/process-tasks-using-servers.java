class Solution {
    class Server {
        int weight;
        int index;
        int freeTime;
        
        public Server(int weight, int index, int freeTime) {
            this.weight = weight;
            this.index = index;
            this.freeTime = freeTime;
        }
        
        public Server(Server server, int freeTime) {
            this.weight = server.weight;
            this.index = server.index;
            this.freeTime = freeTime;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<Server> ready = new PriorityQueue<>((a, b) -> a.weight == b.weight ? a.index - b.index : a.weight - b.weight);
        PriorityQueue<Server> waiting = new PriorityQueue<>((a, b) -> a.freeTime == b.freeTime ? a.weight == b.weight ? a.index - b.index : a.weight - b.weight : a.freeTime - b.freeTime);
        
        for(int k = 0; k < servers.length; k++) {
            Server server = new Server(servers[k], k, 0);
            ready.offer(server);
        }
        
        int j = 0;
        
        int[] allotedServers = new int[tasks.length];
        
        while(j < tasks.length) {
            while(!waiting.isEmpty() && waiting.peek().freeTime <= j) {
                ready.offer(waiting.poll());
            }
            
            Server s;
            
            if(!ready.isEmpty())  {
                s = ready.poll();
                s.freeTime = j+tasks[j];
            }
            else {
                s = waiting.poll();
                s.freeTime += tasks[j];
           }
           allotedServers[j] = s.index;
           waiting.offer(s); 
           j++;
        }
        return allotedServers;
    }
}