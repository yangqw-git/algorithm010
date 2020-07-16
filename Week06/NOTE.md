#### 学习笔记

##### 1. 动态规划

###### 1.1 回顾

> 本质 : 寻找重复性 --> 计算机指令集

```
- 抵制人肉递归，人肉递归低效，很累
- 找最近最简方法，将其拆解成可重复子问题
- 数学归纳法思维
```

###### 1.2 定义 Dynamic Programming

> 动态规划(递推)，将复杂问题拆分为简单的子问题，用递归的方式；分治+最优子结构

**关键点**

1. 动态规划 和 递归或者分治 没有根本上的区别（关键是看有无最优子结构）
2. 共性: 找重复子问题
3. 差异性: 最优子结构、中途可以淘汰次优解

**动态规划关键点**

1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
2. 储存中间状态
3. 递推公式（状态转移方程 或者 DP方程）

**动态规划小结**

1. 打破自己的思维惯性，形成机器思维（找重复性）
2. 这是理解复杂逻辑的关键
3. 也是职业进阶的要点要领

**动态规划步骤**

1. 找重复子问题（分治）
2. 定义状态数组
3. 动态规划方程



>**实战例题**
>
>- [不同路径](https://leetcode-cn.com/problems/unique-paths/)（Facebook、亚马逊、微软在半年内面试中考过）
>- [不同路径 II ](https://leetcode-cn.com/problems/unique-paths-ii/)（谷歌、美团、微软在半年内面试中考过）
>- [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)（字节跳动、谷歌、亚马逊在半年内面试中考过）
>- [ MIT 动态规划课程最短路径算法](https://www.bilibili.com/video/av53233912?from=search&seid=2847395688604491997)
>- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/description/)（阿里巴巴、腾讯、字节跳动在半年内面试常考）
>- [三角形最小路径和](https://leetcode-cn.com/problems/triangle/description/)（亚马逊、苹果、字节跳动在半年内面试考过）
>- 三角形最小路径和高票回答：[ https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up) ](https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up))
>- [最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)（亚马逊、字节跳动在半年内面试常考）
>- [乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/description/)（亚马逊、字节跳动、谷歌在半年内面试中考过）
>- [零钱兑换](https://leetcode-cn.com/problems/coin-change/description/)（亚马逊在半年内面试中常考）
>- [打家劫舍](https://leetcode-cn.com/problems/house-robber/)（字节跳动、谷歌、亚马逊在半年内面试中考过）
>- [打家劫舍 II ](https://leetcode-cn.com/problems/house-robber-ii/description/)（字节跳动在半年内面试中考过）
>- [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description)（亚马逊、字节跳动、Facebook 在半年内面试中常考）
>- [买卖股票的最佳时机 II ](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)（亚马逊、字节跳动、微软在半年内面试中考过）
>- [买卖股票的最佳时机 III ](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)（字节跳动在半年内面试中考过）
>- [最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)（谷歌、亚马逊在半年内面试中考过）
>- [买卖股票的最佳时机 IV ](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)（谷歌、亚马逊、字节跳动在半年内面试中考过）
>- [买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
>- [一个方法团灭 6 道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)
>
>**高级DP实战例题**
>
>- [完全平方数](https://leetcode-cn.com/problems/perfect-squares/)（亚马逊、谷歌在半年内面试中考过）
>- [编辑距离](https://leetcode-cn.com/problems/edit-distance/) **（重点）**
>- [跳跃游戏](https://leetcode-cn.com/problems/jump-game/)（亚马逊在半年内面试中考过）
>- [跳跃游戏 II ](https://leetcode-cn.com/problems/jump-game-ii/)（亚马逊、华为字节跳动在半年内面试中考过）
>- [不同路径](https://leetcode-cn.com/problems/unique-paths/)（Facebook、亚马逊、微软在半年内面试中考过）
>- [不同路径 II ](https://leetcode-cn.com/problems/unique-paths-ii/)（谷歌、美团、微软在半年内面试中考过）
>- [不同路径 III ](https://leetcode-cn.com/problems/unique-paths-iii/)（谷歌在半年内面试中考过）
>- [零钱兑换](https://leetcode-cn.com/problems/coin-change/)（亚马逊在半年内面试中常考）
>- [零钱兑换 II ](https://leetcode-cn.com/problems/coin-change-2/)（亚马逊、字节跳动在半年内面试中考过）




