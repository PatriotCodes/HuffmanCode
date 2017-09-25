package utils;

import java.util.LinkedHashMap;

public class Node {
    private final Character ch;
    private int freq;
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

    public LinkedHashMap<Character, String> recPreOrder(LinkedHashMap<Character, String> result, StringBuilder bits){
        if (this.isLeaf()) {
            result.put(this.ch,bits.toString());
        }
        if (left!=null) {
            bits.append(0);
            left.recPreOrder(result, bits);
        }
        if (right!=null) {
            bits.append(1);
            right.recPreOrder(result, bits);
        }
        if (bits.length() != 0) {
            bits.deleteCharAt(bits.length() - 1);
        }
        return result;
    }

    public int getFreq() { return freq; }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    // is the node a leaf node?
    private boolean isLeaf() {
        assert ((left == null) && (right == null)) || ((left != null) && (right != null));
        return (left == null) && (right == null);
    }

    @Override
    public int hashCode() {
        return ch.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode())
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return false;
    }
}