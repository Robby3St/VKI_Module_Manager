package de.tu_dortmund.vki.modules.dap1.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class QuickSort {

    private List<Integer> pivots = new ArrayList<>();
    public void quickSort(int[] arr, int left, int right) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println(
                "Current Array: " +
                        Arrays.toString(Arrays.copyOfRange(arr, left, right + 1))
        );
        System.out.println("left = " + left + " , right = " + right);
        if (left >= right) {
            System.out.println("No Pivot\n");
            return;
        }

        int pivot = arr[right];
        pivots.add(pivot);
        System.out.println("Pivot: " + pivot);
        int leftOfGreater = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, leftOfGreater);
                leftOfGreater++;
            }
        }
        swap(arr, right, leftOfGreater);
        System.out.println();
        quickSort(arr, left, leftOfGreater - 1);
        quickSort(arr, leftOfGreater + 1, right);

    }

    public void swap(int[] arr, int val1, int val2) {
        if (val1 == val2) {
            System.out.println("No swap: " + arr[val1] + " = " + arr[val2]);
            return;
        }
        System.out.println("Swapped " + arr[val1] + " with " + arr[val2]);
        int temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
    }

    public void showPivots() {
        System.out.println(pivots);
    }

    public static void main(String[] args) {
        int[] oldArr =  {13, 26, 8, 28, 34, 20, 10, 12, 6};
        int[] arr =  {7, 27, 19, 71, 35, 30, 18, 22, 25};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length - 1);
        qs.showPivots();

    }
}