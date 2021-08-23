package com.leet.learn;

import java.util.ArrayList;
import java.util.List;

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
