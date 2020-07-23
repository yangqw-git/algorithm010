//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 387 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Pair<L, R> {
        public L left;
        public R right;
        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }
    }

    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> tempMap = new HashMap<String,List<String>>();
        boolean flag = false;
        // 字典预处理
        for (int i = 0; i < wordList.size(); i++) {
            char[] curArr = wordList.get(i).toCharArray();
            for (int j = 0; j < curArr.length; j++) {
                char c = curArr[j];
                curArr[j] = '*';
                String newWord = String.valueOf(curArr);
                List<String> list = tempMap.get(newWord);
                if (list == null) {
                    list = new ArrayList<String>();
                    tempMap.put(newWord, list);
                }
                list.add(wordList.get(i));
                curArr[j] = c;
            }
            if (endWord.equals(wordList.get(i))) {
                flag = true;
            }
        }
        if (!flag) {
            return 0;
        }
        // BFS开始
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        Set<String> visited = new HashSet<String>();
        queue.offer(new Pair(beginWord, 1));
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> cur = queue.poll();
            if (cur.left.equals(endWord)) {
                return cur.right;
            }
            char[] curArr = cur.left.toCharArray();
            for (int i = 0; i < curArr.length; i++) {
                char c = curArr[i];
                curArr[i] = '*';
                List<String> list = tempMap.get(String.valueOf(curArr));
                if (list != null && list.size() > 0) {
                    for (String s : list) {
                        if (!visited.contains(s)) {
                            queue.offer(new Pair(s, cur.right + 1));
                            visited.add(s);
                        }
                    }
                }
                curArr[i] = c;
            }
        }
        return 0;
    }

    // BFS(不用Pair)
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> tempMap = new HashMap<String,List<String>>();
        boolean flag = false;
        for (int i = 0; i < wordList.size(); i++) {
            char[] curArr = wordList.get(i).toCharArray();
            for (int j = 0; j < curArr.length; j++) {
                char c = curArr[j];
                curArr[j] = '*';
                String newWord = String.valueOf(curArr);
                List<String> list = tempMap.get(newWord);
                if (list == null) {
                    list = new ArrayList<String>();
                    tempMap.put(newWord, list);
                }
                list.add(wordList.get(i));
                curArr[j] = c;
            }
            if (endWord.equals(wordList.get(i))) {
                flag = true;
            }
        }
        if (!flag) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int qs = queue.size();
            for (int j = 0; j < qs; j++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                char[] curArr = cur.toCharArray();
                for (int i = 0; i < curArr.length; i++) {
                    char c = curArr[i];
                    curArr[i] = '*';
                    List<String> list = tempMap.get(String.valueOf(curArr));
                    if (list != null && list.size() > 0) {
                        for (String s : list) {
                            if (!visited.contains(s)) {
                                queue.offer(s);
                                visited.add(s);
                            }
                        }
                    }
                    curArr[i] = c;
                }
            }
            step++;
        }
        return 0;
    }

    // 双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> tempMap = new HashMap<String,List<String>>();
        boolean flag = false;
        for (int i = 0; i < wordList.size(); i++) {
            char[] curArr = wordList.get(i).toCharArray();
            for (int j = 0; j < curArr.length; j++) {
                char c = curArr[j];
                curArr[j] = '*';
                String newWord = String.valueOf(curArr);
                List<String> list = tempMap.get(newWord);
                if (list == null) {
                    list = new ArrayList<String>();
                    tempMap.put(newWord, list);
                }
                list.add(wordList.get(i));
                curArr[j] = c;
            }
            if (endWord.equals(wordList.get(i))) {
                flag = true;
            }
        }
        if (!flag) {
            return 0;
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<String>();
        q1.add(beginWord);
        q2.add(endWord);
        int step = 1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);
                char[] curArr = cur.toCharArray();
                for (int i = 0; i < curArr.length; i++) {
                    char c = curArr[i];
                    curArr[i] = '*';
                    List<String> list = tempMap.get(String.valueOf(curArr));
                    if (list != null && list.size() > 0) {
                        for (String s : list) {
                            if (!visited.contains(s)) {
                                temp.add(s);
                            }
                        }
                    }
                    curArr[i] = c;
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
