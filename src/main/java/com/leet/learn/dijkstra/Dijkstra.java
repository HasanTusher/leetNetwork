package com.leet.learn.dijkstra;

import java.io.DataInputStream;
import java.util.*;

public class Dijkstra {


    /**
     *
     *  {2,1,1}, // source, dest, time
     *  {2,3,1},
     *  {3,4,1}
     *
     * @param arr
     * @param startingNode
     * @return {
     *
     * }
     */
    public HashMap<Integer, Integer> getShortestPathToAll(int[][] arr, int startingNode){
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
        List<Integer> visited = new ArrayList<Integer>();
        HashMap<Integer, Integer> costMap = new HashMap<Integer, Integer>();
        //create a new node
        Vertex vertex = new Vertex(startingNode, 0);
        priorityQueue.add(vertex);
        while (!priorityQueue.isEmpty()){
            Vertex popped = priorityQueue.poll();
            this.findDestinations(arr, popped.dest, popped.cost, priorityQueue, visited, costMap);
            System.out.println(priorityQueue);
        }
        return costMap;
    }

    private void findDestinations(int[][] arr, int source, int currentCost, PriorityQueue<Vertex> vertices, List<Integer> visited, HashMap<Integer, Integer> costMap){
        System.out.println("searching for:" + source);
        System.out.println(visited);
        for(int i =0; i< arr.length; i++){
            if(arr[i][0] == source){
                if(!visited.contains(arr[i][1]))
                    vertices.add(new Vertex(arr[i][1], currentCost+arr[i][2]));
            }
        }

        if(!visited.contains(source) || costMap.get(source) > currentCost){
           costMap.put(source, currentCost);
        }
        visited.add(source);
//        costMap.put(source, currentCost);
    }


}
