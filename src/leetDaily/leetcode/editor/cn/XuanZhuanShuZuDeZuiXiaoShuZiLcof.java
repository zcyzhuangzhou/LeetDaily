//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 336 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        solution.minArray(new int[]{2, 2, 2, 0, 1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
                break;
            }
        }
        return min;
//        if (numbers[0] < numbers[numbers.length-1]) {
//            return numbers[0];
//        }
//        int min = 0;
//        List<Integer> tmp_arr = new ArrayList<>();
//        tmp_arr = Arrays.stream(numbers).boxed().collect(Collectors.toList());
//        while (tmp_arr.size() >= 4) {
//            if (tmp_arr.get(0) > tmp_arr.get(tmp_arr.size()/2-1)) {
//                tmp_arr = tmp_arr.subList(0, tmp_arr.size()/2);
//                min = tmp_arr.get(tmp_arr.size()/2);
//            }
//            if (tmp_arr.get(tmp_arr.size()/2) > tmp_arr.get(tmp_arr.size()-1)) {
//                tmp_arr = tmp_arr.subList(tmp_arr.size()/2+1, tmp_arr.size()-1);
//                min = tmp_arr.get(tmp_arr.size()-1);
//            }
//        }
//        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

/*
二分法
class Solution {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
 */