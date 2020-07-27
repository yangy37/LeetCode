class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        ListNode current = findPrev(index);
    
        return current.next.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        
        ListNode newNode = new ListNode(val);
        ListNode current = findPrev(index);
        // add this node
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) return;
        
        ListNode current = findPrev(index);
        current.next.prev = null;
        current.next.next.prev = current;
        ListNode temp = current.next.next;
        current.next.next = null;
        current.next = temp;
        size--;
    }
    
	// find the previous node of node at given index
    private ListNode findPrev(int index) {
        ListNode current;
        if (index < (size / 2)) {
            // iterate from head
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }       
        } else {
            // iterate from tail
            current = tail;
            for (int i = 0; i < (size - index); i++) {
                current = current.prev;
            }
            current = current.prev;
        }
        return current;
    }
}

class ListNode{
    int val;
    ListNode prev;
    ListNode next;
    
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */