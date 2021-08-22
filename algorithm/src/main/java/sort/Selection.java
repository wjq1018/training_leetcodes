package sort;

/**
 * 选择排序  先排序前部
 * 排序原理：
 * 1.每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，
 * 如果当前索引处的值大于其他某个索引处的值，则假定其他某个索引出的值为最小值，最后可以找到最小值所在的索引;
 * 2.交换第一个索引处和最小值所在的索引处的值;
 *
 * @author wjq
 * @date 2021/8/22 18:57
 * @since 1.0.0
 **/
public class Selection {


    /**
     * 对数组内的元素进行排序
     **/
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            //依次找到最小的元素位置
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            //依次换最小元素的值
            exch(a, i, minIndex);
        }
    }

    /**
     * 判断v是否大于w
     **/
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
     **/
    private static void exch(Comparable[] a, int i, int minIndex) {
        Comparable temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
    }
}
