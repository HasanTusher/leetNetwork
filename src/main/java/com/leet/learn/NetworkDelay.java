package com.leet.learn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NetworkDelay {


    public static int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> integerSet = new HashSet<Integer>();
        int cost = 0;
        integerSet.add(k);
        for(int i=0; i<times.length; i++){
            if(times[i][0] == k){
                Result result = Dfs.getResultByDfs(times, i);
                if(result.getCost() > cost){
                    cost = result.getCost();
                }
                integerSet.addAll(result.getTraversed());
                //System.out.println(result.toString());
            }
        }

        if(integerSet.size() < n){
            return -1;
        }
        return cost;
    }
    public static void main(String[] args) {
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

        networkDelayTime(times, 4, 2);
        System.out.println(integerStack.contains(a));
    }
}
