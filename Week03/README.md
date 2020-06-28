### 算法作业

##### 1. [二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

> 1.分别记录p,q节点的父节点，然后逐个对比

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        this.isAncestor(root, p, pList);
        this.isAncestor(root, q, qList);
        int i = pList.size() - 1;
        int j = qList.size() - 1;
        while (pList.get(i).val == qList.get(j).val && i - 1 >= 0 && j - 1 >= 0
                && pList.get(i - 1).val == qList.get(j - 1).val) {
            i--;
            j--;
        }
        return pList.get(i);
    }

    public boolean isAncestor(TreeNode curNode, TreeNode s, List<TreeNode> ancestors) {
        if (curNode == null) {
            return false;
        }
        if (curNode.val == s.val || this.isAncestor(curNode.left, s, ancestors)
                || this.isAncestor(curNode.right, s, ancestors)) {
            ancestors.add(curNode);
            return true;
        }
        return false;
    }
}
```

> 2.递归法(官方)
>
> 递归方法返回值：如果当前节点是p或q，或者左子节点含有p，q，或者右子节点含有p，q(当前节点是p或q的祖先)；
>
> 更新结果：
>
> ​	1.左子节点是祖先节点，且右子节点是祖先节点；
>
> ​	2.当前节点是p或q，且左右子节点有一个是祖先节点；

```java
class Solution {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        this.dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode curNode, TreeNode p, TreeNode q) {
        if (curNode == null) {
            return false;
        }
        boolean l = this.dfs(curNode.left, p, q);
        boolean r = this.dfs(curNode.right, p, q);
        if ((l && r) || ((curNode.val == p.val || curNode.val == q.val) && (l || r))) {
            ans = curNode;
        }
        return l || r || curNode.val == p.val || curNode.val == q.val;
    }
}
```

> 3.记录父节点

```java
class Solution {

    private Map<Integer,TreeNode> parentNode;
    private Set<Integer> visited;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.parentNode = new HashMap<>();
        this.visited = new HashSet<>();
        this.dfs(root);
        while(p != null){
            visited.add(p.val);
            p = parentNode.get(p.val);
        }
        while(q != null){
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentNode.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode curNode) {
        if (curNode == null) {
            return ;
        }
        if (curNode.left != null) {
            parentNode.put(curNode.left.val,curNode);
            this.dfs(curNode.left);
        }
        if (curNode.right != null) {
            parentNode.put(curNode.right.val,curNode);
            this.dfs(curNode.right);
        }
    }
}
```



##### 2. [从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

> 递归 : 
>
> 前序遍历 : [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
>
> 中序遍历 : [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
>
> 根据前序遍历第一个节点获取到根节点，然后再中序遍历中获取到左子树的长度

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        }
        // root 节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        // 左子树
        int i = -1;
        while (inorder[++i] != rootVal);
        TreeNode left = null;
        if (i > 0) {
            left = this.buildTree(Arrays.copyOfRange(preorder, 1, i + 1), 
                   Arrays.copyOfRange(inorder, 0, i));
        }
        TreeNode right = null;
        if (i + 1 < inorder.length) {
            right = this.buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                    Arrays.copyOfRange(inorder, i + 1, inorder.length));
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
```



##### 3. [组合](https://leetcode-cn.com/problems/combinations/)

> 递归

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        this.recursion(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    public void recursion(int n, int k, int i, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(list);
            return;
        }
        if (list.size() + (n - i + 1) < k) {
            return;
        }
        if (i > n) {
            return;
        }
        // 不选
        this.recursion(n, k, i + 1, new ArrayList<Integer>(list), res);
        // 选择当前数
        list.add(i);
        this.recursion(n, k, i + 1, new ArrayList<Integer>(list), res);
    }
}
```



##### 4. [全排列](https://leetcode-cn.com/problems/permutations/)

> 递归

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (nums.length < 1) {
            resList.add(new ArrayList<Integer>());
            return resList;
        } else if (nums.length < 2) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            resList.add(list);
            return resList;
        }
        List<List<Integer>> subList = this.permute(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> list : subList) {
            for (int len = list.size(); len > -1; len--){
                List<Integer> l = new ArrayList<>(list);
                if (len == list.size()) {
                    l.add(nums[0]);
                } else {
                    l.add(len, nums[0]);
                }
                resList.add(l);
            }
        }
        return resList;
    }
}
```



##### 5. [全排列 II ](https://leetcode-cn.com/problems/permutations-ii/)





