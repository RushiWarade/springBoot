package com.rushiwarade.array;

import java.util.Arrays;

public class AscendingOrder {
    public static void main(String[] args) {

        int [] number = {66,85,21,1,25,54,63};
        Arrays.sort(number);

        for (int index = 0; index < number.length; index++) {
            System.out.println(number[index]);
        }

    }
}
