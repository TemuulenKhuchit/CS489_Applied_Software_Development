package edu.miu.cs489.lab11.part1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayReversor {
    private final ArrayFlattenerService flattenerService;

    public ArrayReversor(ArrayFlattenerService flattenerService) {
        this.flattenerService = flattenerService;
    }

    public int[] reverseArray(int[][] input) {
        int[] flat = flattenerService.flattenArray(input);
        if (flat == null) return null;
        List<Integer> list = IntStream.of(flat).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
