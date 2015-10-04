package crackingthecodinginterview;

public class Sorter {

    public static void selectionSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        int i = 0;
        while (i < data.length) {
            swap(i, indexOfMinimumFrom(i, data), data);
            i++;
        }
    }

    public static void mergeSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        int midPoint = data.length / 2;

        int[] sortedData = merge(mergeSortHelper(subArray(0, midPoint, data)), mergeSortHelper(subArray(midPoint, data.length, data)));

        for (int i = 0; i < data.length; i++) {
            data[i] = sortedData[i];
        }
    }

    private static int[] mergeSortHelper(int[] data) {
        if (data.length <= 1) {
            return data;
        }

        int midPoint = data.length / 2;

        return merge(mergeSortHelper(subArray(0, midPoint, data)), mergeSortHelper(subArray(midPoint, data.length, data)));
    }

    private static int[] merge(int[] data1, int[] data2) {
        int[] merged = new int[data1.length + data2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < data1.length && k < data2.length) {
            if (data1[j] < data2[k]) {
                merged[i] = data1[j];
                j++;
            } else {
                merged[i] = data2[k];
                k++;
            }
            i++;
        }
        while (j < data1.length) {
            merged[i] = data1[j];
            j++;
            i++;
        }
        while (k < data2.length) {
            merged[i] = data2[k];
            k++;
            i++;
        }
        return merged;
    }


    private static int indexOfMinimumFrom(int i, int[] data) {
        int minIndex = i;

        while (i < data.length) {
            if (data[i] < data[minIndex]) {
                minIndex = i;
            }
            i++;
        }
        return minIndex;
    }

    private static int[] subArray(int inclusiveFrom, int exclusiveTo, int[] data) {
        if (inclusiveFrom == exclusiveTo) {
            return new int[]{data[inclusiveFrom]};
        }

        int[] subData = new int[exclusiveTo - inclusiveFrom];
        int si = 0;
        int i = inclusiveFrom;
        while (i < exclusiveTo) {
            subData[si] = data[i];
            i++;
            si++;
        }
        return subData;
    }

    private static void swap(int x, int y, int[] data) {
        if (x == y) {
            return;
        }

        data[x] = data[x] + data[y];
        data[y] = data[x] - data[y];
        data[x] = data[x] - data[y];
    }
}
