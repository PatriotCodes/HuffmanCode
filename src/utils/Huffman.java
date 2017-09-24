package utils;

import java.util.LinkedList;

public class Huffman {

    private LinkedList<Node> occurrencesQueue = new LinkedList<>();
    private Node huffmanTree;

    public Huffman() { }

    public void Compress(String input) {
        buildPriorityQueue(input);
        huffmanTree = buildHuffmanTree(occurrencesQueue);
    }

    private void buildPriorityQueue(String input) {  // refactor
        for (int i = 0; i < input.length(); i++) {
            Node tmp = new Node(input.charAt(i),1,null,null);
            if (!occurrencesQueue.contains(tmp)) {
                int counter = 0;
                for (int j = i; j < input.length(); j++) {
                    if (input.charAt(j) == input.charAt(i)) {
                        counter++;
                    }
                }
                tmp.setFreq(counter);
                insertToQueue(tmp);
            }
        }
    }

    private Node buildHuffmanTree(LinkedList<Node> occurrencesQueue) {
        Node huffmanTree = new Node();
        while (!occurrencesQueue.isEmpty()) {
            int freq = occurrencesQueue.get(0).getFreq() + occurrencesQueue.get(1).getFreq();
            Node left = occurrencesQueue.get(0);
            Node right = occurrencesQueue.get(1);
            Node node = new Node(null, freq, left, right);
            occurrencesQueue.remove(0);
            occurrencesQueue.remove(0);
            if (occurrencesQueue.isEmpty()) {
                huffmanTree = node;
                return huffmanTree;
            }
            insertToQueue(node);
        }
        return huffmanTree;
    }

    private void insertToQueue(Node insert) {
        if (occurrencesQueue.isEmpty()) {
            occurrencesQueue.add(insert);
            return;
        }
        for (int i = 0; i < occurrencesQueue.size(); i++) {
            if (i == occurrencesQueue.size() - 1) {
                if (occurrencesQueue.get(i).getFreq() > insert.getFreq()) {
                    occurrencesQueue.add(i,insert);
                } else {
                    occurrencesQueue.add(i + 1,insert);
                }
                return;
            }
            if (occurrencesQueue.get(i + 1).getFreq() > insert.getFreq()) {
                occurrencesQueue.add(i,insert);
                return;
            }
        }
    }
}