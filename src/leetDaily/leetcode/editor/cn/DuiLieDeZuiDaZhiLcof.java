
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window 
// 👍 215 👎 0

package leetDaily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;

public class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new DuiLieDeZuiDaZhiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {
    ArrayList<Integer> queue;

    public MaxQueue() {
        queue = new ArrayList<Integer>();
    }
    
    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        else {
            return Collections.max(queue);
        }
    }
    
    public void push_back(int value) {
        queue.add(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        else {
            return queue.remove(0);
        }
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}



/*
class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
 */