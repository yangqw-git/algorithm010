#### 学习笔记

##### 1.刷题技巧

1. 最大的误区是刷题只刷一遍

2. 刻意练习，五毒神掌(五遍刷题法)

3. 核心思想

   （1）升维

   （2）空间换时间

##### 2.复杂度分析

###### 2.1 复杂度表示

> 大O表示法(Big O notation)

常见的七种时间复杂度

```
O(1) : 常数复杂度(Constant Complexity)
O(log n) : 对数复杂度(Logarithmic Complexity)
O(n) : 线性时间复杂度(Linear Complexity)
O(n^2) : N平方(N square Complexity)
O(n^3) : N立方(N cubic Complexity)
O(2^n) : 指数(Exponential Growth)
O(n!) : 阶乘(Factorial)
```

主定理

| **Algorithm**                                                | **Run time** |
| ------------------------------------------------------------ | ------------ |
| Binary search(二分搜寻算法)                                  | O(log n)     |
| Binary tree traversal(二叉树遍历)                            | O(n)         |
| Optimal sorted matrix search(最佳排序矩阵搜索(已排好序的二维矩阵)) | O(n)         |
| Merge sort(合并排序)                                         | O(nlog n)    |

##### 3. 栈和队列

###### 3.1 栈(Stack)

> 实际工程中使用建议使用`Deque`

```
1.push(E item) 添加元素
2.pop() 弹出元素
3.peek() 查看栈顶元素
```

###### 3.2 队列(Queue)

|             | *Throws exception* | *Returns special value* |
| ----------- | ------------------ | ----------------------- |
| **Insert**  | add(e)             | offer(e)                |
| **Remove**  | remove()           | poll()                  |
| **Examine** | element()          | peek()                  |

###### 3.3 双端队列(Deque)

|             | **(Head)**         | **(Head)**      | **(Tail)**         | **(Tail)**      |
| ----------- | ------------------ | --------------- | ------------------ | --------------- |
|             | *Throws exception* | *Special value* | *Throws exception* | *Special value* |
| **Insert**  | addFirst(e)        | offerFirst(e)   | addLast(e)         | offerLast(e)    |
| **Remove**  | removeFirst()      | pollFirst()     | removeLast()       | pollLast()      |
| **Examine** | getFirst()         | peekFirst()     | getLast()          | peekLast()      |

###### 3.4 优先队列(PriorityQueue)

> 底层原理是大顶堆，用数组实现

内部属性：

```
Object[] queue; 队列(数组表示的堆)
Comparator comparator;比较器
```

插入(offer/add)：

```
1.校验数组长度，如果满了则扩容；
	数组长度小于64时，扩容一倍；否则扩容0.5倍；
2.增加元素个数；
3.将元素放到队尾，然后上浮调整堆；
```

弹出元素(poll):

```
1.取出第一个元素；
2.减少元素个数，取出最后一个元素，最后一位置为null；
3.将最后一个元素放到第一位，然后下浮调整堆；
```

删除元素(remove);

```
1.找到删除元素的下标；
2.如果是末尾元素直接删除；
3.减少元素个数size；
4.将末尾元素放到删除元素下标处，然后下沉调整堆；
```













