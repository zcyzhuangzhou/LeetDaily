//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 838 👎 0

package leetDaily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;

public class MinStack {
    public static void main(String[] args) {
        Solution solution = new MinStack().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    ArrayList<Integer> min_stack = new ArrayList<>();
    int top = -1;
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        min_stack.add(x);
        top++;
    }
    
    public void pop() {
        min_stack.remove(top);
        top--;
    }
    
    public int top() {
        return min_stack.get(top);
    }
    
    public int getMin() {
        return Collections.min(min_stack);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}



// 使用辅助栈
//class MinStack {
//    Deque<Integer> xStack;
//    Deque<Integer> minStack;
//
//    public MinStack() {
//        xStack = new LinkedList<Integer>();
//        minStack = new LinkedList<Integer>();
//        minStack.push(Integer.MAX_VALUE);
//    }
//
//    public void push(int x) {
//        xStack.push(x);
//        minStack.push(Math.min(minStack.peek(), x));
//    }
//
//    public void pop() {
//        xStack.pop();
//        minStack.pop();
//    }
//
//    public int top() {
//        return xStack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}



// 不使用额外空间，栈中存储和min的差值diff，注意int范围，需要使用Long存diff
///**
// * stack用来存储和min的差值，min存储最小值，每次出栈的时候通过差值和当前min计算要出栈的值和之前的min
// * 如果差值diff大于等于0，说明要出栈的值大于等于当前min，那么要出栈的值在入栈的时候没有更新min，返回min+diff；
// * 如果插值diff小于0，说明当前要出栈的值就是min(因为入栈的时候我们选择的就是min和入栈元素的最小值)，同时，通过min-diff计算出之前min
// * 要注意的是diff可能会超出int范围，类似于 Integer.MAX_VALUE - 1 这种，所以diff要用Long存
// */
//class MinStack {
//
//    Integer min = null;
//    Stack<Long> data = new Stack<>();
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack1() {
//
//    }
//
//    public void push(int x) {
//        if (data.isEmpty()) {
//            data.push(0L);
//            min = x;
//        } else {
//            //如果x是最小的数，这里可能越界，所以用Long来保存
//            data.push(Long.valueOf(x) - min);
//            min = Math.min(x, min);
//        }
//    }
//
//    public void pop() {
//        Long diff = data.pop();
//        if (diff >= 0) {
//            //return min + diff;
//        } else {
//            int res = min;
//            min = (int) (min - diff);
//            //return res;
//        }
//    }
//
//    public int top() {
//        Long diff = data.peek();
//        if (diff >= 0) {
//            return (int) (min + diff);
//        } else {
//            return min;
//        }
//    }
//
//    public int getMin() {
//        return min;
//    }
//}