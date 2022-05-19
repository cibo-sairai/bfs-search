package com.zaremba.graphs;

import java.io.*;
import java.util.*;
//the breadth first search project

public class Main {
    public static ArrayList<com.zaremba.graphs.Node> graph;
    static int node;

    public static LinkedList<Node> adj2 = new LinkedList<Node>();

    private static int x;


    
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        System.out.println("Printing LinkedList");



        for (int i = 0; i < adj2.size(); i++)

            System.out.print(" [ " + adj2.get(i) + " ] ");

        System.out.println("\n");

        BFS();



    }

    static void BFS() {
//queue for bfs
        ArrayList<Integer> queue = new ArrayList<>();

        queue.add(1);

        for(int x = 0; x < queue.size(); x++) {
            //hold queue = holdQueue
            int holdQueue = queue.get(x) - 1;

            int keys = adj2.get(holdQueue).getKey();

            System.out.println("Key Index is: " + keys);

            ArrayList<Integer> Nodes = (ArrayList<Integer>) graph.get(holdQueue).getNodes();

            System.out.println("Adjacent Nodes:" + Nodes);

            for (int i = 0; i < Nodes.size(); i++) {
                //check place in node
                int nodeCheck = Nodes.get(i);

                if (!queue.contains(nodeCheck))
                    //add to queue node item
                    queue.add(nodeCheck);
            }
            System.out.println("Queue:" + queue + "\n");
        }



        
   
    }

    private static void setupTree() throws FileNotFoundException {

        File f = new File("/Users/max/IdeaProjects/graphs-bfs/src/com/zaremba/graphs/tree.txt");
        graph = new ArrayList<Node>();
        Scanner scan = new Scanner(f);
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);




        }

    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);


        ArrayList<Integer> points = new ArrayList<>();


        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));

        }


        graph.add(new Node(key, points));
        adj2.add(new Node(key, points));

        //queue.add(keys.length);
    }
}


