package com.company;


import javafx.util.Pair;

import java.io.*;
import java.util.*;

class Poset {


    private HashMap<Integer, Pair<HashMap<Integer, Integer>, HashMap<Integer, Integer>>> map;

    /**
     * Init(C)
     * O(|P|^2)
     *
     * @param filename Cover graph C = (P, E) - an adjacency map is stored in file
     */
    Poset(String filename) {
        this.map = new HashMap<>();
        readFile(filename);
    }

    /**
     * DelMin(x): Removes the given param from the represented poset
     * O(|P|)
     *
     * @param x Minimal element x
     */
    void deleteMin(Integer x) {
        Iterator<Map.Entry<Integer, Pair<HashMap<Integer, Integer>, HashMap<Integer, Integer>>>> iter = map.entrySet().iterator();
        while (iter.hasNext()) { // o (P)
            Map.Entry<Integer, Pair<HashMap<Integer, Integer>, HashMap<Integer, Integer>>> entry = iter.next();
            HashMap<Integer, Integer> root = entry.getValue().getKey(); // o (1)
            HashMap<Integer, Integer> children = entry.getValue().getValue(); // o (1)
            if (root.containsValue(x) || children.containsValue(x)) // o (1)
                iter.remove(); // o (1)
        }
    }

    /**
     * ListMin: Outputs a map that contains every minimal element of the poset exactly once (and nothing else)
     * O(|P|)
     */
    void listMin() {
        int min = 0;
        //todo
    }

    /**
     * readFile(): Read the file line by line
     * O(|P|^2)
     *
     * @param fileName Name of file
     */
    private void readFile(String fileName) {
        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                ArrayList<String> edgesRelations = new ArrayList<>(Arrays.asList(line.split(";")));
                for (String relation : edgesRelations) { // o (P)
                    String[] edges = relation.split("-");
                    String root = edges[0];
                    HashMap<Integer, Integer> hashRoot = new HashMap<>();
                    int counter = 0;
                    for (String rootValue : root.split(",")) { // o (P)
                        Integer parsedRootValue = Integer.parseInt(rootValue);
                        hashRoot.put(counter, parsedRootValue);
                        counter++;
                    }
                    String children = edges[1];
                    HashMap<Integer, Integer> childrenRoot = new HashMap<>();
                    counter = 0;
                    for (String childrenValue : children.split(",")) { // o (P)
                        Integer parsedChildrenValue = Integer.parseInt(childrenValue);
                        childrenRoot.put(counter, parsedChildrenValue);
                        counter++;
                    }
                    Pair<HashMap<Integer, Integer>, HashMap<Integer, Integer>> added = new Pair<>(hashRoot, childrenRoot);
                    map.put(lineNumber, added); // o (1)
                    lineNumber++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
