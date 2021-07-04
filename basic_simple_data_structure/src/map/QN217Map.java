package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * @author wjq
 * @date 2021/6/30 23:31
 * @since 1.0.0
 **/
public class QN217Map {

    public static boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));

    }
}
