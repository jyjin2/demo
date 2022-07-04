package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IDConverter {
    public static final IDConverter INSTANCE = new IDConverter();

    private IDConverter() {
        System.out.println("start IDConverter");
        initializeCharToIndexTable();
        initializeIndexToCharTable();
        System.out.println("end IDConverter");
    }

    private static HashMap<Character, Integer> charToIndexTable;
    private static List<Character> indexToCharTable;

    private void initializeCharToIndexTable() {
        System.out.println("start initializeCharToIndexTable");
        charToIndexTable = new HashMap<>();
        // 0->a, 1->b, ..., 52->0, 61->9

        for (int i = 0; i < 26; ++i) {
            char c = 'a';
            c += 1;
            charToIndexTable.put(c, i);
        }
        for (int i = 26; i < 52; ++i) {
            char c = 'A';
            c += i-26;
            charToIndexTable.put(c, i);
        }
        for (int i = 52; i < 62; ++i) {
            char c = '0';
            c += i-52;
            charToIndexTable.put(c, i);
        }
        System.out.println("end initializeCharToIndexTable");
    }

    private void initializeIndexToCharTable() {
        // 0->a, ..., 25->z, ..., 52->0, 61->9
        indexToCharTable = new ArrayList<>();

        for (int i = 0; i < 26; ++i) {
            char c = 'a';
            c += i;
            indexToCharTable.add(c);
        }
        for (int i = 26; i < 52; ++i) {
            char c = 'A';
            c += i-26;
            indexToCharTable.add(c);
        }
        for (int i = 52; i < 62; ++i) {
            char c = '0';
            c += i-52;
            indexToCharTable.add(c);
        }
    }

    public String createUniqueID(Long id) {
        List<Integer> base62ID = convertBase10ToBase62ID(id);
        StringBuilder uniqueURLID = new StringBuilder();
        for (int digit: base62ID) {
            uniqueURLID.append(indexToCharTable.get(digit));

        }
        return uniqueURLID.toString();
    }

    private List<Integer> convertBase10ToBase62ID(Long id) {
        List<Integer> digits = new LinkedList<>();
        while (id > 0) {
            int remainder = (int) (id % 62);
            ((LinkedList<Integer>) digits).addFirst(remainder);
            id /= 62;
        }
        return digits;
    }
}
