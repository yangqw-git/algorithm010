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