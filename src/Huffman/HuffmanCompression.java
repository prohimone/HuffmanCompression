package Huffman;
import java.io.*;import java.io.FileNotFoundException;import java.io.FileReader;import java.lang.String;import java.lang.System;

public class HuffmanCompression {

    public static void main(String[] args) {
        // write your code here
        try {
            CharacterCounter c = new CharacterCounter(new FileReader("texts.txt"));
            System.out.println(c.getCharCounter());

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

