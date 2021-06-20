package array;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * 示例：
 * <p>
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 提示：
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * @author wjq
 * @date 2021/6/15 13:09
 * @since 1.0.0
 */
public class  QN485Array {

    public static int findMaxConsecutiveOnes(int[] nums) {
        //如果为空或者为null,返回值为0
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        //定义计步器
        int count = 0;
        int result = 0;

        //循环数组
        for (int i = 0; i < nums.length; i++) {
            //元素为1的计算count
            if (nums[i] == 1) {
                count++;
            } else {
                result = Math.max(count, result);
                count = 0;
            }
        }
        return Math.max(count, result);
    }

    public static void main(String[] args) {
//        int[] arr = {1, 1, 0, 1, 1, 1};
        int[] arr = {1,0,1,1,0,1};

        int maxConsecutiveOnes = findMaxConsecutiveOnes(arr);
        System.out.println(maxConsecutiveOnes);
    }
}
