//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 145 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        /* 方法一：双向队列
        ArrayDeque<Integer> num_deque = new ArrayDeque<Integer>();
        for (int n: nums) {
            if (n % 2 == 0) num_deque.addLast(n);
            else num_deque.addFirst(n);
        }
        return num_deque.stream().mapToInt(Integer::valueOf).toArray();*/
        //方法二：双指针遍历，辅助数组
//        int[] new_nums = new int[nums.length];
//        int i = 0, j = nums.length - 1;
//        for (int n: nums) {
//            if (n % 2 == 0) {
//                new_nums[j] = n;
//                j--;
//            }
//            else {
//                new_nums[i] = n;
//                i++;
//            }
//        }
//        return new_nums;
        //方法三：双指针，在原数组上直接交换操作
        int i = 0, j = nums.length-1;
        while (true) {
            for (; i < nums.length; i++) {
                if (nums[i] % 2 == 0) break;
            }
            if (i >= j) break;
            for (; j > 0; j--) {
                if (nums[j] % 2 == 1) break;
            }
            if (i >= j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

/* 快慢双指针
class Solution {
public:
    vector<int> exchange(vector<int>& nums) {
        int low = 0, fast = 0;
        while (fast < nums.size()) {
            if (nums[fast] & 1) {
                swap(nums[low], nums[fast]);
                low ++;
            }
            fast ++;
        }
        return nums;
    }
};
 */