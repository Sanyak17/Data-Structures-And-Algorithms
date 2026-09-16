class Node
{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int value) 
    {
            this.key = key;
            this.val= value;
    }

}
class LRUCache 
{
    Map<Integer,Node> map;
    int cap;
    Node tail;
    Node head;
    
    public LRUCache(int capacity) 
    {
        map=new HashMap<>();
        cap=capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) 
    {
        if(!map.containsKey(key))
        return -1;
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.val;
        
    }
    
    public void put(int key, int value) 
    {
        if (map.containsKey(key)) 
        {
            Node node = map.get(key);
            node.val= value;
            remove(node);
            addFirst(node);
        } 
        else 
        {
            if (map.size() == cap) 
            {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addFirst(newNode);
        }
    }
    public void remove(Node node) 
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void addFirst(Node node) 
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */