#### 学习笔记

##### 1. 深度优先搜索、广度优先搜索的实现和特性

###### 1.1 搜索(遍历)

```
- 每个节点都要访问一次
- 每个节点仅仅访问一次
- 对节点的访问顺序不限
	- 深度优先(DFS)
	- 广度优先(BFS)
- 其他搜索
	- 优先级优先(启发式搜索)
```

###### 1.2 深度优先遍历

- 递归代码模板

```python
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

- 非递归代码模板

```python
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 
	# other processing work 
	...
```



###### 1.3 广度优先遍历

- 代码模板

```python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```



>
>实战例题
>
>- [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description)（字节跳动、亚马逊、微软在半年内面试中考过）
>- [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description)
>- [括号生成](https://leetcode-cn.com/problems/generate-parentheses/#/description)（字节跳动、亚马逊、Facebook 在半年内面试中考过）
>- [在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description)（微软、亚马逊、Facebook 在半年内面试中考过）



##### 2. 贪心算法

###### 2.1 贪心算法Greedy

> 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优的选择，从而希望导致结果是全局最优的算法。
>
> 与动态规划的区别：
>
> 贪心算法对每个子问题做出局部最优选择后不能回退；
>
> 动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能(最优判断 + 回退)。
>
> 贪心算法可以解决的问题：
>
> 	- 求图中的最小生成树；
> 	- 求哈夫曼编码
>
> 实例：
>
> ​	[零钱兑换](https://leetcode-cn.com/problems/coin-change/) : 当硬币可选集合是互相可以整除时，可用贪心；
>
> ​	反例：可选集合：Coins=[ 10 , 9 , 1 ] , 拼接总数是18；最优的话是两个9，贪心的话是一个10,8个1.
>
> 贪心算法适用场景
>
> ​	问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解，这种子问题最优解称为最优子结构。



> 参考链接
>
> - [ coin change 题目](https://leetcode-cn.com/problems/coin-change/)
> - [动态规划定义](https://zh.wikipedia.org/wiki/动态规划)
>



##### 3. 二分查找

###### 3.1 二分查找前提

```
1.目标函数单调性(单调递增或单调递减)
2.存在上下界
3.能够通过索引访问
```

###### 3.2 代码模板

```python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```



> 参考链接
>
> - [二分查找代码模板](https://shimo.im/docs/xvIIfeEzWYEUdBPD/)
> - [ Fast InvSqrt() 扩展阅读](https://www.beyond3d.com/content/articles/8/)
>
> 实战例题
>
> - [ x 的平方根](https://leetcode-cn.com/problems/sqrtx/)（字节跳动、微软、亚马逊在半年内面试中考过）
> - [有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)（亚马逊在半年内面试中考过）

