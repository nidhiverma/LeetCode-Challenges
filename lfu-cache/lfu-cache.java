class LFUCache {
    class DLLNode {
        DLLNode next, prev;
        int key, val, freq;
        
        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    
    class DoublyLinkedList {
        int size;
        DLLNode head;
        DLLNode tail;
        
        public DoublyLinkedList() {
            this.size = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void insertNode(DLLNode node) {
            node.next = head.next;
            head.next = node;
            node.prev = head;
            node.next.prev = node;
            size++;
        }

        public void removeNode(DLLNode node) {
            DLLNode nextNode = node.next;
            DLLNode prevNode = node.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

    }
    
    Map<Integer, DLLNode> cache;
    Map<Integer, DoublyLinkedList> frequencyMap;
    int capacity, leastFrequency, size;
    
    
    public LFUCache(int capacity) {
        cache = new HashMap();
        frequencyMap = new HashMap();
        this.capacity = capacity;
        this.leastFrequency = 0;
        this.size = size;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        
        DLLNode temp = cache.get(key);
        updateNode(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        DLLNode node = new DLLNode(key, value);
        
        if(cache.containsKey(key)) {
            cache.get(key).val = value;
            updateNode(cache.get(key));
        }
        else {
            if(size == capacity) {
                DoublyLinkedList list = frequencyMap.get(leastFrequency);
                DLLNode lastNode = list.tail.prev;
               
                removeFromFrequency(lastNode, lastNode.freq);
                cache.remove(lastNode.key);
                insertAtFrequency(node, 1);
            }
            else {
                insertAtFrequency(node, 1);
                cache.put(key, node);
                size++;
            }
            leastFrequency = 1;
        }
    }
  
    
    /** update node frequency and corresponding position in frequency map **/
    private void updateNode(DLLNode x) {
        removeFromFrequency(x, x.freq);
        x.freq += 1;
        insertAtFrequency(x, x.freq);
    }
    
    /** delete node from its frequency list **/
    private void removeFromFrequency(DLLNode x, int freq) {
        DoublyLinkedList currList = frequencyMap.get(freq);
        currList.removeNode(x);
        cache.remove(x.key);
    
        if(x.freq == leastFrequency && currList.size == 0) {
            frequencyMap.remove(freq);
            leastFrequency++;
        }
    }
    
    /** insert node in new frequency list **/
    private void insertAtFrequency(DLLNode x, int freq) {
        frequencyMap.putIfAbsent(freq, new DoublyLinkedList());
        DoublyLinkedList currList = frequencyMap.get(freq);
        frequencyMap.get(freq).insertNode(x);
        
        DLLNode curr = currList.head;
        cache.put(x.key, x);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */