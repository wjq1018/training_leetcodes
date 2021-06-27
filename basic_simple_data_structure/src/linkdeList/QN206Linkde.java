package linkdeList;

/**
 * @author wjq
 * @date 2021/6/20 0:08
 * @since 1.0.0
 **/
public class QN206Linkde {

    public static void main(String[] args) {
        ListNode nodestr = new ListNode(0); //创建首结点
        ListNode nextNode;     //创建下一个结点
        nextNode = nodestr;    //指向首结点
        //创建链表
        for (int i = 1; i < 10; i++) {
            ListNode newnode = new ListNode(i);  //创建新的结点
            nextNode.next = newnode;     // 把新结点连起来
            nextNode = nextNode.next; //把结点往后移
        }//nextNode指向最后一个结点
        nextNode = nodestr;  //重新指向首结点

//        while(nextNode != null){
//            System.out.println("第一个结点值："+ nextNode.val);
//            nextNode = nextNode.next;
//        }

        ListNode listNode = reverseList(nextNode);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head != null && head.next != null) {
            ListNode dNext = dummy.next;
            ListNode hNext = head.next;

            dummy.next = hNext;
            head.next = hNext.next;
            hNext.next = dNext;
        }
        return dummy.next;
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
