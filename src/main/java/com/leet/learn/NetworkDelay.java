package com.leet.learn;

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
        Dfs dfs = new Dfs();
        Set<Integer> integerSet = new HashSet<Integer>();
        int cost = 0;
        integerSet.add(k);
        for(int i=0; i<times.length; i++){
            if(times[i][0] == k){
                Result result = dfs.getResultByDfs(times, i);
                if(result.getCost() > cost){
                    cost = result.getCost();
                }
                integerSet.addAll(result.getTraversed());
                System.out.println(result.toString());
            }
        }

        if(integerSet.size() < n){
            return -1;
        }
        return cost;
    }
    public static void main(String[] args) {
        NetworkDelay networkDelay = new NetworkDelay();
        int[][] times = {
                {2,1,1}, // source, dest, time
                {2,3,1},
                {3,4,1}
        };
        //n = 4, 4 nodes need to be reached
        //k = 2 ; //starting node
        Stack<Integer> integerStack =  new Stack<Integer>();
        integerStack.push(1);
        int a = 1;

        networkDelay.networkDelayTime(times, 4, 2);
        System.out.println(integerStack.contains(a));
    }
}
