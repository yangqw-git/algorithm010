import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (35.16%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    9K
 * Total Submissions: 25.1K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 
 * 在网格上有一些格子被视为障碍物。
 * 
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 
 * 
 * 示例 2：
 * 
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * 
 * 
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dist = 0;
        int x = 0;
        int y = 0;
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        int i = 0;
        // 缓存障碍物坐标
        Set<String> cache = new HashSet<String>();
        for (int[] obs : obstacles) {
            cache.add(obs[0] + "_" + obs[1]);
        }
        for (int com : commands) {
            if (com == -1) {
                i = (i + 1) & 3;
            } else if (com == -2) {
                i = (i - 1 + 4) & 3;
            } else {
                for (int j = 0; j < com; j++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    // 校验是否是障碍物
                    if (cache.contains(nx + "_" + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    dist = Math.max(dist, x * x + y * y);
                }
            }
        }
        return dist;
    }
}
// @lc code=end

