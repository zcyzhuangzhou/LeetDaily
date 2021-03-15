//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//r_l
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2234 👎 0

package leetDaily.leetcode.editor.cn;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        /*
        有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
         */
        if (s.length() > 1) {
            Map<Character, Character> r_l = new HashMap<>();
            r_l.put(')', '(');
            r_l.put(']', '[');
            r_l.put('}', '{');
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char ch : chars) {
                if (r_l.containsValue(ch)) {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty() || stack.pop() != r_l.get(ch)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}