//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 11 (控制台输入 00000000000000000000000000001011)
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 
//输入：n = 128 (控制台输入 00000000000000000000000010000000)
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 
//输入：n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 输入必须是长度为 32 的 二进制串 。 
// 
//
// 
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/ 
// Related Topics 位运算 
// 👍 164 👎 0

package leetcode.editor.cn;
public class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
//        solution.hammingWeight(-3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        String binary_str = Integer.toBinaryString(n);
        for (char c: binary_str.toCharArray()) {
            if (c == '1') {
                count += 1;
            }
        }
        return count;
//        int[] binary_arr = new int[32];
//        for (int i = 0; i < 32; i++) {
//            binary_arr[i] = (int) Math.pow(2, i);
//        }
//        return digui(binary_arr, n, 0);
    }

//    public int digui(int[] binary_arr, int n, int count) {
//        for (int i = 0; i < 32; i++) {
//            if (binary_arr[i] == n) {
//                count += 1;
//                return count;
//            }
//            else if (binary_arr[i] > n) {
//                count += 1;
//                count = digui(binary_arr, n-binary_arr[i-1], count);
//                return count;
//            }
//        }
//        return count;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

/* 逐位判断
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
 */

/* 巧用 n&(n−1)
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
 */