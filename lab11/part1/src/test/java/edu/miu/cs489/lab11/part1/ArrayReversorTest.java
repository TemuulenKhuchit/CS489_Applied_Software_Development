package edu.miu.cs489.lab11.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayReversorTest {

    @Test
    void reverseArray_valid_usesService() {
        var mockService = mock(ArrayFlattenerService.class);
        int[][] input = {{1,3},{0},{4,5,9}};
        when(mockService.flattenArray(input)).thenReturn(new int[]{1,3,0,4,5,9});

        var reversor = new ArrayReversor(mockService);
        assertArrayEquals(new int[]{9,5,4,0,3,1}, reversor.reverseArray(input));
        verify(mockService, times(1)).flattenArray(input);
    }

    @Test
    void reverseArray_null_usesService() {
        var mockService = mock(ArrayFlattenerService.class);
        when(mockService.flattenArray(null)).thenReturn(null);

        var reversor = new ArrayReversor(mockService);
        assertNull(reversor.reverseArray(null));
        verify(mockService, times(1)).flattenArray(null);
    }
}
