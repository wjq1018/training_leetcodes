package stack;

import java.util.Stack;

/**
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * @author wjq
 * @date 2021/6/29 23:49
 * @since 1.0.0
 **/
public class QN496Stack {

    /**
     * 这种方式,时间复杂度O(N*M),空间复杂度 O(N)
     * 后期使用哈希表
     **/
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            Stack<Integer> temp = new Stack<>();
            boolean flag = false;
            int max = -1;
            int n1 = nums1[i];

            while (!stack.isEmpty() && !flag) {
                int top = stack.pop();
                if (top > n1) {
                    max = top;
                } else if (top == n1) {
                    flag = true;
                }
                temp.push(top);
                result[i] = max;
            }
            //返回临时栈temp的元素给stack
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2, 2};

        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i + " : " + result[i]);
        }
    }
}
