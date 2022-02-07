package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphImplTest {

    Graph friends;

    @BeforeEach
    void setUp() {
        friends = new GraphImpl();
        friends.addVertex("Alice");
        friends.addVertex("Bob");
        friends.addVertex("Alice2");
        friends.addVertex("Bob2");
    }

    @Test
    void addVertex() {
        friends.addVertex("Alice");
    }

    @Test
    void removeVertex() {
        friends.removeVertex("Alice");
    }

    @Test
    void addEdge() {
        friends.addEdge("Alice", "Bob");
        friends.addEdge("Alice", "Alice2");
        friends.addEdge("Bob", "Bob2");
    }

    @Test
    void removeEdge() {
        friends.removeEdge("Alice", "Bob");
    }
}