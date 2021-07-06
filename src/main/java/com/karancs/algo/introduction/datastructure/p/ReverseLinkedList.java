package com.karancs.algo.introduction.datastructure.p;


import com.karancs.algo.introduction.Practice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyuan on 2018/1/14.
 */
@Practice(id = "10-2-7")
public class ReverseLinkedList {

    private class Node {
        private Object e;
        private Node next;
        Node(int i) { this.e = i; }
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private void printList(Node head) {
        List<String> strList = new ArrayList<>();
        Node node = head;
        while (node != null) {
            strList.add(String.valueOf(node.e));
            node = node.next;
        }
        System.out.println(String.join("->", strList.toArray(new String[0])));
    }

    @Test
    public void demonstrate() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;

        Node reversed = reverse(n1);

        printList(reversed);
        printList(reversed);
    }
}
