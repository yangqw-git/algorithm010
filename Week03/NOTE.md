#### 学习笔记

##### 1.泛型递归，树的递归

###### 1.1 递归 Recursion

> 递归，和循环类似，通过函数体来进行的循环

- 递归代码模板

```java
public void recur(int level, int param) { 
  // terminator 递归终结条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic  处理当前层逻辑
  process(level, param); 
    
  // drill down 下探到下一层
  recur( level: level + 1, newParam); 
    
  // restore current status 清理当前层
 
}
```

- 递归思维要点

1. 不要人肉递归(最大误区)
2. 找到最近最简方法，将其拆解成可重复解决的问题(重复子问题)
3. 数学归纳法思维

> 找最近重复性：假如没有任何重复性，说明问题的复杂度是客观存在的。
>
> 数学归纳法：起始条件成立，且当n成立的时候，可以推导出n+1也成立。

- 验证二叉搜索树

1.递归，验证左右子树所有节点(非左右子节点)；

2.中序遍历是递增的



>参考链接
>
>-  [递归代码模板](https://shimo.im/docs/EICAr9lRPUIPHxsH/)
>-  [如何优雅地计算斐波那契数列](https://time.geekbang.org/dailylesson/detail/100028406)
>
>
>相关题目
>
>- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)（阿里巴巴、腾讯、字节跳动在半年内面试常考）
>- [括号生成](https://leetcode-cn.com/problems/generate-parentheses/) (字节跳动在半年内面试中考过)
>- [翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/description/) (谷歌、字节跳动、Facebook 在半年内面试中考过)
>- [验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree)（亚马逊、微软、Facebook 在半年内面试中考过）
>- [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)（亚马逊、微软、字节跳动在半年内面试中考过）
>- [二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree)（Facebook、字节跳动、谷歌在半年内面试中考过）
>- [二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)（Facebook、亚马逊在半年内面试常考）



##### 2. 分治、回溯

###### 2.1 分治(Divide & Conquer)

> 分治和回溯本质就是递归，是其中一个细分类(分治和回溯是一种特殊的递归)；
>
> 解题思路：
>
> ​	1.找重复性；重复性包括最近重复性(分治，回溯)，最优重复性(动态规划)，本质就是递归；
>
> ​	2.分解问题；
>
> ​	3.组合子问题结果；

- 分治代码模板

```java
public void divideConquer(int[] problem, int... param) { 
  // terminator 递归终结条件
  if (problem.length < 2) { 
    // process result 
    return; 
  }
  // prepare data 
  data = prepareData(problem) 
  subproblems = splitProblem(problem, data) 
      
  // conquer subproblems 
  subresult1 = divideConquer(subproblems[0], p1, ...) 
  subresult2 = divideConquer(subproblems[1], p1, ...) 
  subresult3 = divideConquer(subproblems[2], p1, ...) 
  …
      
  // process and generate the final result 
  result = processResult(subresult1, subresult2, subresult3, …)
	
  // revert the current level states
 
}
```



###### 2.2 回溯(Backtracking)

> 回溯采用试错的思想，尝试分步解决，当发现现有分步不能得到正确解答时，再通过其他分步解答问题；
>
> 回溯通常使用递归方法实现；
>
> 最坏情况下，回溯法时间复杂度为指数级；



> 相关链接
>
> - [分治代码模板](https://shimo.im/docs/zvlDqLLMFvcAF79A/)
> - [括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)
> - [牛顿迭代法原理](http://www.matrix67.com/blog/archives/361)
> - [牛顿迭代法代码](http://www.voidcn.com/article/p-eudisdmk-zm.html)
>
> 相关题目
>
> - [ Pow(x, n) ](https://leetcode-cn.com/problems/powx-n/)（Facebook 在半年内面试常考）
> - [子集](https://leetcode-cn.com/problems/subsets/)（Facebook、字节跳动、亚马逊在半年内面试中考过）
> - [多数元素](https://leetcode-cn.com/problems/majority-element/description/) （亚马逊、字节跳动、Facebook 在半年内面试中考过）
> - [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)（亚马逊在半年内面试常考）
> - [ N 皇后](https://leetcode-cn.com/problems/n-queens/)（字节跳动、苹果、谷歌在半年内面试中考过）
