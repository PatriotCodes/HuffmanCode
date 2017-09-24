package utils;

import java.util.*;

public class Huffman {

    public Huffman() { }

    public void Compress(String input) {
        SortQueue(BuildPriorityQueue(input));
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

    private KeyValue<Character, Integer> SortQueue(Map<Key, Integer> inputMap) {
        KeyValue<Character, Integer> sortedQueue = new KeyValue<>();
        while (!inputMap.isEmpty()) {

        }
        return sortedQueue;
    }
}