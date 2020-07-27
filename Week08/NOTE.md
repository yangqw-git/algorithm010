## 学习笔记

### 1. 位运算

#### 1.1 位运算基础

> 又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串，所以经常被搜索引擎系统用于文本词频统计。
>
> 优点：最大限度的减少无谓的字符串比较，查找效率比哈希表高。

**基本性质**

1. 结点本身不存完整单词；
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串；
3. 每个结点的所有子结点路径代表的字符都不相同。



**N皇后位运算示例代码**

```java
class Solution {
	private int size; 
	private int count;
	private void solve(int row, int ld, int rd) { 
		if (row == size) { 
			count++; 
			return; 
		}
		int pos = size & (~(row | ld | rd)); 
		while (pos != 0) { 
			int p = pos & (-pos); 
			pos -= p; // pos &= pos - 1; 
			solve(row | p, (ld | p) << 1, (rd | p) >> 1); 
		} 
	} 
	public int totalNQueens(int n) { 
		count = 0; 
		size = (1 << n) - 1; 
		solve(0, 0, 0); 
		return count; 
  } 
}
```





> **参考链接**
>
> - [如何从十进制转换为二进制](https://zh.wikihow.com/从十进制转换为二进制)
> - [N 皇后位运算代码示例](https://shimo.im/docs/YzWa5ZZrZPYWahK2)
>
> **实战例题**
>
> - [位 1 的个数](https://leetcode-cn.com/problems/number-of-1-bits/)（Facebook、苹果在半年内面试中考过）
> - [ 2 的幂](https://leetcode-cn.com/problems/power-of-two/)（谷歌、亚马逊、苹果在半年内面试中考过）
> - [颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/)（苹果在半年内面试中考过）
> - [ N 皇后](https://leetcode-cn.com/problems/n-queens/description/)（字节跳动、亚马逊、百度在半年内面试中考过）
> - [ N 皇后 II ](https://leetcode-cn.com/problems/n-queens-ii/description/)（亚马逊在半年内面试中考过）
> - [比特位计数](https://leetcode-cn.com/problems/counting-bits/description/)（字节跳动、Facebook、MathWorks 在半年内面试中考过）

### 2. 布隆过滤器



> **参考链接**
>
> - [布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)
> - [使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)
> - [布隆过滤器 Python 代码示例](https://shimo.im/docs/UITYMj1eK88JCJTH)
> - [布隆过滤器 Python 实现示例](https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/)
> - [高性能布隆过滤器 Python 实现示例](https://github.com/jhgg/pybloof)
> - [布隆过滤器 Java 实现示例 1 ](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)
> - [布隆过滤器 Java 实现示例 2 ](https://github.com/Baqend/Orestes-Bloomfilter)

### 3. LRU缓存



> **参考链接**
>
> - [ Understanding the Meltdown exploit ](https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/)
> - [替换算法总揽](https://en.wikipedia.org/wiki/Cache_replacement_policies)
> - [ LRU Cache Python 代码示例](https://shimo.im/docs/CoyPAyXooGcDuLQo)
>
> **实战例题**
>
> - [LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/#/)（亚马逊、字节跳动、Facebook、微软在半年内面试中常考）

### 4. 排序算法



> **参考链接**
>
> - [十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)
> - [快速排序代码示例](https://shimo.im/docs/TX9bDbSC7C0CR5XO)
> - [归并排序代码示例](https://shimo.im/docs/sDXxjjiKf3gLVVAU)
> - [堆排序代码示例](https://shimo.im/docs/M2xfacKvwzAykhz6)
> - [ 9 种经典排序算法可视化动画](https://www.bilibili.com/video/av25136272)
> - [ 6 分钟看完 15 种排序算法动画展示](https://www.bilibili.com/video/av63851336)
>
> **实战例题**
>
> - [数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/)（谷歌在半年内面试中考过）
> - [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)（Facebook、亚马逊、谷歌在半年内面试中考过）
> - [力扣排行榜](https://leetcode-cn.com/problems/design-a-leaderboard/)（Bloomberg 在半年内面试中考过）
> - [合并区间](https://leetcode-cn.com/problems/merge-intervals/)（Facebook、字节跳动、亚马逊在半年内面试中常考）
> - [翻转对](https://leetcode-cn.com/problems/reverse-pairs/)（字节跳动在半年内面试中考过）