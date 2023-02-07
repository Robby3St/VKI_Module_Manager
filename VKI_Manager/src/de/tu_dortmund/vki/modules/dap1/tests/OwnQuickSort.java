package de.tu_dortmund.vki.modules.dap1.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class OwnQuickSort {
    int[] arr;
    int step;
    ArrayList<Integer> list = new ArrayList<Integer>();

    public  OwnQuickSort(int[] arr) {
        this.arr = arr;
        this.step = 0;
        this.groupByNumber(0, arr.length - 1);
        System.out.println(String.format("Pivots: %s", list.toString()));
    }

    private void groupByNumber(int leftBound, int rightBound) {
        if(leftBound < rightBound) {
            int leftOfGreaterPart = leftBound;

            for(int candidate = leftBound; candidate < rightBound; candidate++) {
                log("Checking if rightBound > candidate",
                        candidate, arr[candidate], leftBound, arr[leftBound], rightBound, arr[rightBound],
                        leftOfGreaterPart , arr[leftOfGreaterPart], arr);
                if(arr[rightBound] > arr[candidate]) {
                    swap(candidate, leftOfGreaterPart);
                    log("rightBound was greater than candidate, " +
                                    "swapped candidate with leftOfGreaterPart and increased leftOfGreaterPart.",
                            candidate, arr[candidate], leftBound, arr[leftBound], rightBound, arr[rightBound],
                            leftOfGreaterPart , arr[leftOfGreaterPart], arr);
                    leftOfGreaterPart++;
                }
                this.step++;
                if(!list.contains(arr[rightBound]))
                    list.add(arr[rightBound]);
            }

            log("Finished loop, Swapping leftOfGreaterPart with rightBound in next step",
                    -1, -1, leftBound, arr[leftBound], rightBound, arr[rightBound],
                    leftOfGreaterPart , arr[leftOfGreaterPart], arr);

            swap(leftOfGreaterPart, rightBound);

            this.step++;

            log("Swapped leftOfGreaterPart with rightBound",
                    -1, -1, leftBound, arr[leftBound], rightBound, arr[rightBound],
                    leftOfGreaterPart , arr[leftOfGreaterPart], arr);


            groupByNumber(leftBound, leftOfGreaterPart - 1);
            groupByNumber(leftOfGreaterPart + 1, rightBound);
        }
        log("leftBound >= rightBound, finished sorting!",
                -1, -1, leftBound,
                (leftBound < 0 || leftBound > arr.length) ? -1 : arr[leftBound],
                rightBound,
                (rightBound < 0 || rightBound > arr.length) ? -1 : arr[rightBound],
                -1 , -1, arr);
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
                    "candidate[%s] = %s, \nleftBound[%s] = %s, \nrightBound[%s] = %s (Pivot), " +
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


