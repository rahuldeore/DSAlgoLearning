package com.rahul.dsalgo.datastructure.logical;

public interface Graph {

    /**
     *
     * */
    void addVertex(String label);

    /**
     *
     * */
    void removeVertex(String label);

    /**
     *
     * */
    void addEdge(String label1, String label2);

    /**
     *
     * */
    void removeEdge(String label1, String label2);

    /**
     * Need to add BFS and DFS traverse methods
     * */
    void traverseBFS();

    /**
     *
     * */
    void traverseDFS();
}
