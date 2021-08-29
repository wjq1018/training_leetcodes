package sort;

/**
 * 插入排序  已排序&&未排序的元素
 * 排序原理：
 * 1.把所有的元素分为两组，已经排序的和未排序的;
 * 2.找到未排序的组中的第一个元素，向已经排序的组中进行插入;
 * 3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，那么就把待
 * 插入元素放到这个位置，其他的元素向后移动一位;
 *
 * @author wjq
 * @date 20210829
 * @since 1.0.0
 **/
public class Insertion {


    /**
     * 对数组内的元素进行排序
     **/
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                //循环比较未排序的元素与已排序的元素
                if (greater(a[j - 1], a[j])) {
                    exch(a, j - 1, j);
                } else {
                    break;
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
    private static void exch(Comparable[] a, int i, int minIndex) {
        Comparable temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
    }
}
