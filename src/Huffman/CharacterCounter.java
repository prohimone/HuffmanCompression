package Huffman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Pradipta on 1/13/2015.
 */
public class CharacterCounter {

    private TreeMap<Character, Integer> charCounter;


    public CharacterCounter(String line){
        this.charCounter = new TreeMap<Character, Integer>();
        for(int i = 0; i < line.length(); i++){
            System.out.println(charCounter.containsKey(line.charAt(i)));
            if(!charCounter.containsKey(line.charAt(i)))
                charCounter.put(line.charAt(i), 1);
            else
                charCounter.put(line.charAt(i), charCounter.get(line.charAt(i))+1);
        }

    }

    public CharacterCounter(FileReader f){

        this.charCounter = new TreeMap<Character, Integer>();
        try{
            BufferedReader br = new BufferedReader(f);
            String line = br.readLine();
            while(line != null){
                for(int i = 0; i < line.length(); i++){
                    if(!charCounter.containsKey(line.charAt(i)))
                        charCounter.put(line.charAt(i), 1);
                    else
                        charCounter.put(line.charAt(i), charCounter.get(line.charAt(i))+1);

                }

                line = br.readLine();
                if(!charCounter.containsKey('\n'))
                    charCounter.put('\n', 1);
                else
                    charCounter.put('\n', charCounter.get('\n')+1);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public Set<Character> getCharacters(){
        return charCounter.keySet();
    }

    public TreeMap<Character, Integer> getCharCounter(){
        return charCounter;
    }

}




