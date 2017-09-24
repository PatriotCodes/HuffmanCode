package core;

import utils.Huffman;

public class Main {

    public static void main(String[] args) {
        Huffman huffman = new Huffman();
        huffman.Compress("abcaacbbbb");
    }
}
