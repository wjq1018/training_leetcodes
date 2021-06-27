package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wjq
 * @date 2021/6/27 22:11
 * @since 1.0.0
 **/
public class QN933Queue {
    private static Queue<Integer> queue;

    public QN933Queue() {
        queue = new LinkedList<>();
    }

    public static int ping(int t) {
        queue.add(t);

        while (!queue.isEmpty() && (t - queue.peek() > 3000)) {
            queue.poll();
        }
        return queue.size();
    }

}
