package utils;

public class Node implements Comparable<Node> {
    private final Character ch;
    private final int freq;
    private final Node left, right;

    Node() {
        this.ch    = null;
        this.freq  = 0;
        this.left  = null;
        this.right = null;
    }

    Node(Character ch, int freq, Node left, Node right) {
        this.ch    = ch;
        this.freq  = freq;
        this.left  = left;
        this.right = right;
    }

    public int getFreq() {
        return freq;
    }

    // is the node a leaf node?
    private boolean isLeaf() {
        assert ((left == null) && (right == null)) || ((left != null) && (right != null));
        return (left == null) && (right == null);
    }

    // compare, based on frequency
    public int compareTo(Node that) {
        return this.freq - that.freq;
    }
}