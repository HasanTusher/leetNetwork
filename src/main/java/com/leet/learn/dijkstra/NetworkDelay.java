package com.leet.learn.dijkstra;

import java.util.*;

public class NetworkDelay {

    public class Vertex implements Comparable<com.leet.learn.dijkstra.Vertex> {
        int dest;
        int cost;

        public Vertex() {
        }

        public Vertex(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int compareTo(com.leet.learn.dijkstra.Vertex vertex) {
            return this.cost > vertex.cost ? 1 : -1;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "dest=" + dest +
                    ", cost=" + cost +
                    '}';
        }
    }


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
                //System.out.println(priorityQueue);
            }
            return costMap;
        }

        private void findDestinations(int[][] arr, int source, int currentCost, PriorityQueue<Vertex> vertices, List<Integer> visited, HashMap<Integer, Integer> costMap){
            //System.out.println("searching for:" + source);
            //System.out.println(visited);
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

    public  int networkDelayTime(int[][] times, int n, int k) {
        Dijkstra dijkstra = new Dijkstra();
        HashMap<Integer, Integer> integerIntegerHashMap = dijkstra.getShortestPathToAll(times, k);
        int size = integerIntegerHashMap.size();
        if(size < n)
            return -1;
        int result = 0;
        for(HashMap.Entry<Integer, Integer> item: integerIntegerHashMap.entrySet()){
            if(result < item.getValue()) result = item.getValue();
        }

        return result;
    }
//    public static void main(String[] args) {
//        NetworkDelay networkDelay = new NetworkDelay();
//        int[][] times = {
//                {2,1,1}, // source, dest, time
//                {2,3,1},
//                {3,4,1}
////                {1,2,1}, // source, dest, time
////                {2,3,2},
////                {1,3,2}
//        };
//
//        //networkDelay.networkDelayTime(times, 3, 1);
//        System.out.println(networkDelay.networkDelayTime(times, 4, 2));
//        //System.out.println(integerStack.contains(a));
//    }
}
