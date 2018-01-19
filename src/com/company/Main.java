package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //the file consists of several lines. each line is a node and its adjacent nodes collection splitted by space
        Map<Integer, ArrayList<Integer>> adjList = readAdjList("test.txt");
        Poset poset = new Poset(adjList); // init the poset

    }

    private static Map<Integer, ArrayList<Integer>> readAdjList(String fileName)
    {
        Map<Integer, ArrayList<Integer>> agjList = new HashMap<>();
        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                String [] parsedLine = line.split(" ");
                ArrayList<Integer> adjNodes = new ArrayList<>();
                for (String aParsedLine : parsedLine) {
                    adjNodes.add(Integer.parseInt(aParsedLine));
                }
                agjList.put(Integer.parseInt(parsedLine[0]), adjNodes);
            }

            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return agjList;
    }
}
