package sort;

/**
 * 冒泡排序  先排序后部
 * 排序原理：
 * 1. 比较相邻的元素。如果前一个元素比后一个元素大，就交换这两个元素的位置。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对元素到结尾的最后一对元素。最终最后位置的元素就是最大值。
 *
 * @author wjq
 * @date 2021/8/22 18:25
 * @since 1.0.0
 **/
public class Bubble {

    /**
     * 对数组内的元素进行排序
     **/
    public static void sort(Comparable[] a) {
        for (int i = a.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
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
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
