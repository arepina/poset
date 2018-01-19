package com.company;


import java.util.ArrayList;
import java.util.Map;

class Poset {

    private int n; // elements number in poset
    private Map<Integer, ArrayList<Integer>> agjList;

    /**
     * Init(C)
     * O(|P|^2)
     * @param agjList Cover graph C = (P, E) - an adjacency list
     */
    Poset(Map<Integer, ArrayList<Integer>> agjList)
    {
        this.n = agjList.size();
        this.agjList = agjList;
    }

    /**
     * DelMin(x): Removes the given param from the represented poset
     * O(|P|)
     * @param x minimal element x
     * @return success
     */
    boolean deleteMin(int x)
    {
        //todo
        return false;
    }

    /**
     * ListMin: Outputs a list that contains every minimal element of the poset exactly once (and nothing else)
     * O(|P|)
     */
    void listMin()
    {
        int min = 0;
        //todo
    }

}
