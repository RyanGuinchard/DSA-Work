package com.keyin.FinalSprint.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keyin.FinalSprint.Entities.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeServiceTest {

    @Test
    public void testProcessUserNums() {
        BinaryTreeService service = new BinaryTreeService();
        service.processUserNums("5,8,7,2");

        BinaryTree tree = service.getBinaryTree();

        assertNotNull(tree);
        assertEquals(5, tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getLeft().getValue());
    }

    @Test
    public void testConvertTreeToJSON() throws JsonProcessingException {
        BinaryTreeService service = new BinaryTreeService();
        service.processUserNums("5,8,7,2");

        String json = service.convertTreeToJson(service.getBinaryTree().getRoot());

        assertNotNull(json);
        assertTrue(json.contains("\"value\":5"));
        assertTrue(json.contains("\"left\":{\"value\":2"));
        assertTrue(json.contains("\"right\":{\"value\":8"));
        assertTrue(json.contains("\"left\":{\"value\":7"));
    }
}
