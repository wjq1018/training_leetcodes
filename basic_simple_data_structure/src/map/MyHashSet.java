package map;

class MyHashSet {
    Node[] array;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        array = new Node[1 << 14];//make sure size is powers of 2
        size = 0;
    }

    public void add(int key) {
        //factor is 0.75
        if (++size > array.length * 0.75) {
            //double size
            resize();
        }
        int index = getIndex(key, array.length);
        Node head = array[index];
        Node cur = new Node(key);

        if (head == null) {// head has not been initialized
            head = new Node();
            array[index] = head;
            head.next = cur;
        } else {
            //make sure not adding duplicate nodes
            Node h2 = head.next;
            while (h2 != null) {
                if (h2.val == key) {
                    return;
                }
                h2 = h2.next;
            }
            h2 = head.next;
            head.next = cur;
            cur.next = h2;
        }
    }

    public void remove(int key) {
        int index = getIndex(key, array.length);
        Node head = array[index];
        if (head == null) {
            return;
        } else {
            Node pre = head;
            Node h2 = head.next;
            while (h2 != null) {
                if (h2.val != key) {
                    pre = h2;
                    h2 = h2.next;
                } else {
                    pre.next = h2.next;
                    size--;
                    return;
                }
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = getIndex(key, array.length);
        Node head = array[index];
        if (head == null) {
            return false;
        } else {
            Node h2 = head.next;
            while (h2 != null) {
                if (h2.val != key) {
                    h2 = h2.next;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void resize() {
        //double size
        Node[] array2 = new Node[array.length << 1];
        //transfer node from old bin into new bin
        for (int i = 0; i < array.length; i++) {
            Node head1 = array[i];
            if (head1 != null) {
                Node h1 = head1.next;
                while (h1 != null) {
                    Node next = h1.next;
                    int key = h1.val;
                    int newIndex = getIndex(key, array2.length);
                    Node head2 = array2[newIndex];
                    if (head2 == null) {
                        head2 = new Node();
                        head2.next = h1;
                        array2[newIndex] = head2;
                    } else {
                        Node temp = head2.next;
                        head2.next = h1;
                        h1.next = temp;
                    }
                    h1 = next;
                }
            }
        }
        array = array2;
    }

    //make sure size is powers of 2
    //then key%size = key&(size-1)
    private int getIndex(int key, int size) {
        return key & (size - 1);
    }

    class Node {
        int val;
        Node next;

        public Node(int key) {
            this.val = key;
        }

        public Node() {
        }
    }
}