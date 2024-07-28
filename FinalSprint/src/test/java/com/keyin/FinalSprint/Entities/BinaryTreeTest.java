package com.keyin.FinalSprint.Entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testInsert() {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        tree.insert(2);

        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().value);
        assertEquals(2, tree.getRoot().left.value);
    }
}
