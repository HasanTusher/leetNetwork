package com.leet.learn.dijkstra;

import java.io.DataInputStream;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

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
        //create a new node
        Vertex vertex = new Vertex(startingNode, 0);
        priorityQueue.add(vertex);

        while (!priorityQueue.isEmpty()){
            Vertex popped = priorityQueue.poll();
            this.findDestinations(arr, popped.dest, priorityQueue);
            System.out.println(priorityQueue);
//            result.getTraversed().add(popped);
//            for(int i = 0; i< arr.length; i++){
//                if(arr[i][0] == popped){ //found
//                    //push in the stack
//                    integerStack.push(arr[i][1]);
//                    result.setIteration(result.getIteration()+1);
//                    result.setCost(result.getCost()+arr[i][2]);
//                }
//            }

        }
        return null;
    }

    private void findDestinations(int[][] arr, int source, PriorityQueue<Vertex> vertices){
        for(int i =0; i< arr.length; i++){
            if(arr[i][0] == source){
                vertices.add(new Vertex(arr[i][1], arr[i][2]));
            }
        }
    }


}
