/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 *
 * https://leetcode-cn.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (41.70%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    17.6K
 * Total Submissions: 42.2K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 
 * 输入: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * 输出: ["eat","oath"]
 * 
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 
 * 提示:
 * 
 * 
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 
 * 
 */

// @lc code=start
class Solution {
    private int[][] vector = {{0,1},{0,-1},{-1,0},{1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie dic = new Trie();
        for (int i = 0; i < words.length; i++) {
            dic.insert(words[i]);
        }
        Set<String> resList = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                this.dfs(board, i, j, String.valueOf(board[i][j]), dic, resList);
            }
        }
        return new ArrayList<>(resList);
    }

    public void dfs(char[][] board, int i, int j, String curString, Trie dic, Set<String> resList) {
        Trie node = dic.searchPrefix(curString);
        if (node == null) {
            return;
        }
        if (node.isEnd) {
            resList.add(curString);
        }
        for (int[] v : vector) {
            char c = board[i][j];
            if (i + v[0] > -1 && i + v[0] < board.length && j + v[1] > -1 && j + v[1] < board[i].length
                    && board[i + v[0]][j + v[1]] != '$') {
                board[i][j] = '$';
                dfs(board, i + v[0], j + v[1], curString + board[i + v[0]][j + v[1]], dic, resList);
                board[i][j] = c;
            }
        }
    }

    class Trie {
        boolean isEnd;
        Trie[] next;
        public Trie (){
            this.isEnd = false;
            this.next = new Trie[26];
        }
        public void insert(String word){
            Trie cur = this;
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                Trie temp = cur.next[arr[i] - 'a'];
                if (temp == null) {
                    temp = new Trie();
                    cur.next[arr[i] - 'a'] = temp;
                }
                cur = temp;
            }
            cur.isEnd = true;
        }
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        private Trie searchPrefix(String word) {
            Trie node = this;
            char[] words = word.toCharArray();
            for (int i = 0;i < words.length;i++) {
                node = node.next[words[i] - 'a'];
                if (node == null) return null;
            }
            return node;
        }
    }
}
// @lc code=end

