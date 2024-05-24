package com.rushiwarade;

import java.util.Arrays;
import java.util.Collections;

public class SwiftLogistics {

    public static int minContainersNeeded(int[] shipments, Integer[] containerLimits) {
        // Sort the containers in descending order
        Arrays.sort(containerLimits, Collections.reverseOrder());

        // Array to track the remaining capacity of each container
        Integer[] remainingCapacity = Arrays.copyOf(containerLimits, containerLimits.length);

        // Index to track the current container being used
        int containerIndex = 0;

        // Iterate over each shipment
        for (int shipment : shipments) {
            while (shipment > 0 && containerIndex < remainingCapacity.length) {
                // If current container can hold the entire shipment or part of it
                if (remainingCapacity[containerIndex] >= shipment) {
                    remainingCapacity[containerIndex] -= shipment;
                    shipment = 0;
                } else {
                    shipment -= remainingCapacity[containerIndex];
                    remainingCapacity[containerIndex] = 0;
                    containerIndex++;
                }
            }

            // If we run out of containers and still have shipment left
            if (shipment > 0) {
                return -1;
            }
        }

        // Number of containers used is the index of the last used container + 1
        return containerIndex + 1;
    }

    public static void main(String[] args) {
        int[] shipments = {10, 20, 30};
        Integer[] containerLimits = {15, 15, 20, 10};

        int result = minContainersNeeded(shipments, containerLimits);
        System.out.println("Minimum number of containers needed: " + result);
    }
}
