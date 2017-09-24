package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Huffman {

    private LinkedList<Node> occurrencesQueue = new LinkedList<>();

    public Huffman() { }

    public void Compress(String input) {
        occurrencesQueue = sortQueue(buildPriorityQueue(input));
        buildHuffmanTree(occurrencesQueue);
    }

    private KeyValue<Key, Integer> buildPriorityQueue(String input) {  // refactor
        KeyValue<Key, Integer> queue = new KeyValue<>();
        for (int i = 0; i < input.length(); i++) {
            if (!queue.containsKey(new Key(input.charAt(i)))) {
                int counter = 0;
                for (int j = i; j < input.length(); j++) {
                    if (input.charAt(j) == input.charAt(i)) {
                        counter++;
                    }
                }
                queue.put(new Key(input.charAt(i)),counter);
            }
        }
        return queue;
    }

    private LinkedList<Node> sortQueue(KeyValue<Key, Integer> inputMap) {
        LinkedList<Node> sortedQueue = new LinkedList<>();
        while (!inputMap.isEmpty()) {
            int minIndex = foundMin(inputMap);
            Node node = new Node(inputMap.getEntry(minIndex).getKey().getKey(), inputMap.getEntry(minIndex).getValue(), null, null);
            sortedQueue.add(node);
            inputMap.remove(inputMap.getEntry(minIndex).getKey());
        }
        return sortedQueue;
    }

    private int foundMin(KeyValue<Key, Integer> input) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.getValue(i) < min) {
                min = input.getValue(i);
                index = i;
            }
        }
        return index;
    }

    private Node buildHuffmanTree(LinkedList<Node> occurrencesQueue) { // TODO: implement
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
        for (int i = 0; i < occurrencesQueue.size(); i++) {
            if (i == occurrencesQueue.size() - 1) {
                occurrencesQueue.add(i,insert);
                return;
            }
            if (occurrencesQueue.get(i + 1).getFreq() > insert.getFreq()) {
                occurrencesQueue.add(i,insert);
                return;
            }
        }
    }
}