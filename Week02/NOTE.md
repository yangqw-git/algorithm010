#### 学习笔记

##### 1.哈希表

###### 1.1 HashMap

1. HashMap采用了数组+链表的数据结构
2. 哈希函数，在get，set时，根据哈希函数计算数组下标，当发生哈希碰撞时，通过链表的形式存储下一个节点
3. HashMap底层有一个entry数组，entry是HashMap的内部类，包含key，value，hash值和下一个节点next
4. 当链表长度超过阈值(THRESHOLD == 8)时，会把链表转化为红黑树，树元素个数小于6时，会把红黑树转回链表
5. HashMap初始化时，默认初始容量16，负载因子0.75
6. HashMap扩容时默认扩大一倍，且必须是2的N次幂
7. HashMap线程不安全，多线程环境下可能造成死循环，线程安全类ConcurrentHashMap

>参考链接
>
>- [ Java Set 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
>- [ Java Map 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)
>
>- [养成收藏精选代码的习惯（示例）](http://shimo.im/docs/R6g9WJV89QkHrDhr)
>
>相关题目
>
>- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)（亚马逊、Facebook、谷歌在半年内面试中考过）
>- [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)（亚马逊在半年内面试中常考）
>- [两数之和](https://leetcode-cn.com/problems/two-sum/description/)（亚马逊、字节跳动、谷歌、Facebook、苹果、微软、腾讯在半年内面试中常考）



##### 2.树，二叉树，二叉搜索树

###### 2.1 树(Tree)

> 树是一种二维的数据结构，是由根结点和若干棵子树构成的;
>
> 每个非空树都是有且只有一个根节点，且不能形成环；
>
> 链表是一种特殊的树，每个节点只有一个子节点。



###### 2.2 二叉树(Binary Tree)

> 每个节点中包含的子节点数不超过2

```
1.树的遍历
(1)前序遍历(Pre-order) : 跟-左-右
(2)中序遍历(In-order) : 左-跟-右
(3)后序遍历(Post-order) : 左-右-根
```



###### 2.3 二叉搜索树(Binary Search Tree)

> 二叉搜索树，也称有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树： 
>
> 1. 左子树上**所有结点**的值均小于它的根结点的值； 
> 2. 右子树上**所有结点**的值均大于它的根结点的值； 

```
1.验证二叉树时，除了验证左右子节点的值，还要考虑左子树和右子树的节点的值；
2.中序遍历是升序排列的；
3.查询，插入，删除时间复杂度都是O(logn);
```

> 相关链接
>
> - [二叉搜索树 Demo ](https://visualgo.net/zh/bst)
>
> - [树的遍历 Demo ](https://visualgo.net/zh/bst)
>
> 相关题目
>
> - [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)（亚马逊、微软、字节跳动在半年内面试中考过）
> - [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)（谷歌、微软、字节跳动在半年内面试中考过）
> - [ N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)（亚马逊在半年内面试中考过）
> - [ N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/)（亚马逊在半年内面试中考过）
> - [ N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

###### 2.4 堆(Heap)

> 定义 : 可以迅速找到一堆数中的最大值和最小值的数据结构；
>
> 根据根节点值可以分为大顶堆和小顶堆；
>
> 常见的堆实现 : 二叉堆，斐波那契堆

```
1.常见操作:
(1)findMax : O(1);
(2)deleteMax : O(logN);
(3)insert : O(logN) / O(1);
2.不同实现的比较:https://en.wikipedia.org/wiki/Heap_(data_structure)
3.二叉堆
(1)二叉堆并不等同于堆，只是堆的一种常见且简单的实现；但是并不是最优的实现；(优先队列)
(2)通过完全二叉树来实现，并且满足:
	- 是一颗完全二叉树(除了最下面一层不满，其他层节点都是满的)；
	- 树中任意节点的值 >= 其子节点的值；
(3)二叉堆一般通过 <数组> 来实现；
(4)根节点索引是0;
	- 左子节点的索引为(2*i+1);
	- 右子节点的索引为(2*i+2);
	- 父节点的索引为floor((i-1)/2);
(5)插入操作(logN)
	- 新元素先插入到堆的尾部
	- 依次向上调整(HeapifyUp)
(6)删除堆顶元素(logN)
	- 将堆尾元素替换到堆顶
	- 依次向下调整(HeapifyDown)
```

> 相关链接
>
> - 维基百科：堆（Heap）https://en.wikipedia.org/wiki/Heap_(data_structure)
> - 堆的实现代码：[ https://shimo.im/docs/Lw86vJzOGOMpWZz2/ ](https://shimo.im/docs/Lw86vJzOGOMpWZz2/)
>
> 相关题目
>
> - [最小的 k 个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)（字节跳动在半年内面试中考过）
> - [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)（亚马逊在半年内面试中常考）
>
> - HeapSort ：自学 [ https://www.geeksforgeeks.org/heap-sort/ ](https://www.geeksforgeeks.org/heap-sort/)
> - [丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)（字节跳动在半年内面试中考过）
> - [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)（亚马逊在半年内面试中常考）

###### 2.5 图(Graph)

> 定义：有点有边
>
> 图是一种具有多对多的逻辑关系的数据结构，树是特殊化的图

```
1.图的属性 Graph(V,E)
	- V-vertex:点
		- 度:入度和出度
		- 点与点之前是否连通
	- E-edge:边
		- 有向和无向
		- 权重
2.图的表示
	- 邻接矩阵
	- 邻接表
3.图的分类
	- 无向无权图
	- 有向无权图
	- 无向有权图
	- 有向有权图
4.算法
	- BFS
	- DFS
	！！注意要有visited[]
```

> 高级算法
>
> - 连通图个数：[ https://leetcode-cn.com/problems/number-of-islands/ ](https://leetcode-cn.com/problems/number-of-islands/)
> - 拓扑排序（Topological Sorting）：[ https://zhuanlan.zhihu.com/p/34871092 ](https://zhuanlan.zhihu.com/p/34871092)
> - 最短路径（Shortest Path）：Dijkstra [ https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158 ](https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158)
> - 最小生成树（Minimum Spanning Tree）：[ https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051 ](https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051)

