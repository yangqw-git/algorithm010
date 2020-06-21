### 算法作业

##### 1.[有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

> 哈希法：用数组记录26个小写字母的个数，比较两个字符串中字符个数是否一样。

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] countArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--countArr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```

##### 2.[字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

> 排序分组：将单词排序后作为key，保存到Map中，遍历后将map的values返回

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return Collections.emptyList();
        }
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortStr = String.valueOf(array);
            List<String> strList = map.get(sortStr);
            if (strList == null) {
                strList = new ArrayList<String>();
                map.put(sortStr, strList);
            }
            strList.add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
```

##### 3.[二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

> 递归

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<Integer>();
        this.traversal(root, resList);
        return resList;
    }
    public void traversal(TreeNode node,List<Integer> resList) {
        if (node == null) {
            return ;
        }
        resList.add(node.val);
        this.traversal(node.left, resList);
        this.traversal(node.right, resList);
    }
}
```

> 迭代 : 利用栈，每次迭代弹出栈顶元素，然后先将右子节点压入栈，再将左子节点压入栈

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> outList = new LinkedList<Integer>();
        if (root == null) {
            return outList;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.addLast(root);
        while (stack.peekLast() != null) {
            TreeNode last = stack.pollLast();
            outList.add(last.val);
            if (last.right != null) {
                stack.addLast(last.right);
            }
            if (last.left != null) {
                stack.addLast(last.left);
            }
        }
        return outList;
    }
}
```

##### 4.[二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

> 递归

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> outList = new LinkedList<Integer>();
        this.traversal(root, outList);
        return outList;
    }

    public void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        this.traversal(node.left, list);
        list.add(node.val);
        this.traversal(node.right, list);
    }
}
```

> 迭代

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> outList = new LinkedList<Integer>();
        if (root == null) {
            return outList;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        while (curNode != null || stack.peekLast() != null) {
            while (curNode != null) {
                stack.addLast(curNode);
                curNode = curNode.left;
            }
            TreeNode last = stack.pollLast();
            outList.add(last.val);
            curNode = last.right;
        }
        return outList;
    }
}
```

##### 5.[N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

> 递归

```java
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> outList = new LinkedList<Integer>();
        this.traversal(root,outList);
        return outList;
    }

    public void traversal(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.children != null) {
            for (Node childNode : node.children) {
                this.traversal(childNode, list);
            }
        }
    }
}
```



