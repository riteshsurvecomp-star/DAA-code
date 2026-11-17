import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class Huffman {

    public static void main(String[] args) {

        char[] ch = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[] freq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        for (int i = 0; i < ch.length; i++) {
            pq.add(new Node(ch[i], freq[i]));
        }

        while (pq.size() > 1) {

            Node n1 = pq.poll();
            Node n2 = pq.poll();

            Node parent = new Node('-', n1.freq + n2.freq);

            parent.left = n1;
            parent.right = n2;

            pq.add(parent);
        }

        print(pq.poll(), "");
    }

    static void print(Node root, String code) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
        }

        print(root.left, code + "0");
        print(root.right, code + "1");
    }
}