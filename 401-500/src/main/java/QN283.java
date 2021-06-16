/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author wjq
 * @date 2021/6/16 22:36
 * @since 1.0.0
 */
public class QN283 {

    public static void moveZeroes(int[] nums) {

        //定义角标置换非零元素位置
        int index = 0;

        //置换非零元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        //补充零空位
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }

}
