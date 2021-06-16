//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 352 👎 0

package leetcode.editor.cn;
public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        int [][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean a;
        a = solution.findNumberIn2DArray(matrix, 5);
        System.out.println(a);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if ((matrix==null||matrix.length==0)||(matrix.length==1&&matrix[0].length==0)) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
//        int min = matrix[0][0], max = matrix[row-1][col-1];
        if (target < matrix[0][0] | target > matrix[row-1][col-1]) {
            return false;
        }
        int i = 0, j = col-1;
        int comp = matrix[0][col-1];
        while (true) {
            if (target < comp) {
                do {
                    j = j - 1;
                    if (j < 0)
                        return false;
                    comp = matrix[i][j];
                } while (target < comp);
            }
            else if (target > comp) {
                do {
                    i = i + 1;
                    if (i >= row)
                        return false;
                    comp = matrix[i][j];
                } while (target > comp);
            }
            else {
                return true;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

/*
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
 */