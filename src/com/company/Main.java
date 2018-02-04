package com.company;

import java.net.URL;

public class Main {

    public static void main(String[] args) {
        URL path = Main.class.getResource("test.txt");
        Poset poset = new Poset(path.getFile()); // INIT (C)
        poset.deleteMin(null); // DelMin(∅)
        poset.deleteMin(3); // DelMin(3)
        poset.deleteMin(1); // DelMin(1)
        poset.listMin(); // ListMin
    }
}
