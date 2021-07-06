//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 303 👎 0

package leetcode.editor.cn;
public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
//        int count = 0;
//        int x = 0, y = 0;
        arr = digui(arr, m, n, k, 0, 0);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) count +=1;
            }
        }
        return count;
//        if (x-1 >= 0 && arr[x-1][y] != 1 && ((x-1)%10 + (x-1)/10 + y%10 + y/10) <= k) {
//            arr[x-1][y] = 1;
//            count += 1;
//            x = x-1;
//        }
//        if (x+1 < m && arr[x+1][y] != 1 && ((x+1)%10 + (x+1)/10 + y%10 + y/10) <= k) {
//            arr[x+1][y] = 1;
//            count += 1;
//            x = x+1;
//        }
//        if (y-1 >= 0 && arr[x][y-1] != 1 && (x%10 + x/10 + (y-1)%10 + (y-1)/10) <= k) {
//            arr[x][y-1] = 1;
//            count += 1;
//            y = y-1;
//        }
//        if (y+1 < n && arr[x][y+1] != 1 && (x%10 + x/10 + (y+1)%10 + (y+1)/10) <= k) {
//            arr[x][y+1] = 1;
//            count += 1;
//            y = y+1;
//        }
//        return count;
    }
    public int[][] digui(int[][] arr, int m, int n, int k, int x, int y) {
        if (x < 0 | x >= m | y < 0 | y >= n) {
            return arr;
        }
        if (arr[x][y] == 1) {
            return arr;
        }
        if ((x/10 + x%10 + y/10 + y%10) <= k) {
            arr[x][y] = 1;
            digui(arr, m, n, k, x+1, y);
            digui(arr, m, n, k, x, y+1);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

/* 广度优先搜索
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
 */

/* 递归
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
 */