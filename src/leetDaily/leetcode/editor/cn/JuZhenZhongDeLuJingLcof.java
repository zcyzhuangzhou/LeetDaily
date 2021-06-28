//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 342 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
//        boolean stauts = solution.exist(new char[][]{{'a', 'a'}}, "aaa");
//        boolean stauts = solution.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED");
//        boolean stauts = solution.exist(new char[][]{{'C','A','A'}, {'A','A','A'}, {'B','C','D'}}, "AAB");
//        boolean stauts = solution.exist(new char[][]{{'a'}}, "ab");
        boolean stauts = solution.exist(new char[][]{{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}}, "ABCESEEEFS");
        System.out.println(stauts);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.toCharArray()[0]) {
                    if (word.toCharArray().length == 1) {
                        return true;
                    }
                    ArrayList<String> index = new ArrayList<>();
                    index.add(i + "," + j);
                    if (sub_exist(i, j, index, 1, board, word)) {
                        return true;
                    }
//                    for (int k = 1; k < word.toCharArray().length; k++) {
//                        if (a-1 >= 0 && !index.contains((a - 1) + "," + b) && board[a-1][b] == word.toCharArray()[k]) {
//                            index.add((a - 1) + "," + b);
//                            a = a - 1;
//                        }
//                        else if (a+1 <= board.length-1 && !index.contains((a + 1) + "," + b) && board[a+1][b] == word.toCharArray()[k]) {
//                            index.add((a + 1) + "," + b);
//                            a = a + 1;
//                        }
//                        else if (b-1 >= 0 && !index.contains(a + "," + (b - 1)) && board[a][b-1] == word.toCharArray()[k]) {
//                            index.add(a + "," + (b - 1));
//                            b = b - 1;
//                        }
//                        else if (b+1 <= board[0].length-1 && !index.contains(a + "," + (b + 1)) && board[a][b+1] == word.toCharArray()[k]) {
//                            index.add(a + "," + (b + 1));
//                            b = b + 1;
//                        }
//                        else {
//                            break;
//                        }
//                        if (k == word.toCharArray().length-1) {
//                            return true;
//                        }
//                    }
                }
            }
        }
        return false;
    }
    public boolean sub_exist(int a, int b, ArrayList<String> index, int k, char[][] board, String word) {
        if (k == word.toCharArray().length) {
            return true;
        }
        if (a-1 >= 0 && !index.contains((a - 1) + "," + b) && board[a-1][b] == word.toCharArray()[k]) {
            ArrayList<String> index2 = new ArrayList<>(index);
            index2.add((a - 1) + "," + b);
            if (sub_exist(a-1, b, index2, k+1, board, word)) {
                return true;
            }
        }
        if (a+1 <= board.length-1 && !index.contains((a + 1) + "," + b) && board[a+1][b] == word.toCharArray()[k]) {
            ArrayList<String> index2 = new ArrayList<>(index);
            index2.add((a + 1) + "," + b);
            if (sub_exist(a+1, b, index2, k+1, board, word)) {
                return true;
            }
        }
        if (b-1 >= 0 && !index.contains(a + "," + (b - 1)) && board[a][b-1] == word.toCharArray()[k]) {
            ArrayList<String> index2 = new ArrayList<>(index);
            index2.add(a + "," + (b - 1));
            if (sub_exist(a, b-1, index2, k+1, board, word)) {
                return true;
            }
        }
        if (b+1 <= board[0].length-1 && !index.contains(a + "," + (b + 1)) && board[a][b+1] == word.toCharArray()[k]) {
            ArrayList<String> index2 = new ArrayList<>(index);
            index2.add(a + "," + (b + 1));
            if (sub_exist(a, b+1, index2, k+1, board, word)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

/*
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
 */