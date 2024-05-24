package com.rushiwarade;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            // If we have already seen this node, then there is a cycle
            if (visitedNodes.contains(currentNode)) {
                return true;
            }

            // Add the current node to the set of visited nodes
            visitedNodes.add(currentNode);

            // Move to the next node
            currentNode = currentNode.next;
        }

        // If we reach the end of the list, there is no cycle
        return false;
    }

    public static void main(String[] args) {
        // Example 1
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        ListNode node4 = new ListNode(60);
        ListNode node5 = new ListNode(80);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;  // creates a cycle

        LinkedListCycle solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(node1));  // Output: true

        // Example 2
        ListNode nodeA = new ListNode(6);
        ListNode nodeB = new ListNode(4);
        ListNode nodeC = new ListNode(2);
        ListNode nodeD = new ListNode(8);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        System.out.println(solution.hasCycle(nodeA));  // Output: false
    }
}

