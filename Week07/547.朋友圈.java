//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // DFS
    public int findCircleNum(int[][] M) {
        int m = M.length;
        if (m < 1) {
            return 0;
        }
        boolean[] visited = new boolean[m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] M, boolean[] visited, int cur) {
        visited[cur] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[cur][i] == 1 && !visited[i]) {
                dfs(M, visited, i);
            }
        }
    }

    // 并查集
    public int findCircleNum2(int[][] M) {
        int m = M.length;
        if (m < 1) {
            return 0;
        }
        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i != j && M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
        public int getCount(){
            return this.count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
