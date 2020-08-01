## 学习笔记

### 1. 位运算

#### 1.1 位运算符

- 左移 （ << ）
- 右移 （ >> ）
- 或OR （ | ）
- 与AND （&）
- 取反NOT （ ～ ）
- 异或XOR （ ^ ）: 相同为0，不同为1

**异或骚操作**

- x ^ 0 = x
- x ^ 1s = ~x （1s表示全1，即1s = ~0）
- x ^ (~x) = 1s
- x ^ x = 0
- 交换：c = a^b, b = a^c, a = b^c
- a^b^c = a^(b^c) = (a^b)^c

**常用位运算**

1. 将 x 最右边的 n 位清零：x &  (~0 << n)

2. 获取 x 的第 n 位值（0 或者1）：(x >> n)  & 1

3. 获取 x 的第n 位的幂值：x & (1 <<n)

4. 仅将第 n 位置为1：x |  (1 << n)

5. 仅将第 n 位置为0：x & (~ (1 << n))

6. 将 x 最高位至第n 位（含）清零：x & ((1 << n) -1) 

7. 将第 n 位至第0 位（含）清零：x & (~ ((1 << (n + 1)) -1))

**位运算实战**

- 判断奇偶：x & 1== 1为基数，==0为偶数
- x 除以2：x >> 1
- 清零最低位的1：X = X & (X-1)
- 得到最低位的1：X & -X
- X & ~X = 0

**N皇后位运算示例代码**

```java
private int size;
private int count;

private void solve(int cols, int ld, int rd) {
    // 递归终止条件：列已经占满了
    if (cols == size) {
        count++;
        return;
    }
    // pos表示空余的位置
    int pos = size & (~(cols | ld | rd));
    // 遍历所有可用的位置
    while (pos != 0) {
        // 从右边开始，取得第一个可用的位置
        int p = pos & (-pos);
        // 将第一个位置删除，已使用
        pos -= p;
        // 递归调用下一行
        solve(cols | p, (ld | p) << 1, (rd | p) >> 1);
    }
}

public int totalNQueens(int n) {
    count = 0;
    size = (1 << n) - 1;
    solve(0, 0, 0);
    return count;
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

### 2. 布隆过滤器（Bloom Filter）

> ​		原理：一个很长的二进制向量（位图）和一系列随机映射函数组成，可用于检索一个元素是否在一个集合中。
>
> ​		优点：空间效率和查询时间都远远超过一般的算法；
>
> ​		缺点：存在一定的误识别率和删除困难；

**案例**

1. 比特币网络
2. 分布式系统（Map-Reduce） — Hadoop、search engine 
3. Redis缓存
4. 垃圾邮件、评论过滤



> **参考链接**
>
> - [布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)
> - [使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)
> - [布隆过滤器 Python 代码示例](https://shimo.im/docs/UITYMj1eK88JCJTH)
> - [布隆过滤器 Python 实现示例](https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/)
> - [高性能布隆过滤器 Python 实现示例](https://github.com/jhgg/pybloof)
> - [布隆过滤器 Java 实现示例 1 ](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)
> - [布隆过滤器 Java 实现示例 2 ](https://github.com/Baqend/Orestes-Bloomfilter)

### 3. LRU（最近最少使用）缓存

- 两个要素：大小、替换策略
- Hash Table + Double LinkedList 
- 查询操作：O(1)
- 修改、更新操作：O(1)



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

**排序算法分类**

1. 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破 O(nlogn)，因此也称为非线性时间比较类排序。 
2. 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

**初级排序 - O(n^2)**

1.选择排序(Selection Sort)

> 每次遍历找最小值，放到代排序数组起始位置

2.插入排序（Insertion Sort）

> 从前往后逐步构建有序序列；对于未排序数据，在已排序序列中从后往前扫描，找到相应位置插入。

3.冒泡排序（Bubble Sort）

> 每次遍历，比较相邻元素，如果逆序则交换。

**高级排序 - O(N*LogN)**

1.快速排序（Quick Sort）

> 数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序

2.归并排序（Merge Sort）

> 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
> 2. 对这两个子序列分别采用归并排序；
> 3. 将两个排序好的子序列合并成一个最终的排序序列。

**归并和快排具有相似性，但步骤顺序相反**

归并：先排序子数组，然后合并两个有序的子数组；

快排：先调配出左右子数组，然后对左右子数组进行排序。

3.堆排序（Heap Sort）

> 将数据元素依次插入小顶堆，然后依次取出堆顶元素。

**特殊排序 - O(n)**

1.计数排序（Counting Sort）

> 要求输入的数据必须是有确定范围的整数。将输入的数据值转化为存储在额外开辟的数组中，索引为数据值，数组存储的是数据值的数量。

2.桶排序（Bucket Sort）

> 将输入数据分到有限数量的桶里，对每个桶内分别排序（使用其他排序算法）。

3.基数排序（Radix Sort）

> 按照低位先排序，然后类推到高位依次排序，必须是稳定的排序算法。



**Tips**

- 归并排序：逆序对问题
- 快速排序：TopK问题



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