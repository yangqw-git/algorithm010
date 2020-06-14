

### 算法作业

1.移动零

> 双指针法：j 记录非零元素的个数，指向数组中第一个0的位置

```java
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1){
            return ;
        }
        for (int i = 0, j = 0; i < nums.length; i++){
            if (nums[i]  != 0){
                if (i != j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                } 
                j++;
            }
        }
    }
}
```

2.两数之和

> 解法一：暴力法

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
```

> 解法二：哈希法(将元素存到哈希表，降低查找元素的时间复杂度)

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer,Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            Integer j;
            if ((j = temp.get(res)) != null) {
                return new int[] { i, j };
            }
            temp.put(nums[i], i);
        }
        return null;
    }
}
```

3.设计循环双端队列

> 解法一：链表

```java
public class MyCircularDeque {

    private int size;
    private int capacity;

    private Node<Integer> head;
    private Node<Integer> tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if(k < 1) throw new IllegalArgumentException();
        this.capacity = k;
        this.head = new Node<Integer>(0);
        this.tail = new Node<Integer>(0);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.size == this.capacity){
            return false;
        }
        Node<Integer> n = new Node<Integer>(value);
        n.pre = this.head;
        n.next = this.head.next;
        this.head.next = n;
        n.next.pre = n;
        this.size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.size == this.capacity){
            return false;
        }
        Node<Integer> n = new Node<Integer>(value);
        n.pre = this.tail.pre;
        n.next = this.tail;
        this.tail.pre = n;
        n.pre.next = n;
        this.size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.size == 0){
            return false;
        }
        this.head.next = this.head.next.next;
        this.head.next.pre = this.head;
        this.size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.size == 0){
            return false;
        }
        this.tail.pre = this.tail.pre.pre;
        this.tail.pre.next = this.tail;
        this.size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        Node<Integer> f = this.head.next;
        return f == this.tail ? -1 : f.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        Node<Integer> r = this.tail.pre;
        return r == this.head ? -1 : r.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size == this.capacity;
    }
    class Node<T> {
        T value;
        Node<T> next;
        Node<T> pre;
        public Node(T value){
            this.value = value;
        }
    }

}
```

> 解法二 ：数组

```java
class MyCircularDeque {

    private int size;
    private int capacity;

    private int[] queue;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if(k < 1) throw new IllegalArgumentException();
        this.capacity = k;
        this.queue = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.size == this.capacity){
            return false;
        }
        if (this.size > 0){
            System.arraycopy(this.queue, 0, this.queue, 1, size);
        }
        this.queue[0] = value;
        this.size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.size == this.capacity){
            return false;
        }
        this.queue[size++] = value;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.size == 0){
            return false;
        }
        System.arraycopy(this.queue, 1, this.queue, 0, --size);
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.size == 0){
            return false;
        }
        this.size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return this.size == 0 ? -1 : this.queue[0];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return this.size == 0 ? -1 : this.queue[size - 1];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size == this.capacity;
    }

}
```

