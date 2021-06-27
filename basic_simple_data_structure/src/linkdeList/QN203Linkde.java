package linkdeList;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * @author wjq
 * @date 2021/6/19 14:52
 * @since 1.0.0
 **/
public class QN203Linkde {

    public static void main(String[] args) {
        ListNode nodestr = new ListNode(0); //创建首结点
        ListNode nextNode;     //创建下一个结点
        nextNode = nodestr;    //指向首结点
        //创建链表
        for(int i = 1;i<10;i++){
            ListNode newnode = new ListNode(i);  //创建新的结点
            nextNode.next = newnode;     // 把新结点连起来
            nextNode = nextNode.next; //把结点往后移
        }//nextNode指向最后一个结点
        nextNode = nodestr;  //重新指向首结点

//        while(nextNode != null){
//            System.out.println("第一个结点值："+ nextNode.val);
//            nextNode = nextNode.next;
//        }

        int val = 6;
        ListNode listNode = removeElements(nextNode, val);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        //任意元素位置的头部节点(操作链表的入口)
        ListNode dummy = new ListNode(0);
        //移动头指针head
        dummy.next=head;
        //移动头指针的prev
        ListNode prev = dummy;

        while (head != null) {//链表末尾指向null
            //head指向val
            if (head.val == val) {
                prev.next = head.next;
            } else {
                //head不指向val
                prev = head;
            }
            head = head.next;
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


//    public static ListNode removeElements(ListNode head, int val) {
//        //任意元素位置的头部节点(操作链表的入口)
//        ListNode dummy = new ListNode(0);
//        //移动头指针head
//        dummy.next=head;
//        //移动头指针的prev
//        ListNode prev = dummy;
//
//        while (head != null) {//链表末尾指向null
//            //head指向val
//            if (head.val == val) {
//                prev.next = head.next;
//                head = head.next;
//            } else {
//                //head不指向val
//                prev = head;
//                head = head.next;
//            }
//        }
//        return dummy.next;
//    }
}
