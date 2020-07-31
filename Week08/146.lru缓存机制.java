/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (49.44%)
 * Likes:    782
 * Dislikes: 0
 * Total Accepted:    85.3K
 * Total Submissions: 170.4K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 
 * 
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */

// @lc code=start
class LRUCache {

    private HashMap<Integer, Node<Integer, Integer>> map;
    private Node<Integer, Integer> head;
    private Node<Integer, Integer> tail;
    private int capacity;

    public class Node<K,V>{
        public K key;
        public V value;
        public Node<K,V> pre;
        public Node<K,V> next;
        public Node(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node<>(-1,-1);
        this.tail = new Node<>(-1,-1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        LinkedHashMap map;
        Node<Integer, Integer> node = this.getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node<Integer, Integer> node = this.getNode(key);
        if (node == null) {
            if (this.map.size() == this.capacity) {
                this.map.remove(tail.pre.key);
                this.removeNode(tail.pre);
            }
            node = new Node<>(key, value);
            this.insertFirst(node);
            this.map.put(key, node);
        } else {
            node.value = value;
        }
    }

    private Node<Integer, Integer> getNode(int key) {
        Node<Integer, Integer> node = this.map.get(key);
        if (node == null) {
            return null;
        }
        this.removeNode(node);
        this.insertFirst(node);
        return node;
    }

    private void removeNode(Node<Integer, Integer> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void insertFirst(Node<Integer, Integer> node) {
        node.pre = head;
        node.next = head.next;
        node.pre.next = node;
        node.next.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

