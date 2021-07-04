package map;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * @author wjq
 * @date 2021/6/30 23:50
 * @since 1.0.0
 **/
public class QN389Map {
    //哈希表法
//    public static char findTheDifference(String s, String t) {
//        int sizeS = s.length();
//        int sizeT = t.length();
//
//        if (sizeS == 0) {
//            return t.charAt(0);
//        }
//
//        int[] table = new int[26];
//
//        for (int i = 0; i < sizeT; i++) {
//            if (i < sizeS) {
//                table[s.charAt(i) - 'a']--;
//            }
//            table[t.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < table.length; i++) {
//            if (table[i] != 0) {
//                return (char) (i + 'a');
//            }
//        }
//        return 'a';
//    }

    //算数运算符
    public static char findTheDifference(String s, String t) {
        int sizeS = s.length();
        int sizeT = t.length();
        //全数据进行加减操作
        int total = 0;

        for (int i = 0; i < sizeT; i++) {
            if (i < sizeS) {
                total -= s.charAt(i);
            }
            total += t.charAt(i);
        }

        return (char)total;
    }

    public static void main(String[] args) {

        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
