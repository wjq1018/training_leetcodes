package map;

import java.util.HashSet;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * <p>
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 *
 * @author wjq
 * @date 2021/7/11 21:02
 * @since 1.0.0
 **/
public class QN705MyHashSet {

    boolean[] hashSet = null;
    /**
     * Initialize your data structure here.
     */
    public QN705MyHashSet() {
        hashSet = new boolean[1000001];
    }

    public void add(int key) {
        hashSet[key] = true;
    }

    public void remove(int key) {
        hashSet[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return hashSet[key];
    }
}


