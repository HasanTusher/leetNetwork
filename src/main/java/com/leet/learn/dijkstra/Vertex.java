package com.leet.learn.dijkstra;

public class Vertex implements Comparable<Vertex> {
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

    public int compareTo(Vertex vertex) {
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
