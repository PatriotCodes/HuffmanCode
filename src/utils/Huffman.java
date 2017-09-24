package utils;

import java.util.List;

public class Huffman {

    public Huffman() { }

    public void Compress(String input) {
        KeyValue<Character, Integer> occurrencesQueue = SortQueue(BuildPriorityQueue(input));
    }

    private KeyValue<Key, Integer> BuildPriorityQueue(String input) {
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

    private KeyValue<Character, Integer> SortQueue(KeyValue<Key, Integer> inputMap) {
        KeyValue<Character, Integer> sortedQueue = new KeyValue<>();
        while (!inputMap.isEmpty()) {
            int minIndex = FoundMin(inputMap);
            sortedQueue.put(inputMap.getEntry(minIndex).getKey().getKey(), inputMap.getEntry(minIndex).getValue());
            inputMap.remove(inputMap.getEntry(minIndex).getKey());
        }
        return sortedQueue;
    }

    private int FoundMin(KeyValue<Key, Integer> input) {
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

    private List<Node<Character>> BiuldHuffmanTree() { // TODO: implement
        return null;
    }
}