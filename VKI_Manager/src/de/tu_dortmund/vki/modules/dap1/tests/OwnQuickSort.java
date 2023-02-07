package de.tu_dortmund.vki.modules.dap1.tests;

import java.util.Arrays;



public class OwnQuickSort {
    int[] arr;
    int step;

    public  OwnQuickSort(int[] arr) {
        this.arr = arr;
        this.step = 0;
        this.groupByNumber(0, arr.length - 1);
    }

    private void groupByNumber(int leftBound, int rightBound) {
        if(leftBound < rightBound) {
            int leftOfGreaterPart = leftBound;

            for(int candidate = leftBound; candidate < rightBound; candidate++) {
                log("Checking if rightBound > candidate",
                        candidate, arr[candidate], leftBound, arr[leftBound], rightBound, arr[rightBound],
                        leftOfGreaterPart , arr[leftOfGreaterPart], Arrays.copyOf(this.arr, arr.length));
                if(arr[rightBound] > arr[candidate]) {
                    swap(candidate, leftOfGreaterPart);
                    leftOfGreaterPart++;
                    log("rightBound was greater than candidate, " +
                                    "swapped candidate with leftOfGreaterPart and increased leftOfGreaterPart.",
                            candidate, arr[candidate], leftBound, arr[leftBound], rightBound, arr[rightBound],
                            leftOfGreaterPart , arr[leftOfGreaterPart], Arrays.copyOf(this.arr, arr.length));
                }
                this.step++;
            }

            log("Finished loop, Swapping leftOfGreaterPart with rightBound in next step",
                    -1, -1, leftBound, arr[leftBound], rightBound, arr[rightBound],
                    leftOfGreaterPart , arr[leftOfGreaterPart], Arrays.copyOf(this.arr, arr.length));

            swap(leftOfGreaterPart, rightBound);

            this.step++;

            log("Swapped leftOfGreaterPart with rightBound",
                    -1, -1, leftBound, arr[leftBound], rightBound, arr[rightBound],
                    leftOfGreaterPart , arr[leftOfGreaterPart], Arrays.copyOf(this.arr, arr.length));

            groupByNumber(leftBound, leftOfGreaterPart - 1);
            groupByNumber(leftOfGreaterPart + 1, rightBound);
        }
        log("leftBound >= rightBound, finished sorting!",
                -1, -1, leftBound, arr[leftBound], rightBound, arr[rightBound],
                -1 , -1, Arrays.copyOf(this.arr, arr.length));
    }

    private void swap(int idx1, int idx2) {
        int copy = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = copy;
    }

    private void log(String comment, int candidateIndex, int candidateValue, int leftBoundIndex, int leftBoundValue,
                     int rightBoundIndex, int rightBoundValue, int leftOfGreaterPartIndex,
                     int leftOfGreaterPartValue, int[] tempArr) {
        System.out.println(String.format("\nStep %s --- (%s) \n" +
                    "candidate[%s] = %s, \nleftBoundIndex[%s] = %s, \nrightBoundIndex[%s] = %s (Pivot), " +
                    "\nleftOfGreaterPart[%s] = %s " +
                     "\nCurrent array: %s " +
                    "\n\n", this.step, comment,
                candidateIndex, candidateValue,
                leftBoundIndex, leftBoundValue,
                rightBoundIndex, rightBoundValue,
                leftOfGreaterPartIndex, leftOfGreaterPartValue,
                Arrays.toString(tempArr)));
    }
}


