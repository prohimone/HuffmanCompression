package Huffman;

import sun.misc.Compare;

import java.lang.Character;
import java.util.*;

/**
 * Created by Pradipta on 1/13/2015.
 */
public class HuffmanTree {
    private class HuffmanNode implements Comparable<HuffmanNode>{
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

        public boolean isLeaf(){
            if(this.left == null && this.right == null)
                return true;
            else
                return false;
        }

        public String toString(){
            return ch + " = " + count;
        }

        public int compareTo(HuffmanNode other){
            if(this.count < other.count)
                return -1;
            if(this.count > other.count)
                return 1;
            else
                return 0;
        }
    }

    private HuffmanNode root;
    private Map<Character, String> mapping;

    public HuffmanTree(TreeMap<Character, Integer> charCounter){
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();

        for(Character c: charCounter.keySet()) {
            nodeList.add(new HuffmanNode(c, charCounter.get(c), null, null));
        }
        while(nodeList.size() != 1){
            Collections.sort(nodeList);
           // System.out.println(nodeList);
            HuffmanNode parent = new HuffmanNode(null, nodeList.get(0).count +
                    nodeList.get(1).count, nodeList.get(0), nodeList.get(1));

            nodeList.remove(0);
            nodeList.remove(0);
            nodeList.add(parent);

        }

        root = nodeList.get(0);
        mapping = new HashMap<Character, String>();

        buildMapping(mapping, root, "");
    }

    public HuffmanNode getRoot(){
        return root;
    }

    public HuffmanNode getRight(){
        return root.right;
    }

    public HuffmanNode getLeft(){
        return root.left;
    }

    public Map<Character, String> getMapping(){
        return mapping;
    }


    private void buildMapping(Map<Character, String> map, HuffmanNode node, String s){
        if(!node.isLeaf()){
            buildMapping(mapping, node.left, s + '0');
            buildMapping(mapping, node.right, s + '1');
        }
        else
            map.put(node.ch, s);
    }
}
