class LRUCache {
    class Node {
        Node next, prev;
        int key, val;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        // now this page is most recently used, 
        // delete previous occurence and add it after head
        Node temp = map.get(key);
        deleteNode(temp);
        insertNode(temp);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            deleteNode(temp);
        }
        else if(map.size() == capacity) {
            int target = tail.prev.key;
            deleteNode(map.get(target));
            map.remove(target);
        }
        insertNode(newNode);
        map.put(key, newNode);
    }
    
    public void deleteNode(Node x) {
        Node y = x.next;
        y.prev = x.prev;
        y.prev.next = y;
    }
    
    public void insertNode(Node x) {
        x.next = head.next;
        head.next = x;
        x.next.prev = x;
        x.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */