class MyCircularDeque {

    class ListNode {
        int val;
        ListNode next, prev;
        
        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    int size;
    int capacity;
    ListNode head, tail;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = 0;
        capacity = k;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == capacity) return false;
        
        ListNode node = new ListNode(value);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
        
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == capacity) return false;
        
        ListNode node = new ListNode(value);
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
        size++;
        
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) return false;
        
        ListNode node = head.next;
        head.next = node.next;
        node.next.prev = head;
        size--;
        
        return true;
        
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) return false;
        
        ListNode node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        size--;
        
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0) return -1;
        return head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0) return -1;
        return tail.prev.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */