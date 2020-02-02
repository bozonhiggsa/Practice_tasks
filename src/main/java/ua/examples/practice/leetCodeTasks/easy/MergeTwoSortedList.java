package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes
 * of the first two lists.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class MergeTwoSortedList extends BaseLogger {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode listNodeResult = null;
        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 == null) return listNodeResult;
        if(l1.val <= l2.val){
            listNodeResult = new ListNode(l1.val);
            l1 = l1.next;
        }
        else{
            listNodeResult = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode listNodeResultInner = listNodeResult;
        while(l1 != null || l2 != null){
            if(l1 == null){
                listNodeResultInner.next = new ListNode(l2.val);
                l2 = l2.next;
                listNodeResultInner = listNodeResultInner.next;
            }
            else if(l2 == null){
                listNodeResultInner.next = new ListNode(l1.val);
                l1 = l1.next;
                listNodeResultInner = listNodeResultInner.next;
            }
            else{
                if(l2.val <= l1.val){
                    listNodeResultInner.next = new ListNode(l2.val);
                    l2 = l2.next;
                    listNodeResultInner = listNodeResultInner.next;
                }
                else if(l1.val < l2.val){
                    listNodeResultInner.next = new ListNode(l1.val);
                    l1 = l1.next;
                    listNodeResultInner = listNodeResultInner.next;
                }
            }
        }
        return listNodeResult;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l1_inner = l1.next;
        l1_inner.next = new ListNode(4);
        ListNode l1_forPrint = l1;
        logger.info("----------------------------");
        logger.info(String.valueOf(l1_forPrint.val));
        while(l1_forPrint.next != null){
            l1_forPrint = l1_forPrint.next;
            logger.info(String.valueOf(l1_forPrint.val));
        }

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        ListNode l2_inner = l2.next;
        l2_inner.next = new ListNode(4);
        ListNode l2_forPrint = l2;
        logger.info("----------------------------");
        logger.info(String.valueOf(l2_forPrint.val));
        while(l2_forPrint.next != null){
            l2_forPrint = l2_forPrint.next;
            logger.info(String.valueOf(l2_forPrint.val));
        }

        ListNode result = new MergeTwoSortedList().mergeTwoLists(l1, l2);

        ListNode result_forPrint = result;
        logger.info("----------------------------");
        logger.info("Result for singly-linked list is:");
        logger.info(String.valueOf(result_forPrint.val));
        while(result_forPrint.next != null){
            result_forPrint = result_forPrint.next;
            logger.info(String.valueOf(result_forPrint.val));
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
