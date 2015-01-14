package Huffman;

import java.lang.Character; /**
 * Created by Pradipta on 1/13/2015.
 */
public class HuffmanTree {
    private class HuffmanNode{
        Character ch;
        int count;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(Character ch, int count, HuffmanNode left, HuffmanNode right){
            this.ch = ch;
            this.count = count;
            this.left = left;
            this.right = right;
        }

    }
}
