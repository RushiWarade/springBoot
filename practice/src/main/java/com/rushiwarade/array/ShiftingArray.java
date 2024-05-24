package com.rushiwarade.array;

public class ShiftingArray {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 1, 0, 0, 1, 1, 0};
        // 0,0,0,0,0, 1,1,1,1
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        for (int temp : array) {
            System.out.print(temp + " ");
        }

    }
    }

