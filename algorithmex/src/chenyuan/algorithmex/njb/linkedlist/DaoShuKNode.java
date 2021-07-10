package chenyuan.algorithmex.njb.linkedlist;

/**
 * @author chenyuan
 */
public class DaoShuKNode {

    static class Node {
        int e;
        Node next;
        public Node(int e) {this.e = e;}
        public Node add(Node n) { this.next = n; return n;}
    }

    static Node findK(Node head, int k) {
        if (k <= 0) {
            return null;
        }
        Node[] cache = new Node[k];
        int n = 0;
        Node cur = head;
        while (cur != null) {
            cache[n % k] = cur;
            cur = cur.next;
            n ++;
        }
        if (n < k) {
            return null;
        }
        return cache[(n - k) % k];
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.add(n2).add(n3).add(n4).add(n5).add(n6).add(n7).add(n8).add(n9).add(n10);


//        Node kn = findK(n1, 4);
//        System.out.println(kn.e);

        System.out.println(findK(n1, 0));
        System.out.println(findK(n1, 1).e);
        System.out.println(findK(n1, 2).e);
        System.out.println(findK(n1, 3).e);
        System.out.println(findK(n1, 4).e);
        System.out.println(findK(n1, 5).e);
        System.out.println(findK(n1, 6).e);
        System.out.println(findK(n1, 7).e);
        System.out.println(findK(n1, 8).e);
        System.out.println(findK(n1, 9).e);
        System.out.println(findK(n1, 10).e);
        System.out.println(findK(n1, 11).e);
    }


}
