package com.leet.learn;

import java.util.Stack;

public class NetworkDelay {


    public static int networkDelayTime(int[][] times, int n, int k) {
        for(int i=0; i<times.length; i++){
            if(times[i][0] == k){
                Result result = Dfs.getResultByDfs(times, i);
                System.out.println(result.toString());
            }
        }
        return 0;
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
