package crackingthecodinginterview;

public class Sorter {

    public static void selectionSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        int i = 0;
        while(i < data.length) {
            swap(i, indexOfMinimumFrom(i, data), data);
            i++;
        }
    }

    private static int indexOfMinimumFrom(int i, int[] data) {
        int minIndex = i;

        while(i < data.length) {
            if (data[i] < data[minIndex]){
                minIndex = i;
            }
            i++;
        }
        return minIndex;
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
