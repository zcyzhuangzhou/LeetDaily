////给你一个字符串 s，找到 s 中最长的回文子串。
////
////
////
//// 示例 1：
////
////
////输入：s = "babad"
////输出："bab"
////解释："aba" 同样是符合题意的答案。
////
////
//// 示例 2：
////
////
////输入：s = "cbbd"
////输出："bb"
////
////
//// 示例 3：
////
////
////输入：s = "a"
////输出："a"
////
////
//// 示例 4：
////
////
////输入：s = "ac"
////输出："a"
////
////
////
////
//// 提示：
////
////
//// 1 <= s.length <= 1000
//// s 仅由数字和英文字母（大写和/或小写）组成
////
//// Related Topics 字符串 动态规划
//// 👍 3277 👎 0
//
//package leetcode.editor.cn;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class LongestPalindromicSubstring {
//    public static void main(String[] args) {
//        Solution solution = new LongestPalindromicSubstring().new Solution();
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String longestPalindrome(String s) {
//        Map<Integer, String> max_str_hashmap = new HashMap<>();
//        int max_length = 1;
//        max_str_hashmap.put(max_length, String.valueOf(s.charAt(0)));
//        Map<Character, ArrayList<Integer>> index_hashmap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            ArrayList<Integer> index_arr = new ArrayList<>();
//            if (!index_hashmap.containsKey(s.charAt(i))) {
//                index_arr.add(i);
//                index_hashmap.put(s.charAt(i), index_arr);
//            }
//            else {
//                index_arr = index_hashmap.get(s.charAt(i));
//                index_arr.add(i);
//            }
//        }
//        for (int i = 0; i < s.length(); i++) {
//
//        }
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}