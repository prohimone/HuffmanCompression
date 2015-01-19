package Huffman;
import java.io.*;import java.io.FileNotFoundException;import java.io.FileReader;import java.lang.String;import java.lang.System;
import java.util.BitSet;
import java.util.Map;

public class HuffmanCompression {

    public static void main(String[] args) {
        try {
            compress(new FileReader("texts.txt"));


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void compress(FileReader f){
        CharacterCounter c = new CharacterCounter(f);
        HuffmanTree t = new HuffmanTree(c.getCharCounter());
        System.out.println(t.getRoot());
        System.out.println(t.getMapping());
        try{
            f.close();

            f = new FileReader("texts.txt");
            BitSet bs = encodeFile(f, t.getMapping());

/*            String bs = encodeFile(new FileReader("texts.txt"), t);
            byte[] bytes = bs.getBytes();
            for(int i = 0; i<bytes.length;i++){
                System.out.print(Integer.toBinaryString(bytes[i]));
            }
            System.out.println();*/

            System.out.println(bs);
            ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("compressed_text.ser"));
            oos.writeObject(bs);

            f.close();
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }



    }

    public static BitSet encodeFile(FileReader f, Map<Character, String> mapping){
        BitSet bitSet = new BitSet();
        int bitIndex = 0;
        String text = "";
            try{
                BufferedReader br = new BufferedReader(f);
                String line = br.readLine();

/*
                String copy = line;
                for(int i = 0; i<copy.length();i++){
                    int number = Integer.parseInt(String.valueOf(copy.charAt(i)), 16);
                    String binary = Integer.toBinaryString(number);
                    System.out.print(binary + " ");
                }
                System.out.println();
*/

                for(int i = 0; i < line.length(); i++) {
                    String curCharEncoding = mapping.get(line.charAt(i));
                    text += curCharEncoding;
                    for(int j = 0; j<curCharEncoding.length(); j++){
                        if(curCharEncoding.charAt(j) == '0') {
                            bitSet.set(bitIndex, false);
                            bitIndex++;
                        }else{
                            bitSet.set(bitIndex, true);
                            bitIndex++;
                        }
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        //return text;
        return bitSet;

    }
}

