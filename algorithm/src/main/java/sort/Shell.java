package sort;

/**
 * //希尔排序 插入排序增强版本
 * <p>
 * 排序原理:
 * 1.选定一个增长量h,按照增长量h作为数据分组的依据,对数据进行分组;
 * 2.对分好组的每一组数据完成插入排序；
 * 3.减小增长量，最小减为1，重复第二步操作。
 *
 * @author wjq
 * @date 2021/8/29 23:01
 * @since 1.0.0
 **/
public class Shell {
    /*
      对数组a中的元素进行排序
   */
    public static void sort(Comparable[] a) {
        //确定增长量h
        int h = 1;
        while (h < a.length / 2) {
            h = h * 2 + 1;
        }

        //最小减为1
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                //根据增长量进行,分组,针对代排序元素进行位置比较,交换
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h],a[j])) {
                        //交换元素
                        exch(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            //减小增长量
            h /= 2;
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
