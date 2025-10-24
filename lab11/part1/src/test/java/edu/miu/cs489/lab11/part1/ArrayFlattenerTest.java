package edu.miu.cs489.lab11.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTest {

    @Test
    void flattenArray_valid() {
        var flattener = new ArrayFlattener();
        int[][] input = {{1,3},{0},{4,5,9}};
        int[] expected = {1,3,0,4,5,9};
        assertArrayEquals(expected, flattener.flattenArray(input));
    }

    @Test
    void flattenArray_null() {
        var flattener = new ArrayFlattener();
        assertNull(flattener.flattenArray(null));
    }
}
