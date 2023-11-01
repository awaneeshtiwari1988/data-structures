package com.practice.data.structures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    private int vertices;
    private List<List<Integer>> adjacentList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacentList = new ArrayList<>();
        for(int i = 0; i < vertices;i++){
            this.adjacentList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination){
        this.adjacentList.get(source).add(destination);
    }

    public void bfs(){
        boolean[] visited = new boolean[vertices];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                bfsHelper(i, visited);
            }
        }
    }

    private void bfsHelper(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");

            for(int neighbor : this.adjacentList.get(current)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        // Adding edges to the graph
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        System.out.println("BFS traversal of the disconnected graph:");
        graph.bfs();
    }

}
