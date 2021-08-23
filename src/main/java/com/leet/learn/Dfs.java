package com.leet.learn;

import java.util.Stack;

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
    public static Result getResultByDfs(int[][] arr, int startingIndex){
        Stack<Integer> integerStack = new Stack<Integer>();
        Result result = new Result();
        result.setIteration(1);
        result.setCost(arr[startingIndex][2]);

        integerStack.push(arr[startingIndex][1]);
        //int source = arr[startingIndex][0];
        while (!integerStack.isEmpty()){
            int popped = integerStack.pop();

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
