package core;

import utils.Huffman;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        Huffman huffman = new Huffman();
        LinkedHashMap<Character, String> codes = huffman.Compress("abcaacbbbb");
    }
}
