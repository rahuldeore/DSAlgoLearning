package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.Graph;
import com.rahul.dsalgo.datastructureImpl.logical.components.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
    private Map<Vertex, List<Vertex>> adjVertices;


    public GraphImpl() {
        adjVertices = new HashMap<>();
    }

    @Override
    public void addVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.putIfAbsent(v, new LinkedList<>());
    }

    @Override
    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        // delete edges
        adjVertices.entrySet().stream().forEach(vertexListEntry -> {
            vertexListEntry.getValue().remove(v);
        });
        // delete vertex
        adjVertices.remove(v);
    }

    @Override
    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        addVertex(label1);
        addVertex(label1);

        if (adjVertices.get(v1).indexOf(v2) == -1) {
            adjVertices.get(v1).add(v2);
        }
        if (adjVertices.get(v2).indexOf(v1) == -1) {
            adjVertices.get(v2).add(v1);
        }
    }

    @Override
    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        if (adjVertices.get(v1) != null) {
            adjVertices.get(v1).remove(v2);
        }
        if (adjVertices.get(v2) != null) {
            adjVertices.get(v2).remove(v1);
        }
    }

    @Override
    public void traverseBFS() {

    }

    @Override
    public void traverseDFS() {

    }
}
