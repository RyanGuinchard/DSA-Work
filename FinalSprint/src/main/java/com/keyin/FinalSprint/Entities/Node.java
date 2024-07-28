package com.keyin.FinalSprint.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Node {
    @JsonProperty
    int value;
    @JsonProperty
    Node left;
    @JsonProperty
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

