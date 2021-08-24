package com.leet.learn.dijkstra;

import java.util.*;

public class NetworkDelay {

    public class Result {
        int cost;
        int iteration;
        List<Integer> traversed;

        public Result() {
            this.traversed = new ArrayList<Integer>();
        }

        public List<Integer> getTraversed() {
            return traversed;
        }

        public void setTraversed(List<Integer> traversed) {
            this.traversed = traversed;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getIteration() {
            return iteration;
        }

        public void setIteration(int iteration) {
            this.iteration = iteration;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "cost=" + cost +
                    ", iteration=" + iteration +
                    ", integerList=" + traversed +
                    '}';
        }
    }


    public class Dfs {


        /**
         *
         *  {2,1,1}, // source, dest, time
         *  {2,3,1},
         *  {3,4,1}
         *
         * @param arr
         * @param startingIndex
         * @return
         */
        public Result getResultByDfs(int[][] arr, int startingIndex){
            Stack<Integer> integerStack = new Stack<Integer>();
            Result result = new Result();
            result.setIteration(1);
            result.setCost(arr[startingIndex][2]);

            integerStack.push(arr[startingIndex][1]);
            //int source = arr[startingIndex][0];
            while (!integerStack.isEmpty()){
                int popped = integerStack.pop();
                result.getTraversed().add(popped);
                for(int i = 0; i< arr.length; i++){
                    if(arr[i][0] == popped){ //found
                        //push in the stack
                        integerStack.push(arr[i][1]);
                        result.setIteration(result.getIteration()+1);
                        result.setCost(result.getCost()+arr[i][2]);
                    }
                }

            }
            return result;
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
    public static void main(String[] args) {
        NetworkDelay networkDelay = new NetworkDelay();
        int[][] times = {
//                {2,1,1}, // source, dest, time
//                {2,3,1},
//                {3,2,1}
                {1,2,1}, // source, dest, time
                {2,3,2},
                {1,3,2}
        };

        //networkDelay.networkDelayTime(times, 3, 1);
        System.out.println(networkDelay.networkDelayTime(times, 3, 1));
        //System.out.println(integerStack.contains(a));
    }
}
