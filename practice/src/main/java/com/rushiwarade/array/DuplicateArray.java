package com.rushiwarade.array;

public class DuplicateArray {
        public static void main(String[] args) {
            int[] array = {10, 10, 20, 0, 330, 90, 30, 40, 40, 20};
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        System.out.println("duplicate found " + array[i]);
                    }
                }
            }
        }
    }

