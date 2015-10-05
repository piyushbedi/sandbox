package crackingthecodinginterview;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SorterPerformanceTest {

    public static final int N_DATA = 10;

    @Ignore
    @Test
    public void selectionSortMassive() throws Exception {
        int[] bigData = generateMassiveArray();
        long duration = System.currentTimeMillis();
        Sorter.selectionSort(bigData);
        duration = System.currentTimeMillis() - duration;
        System.out.println("selectionSort duration(ms) = " + duration);
        assertTrue(isSorted(bigData));
    }

    @Ignore
    @Test
    public void mergeSortMassive() throws Exception {
        int[] bigData = generateMassiveArray();
        long duration = System.currentTimeMillis();
        Sorter.mergeSort(bigData);
        duration = System.currentTimeMillis() - duration;
        System.out.println("mergeSort duration(ms) = " + duration);
        assertTrue(isSorted(bigData));
    }

    @Test
    public void quickSortMassive() throws Exception {
        int[] bigData = generateMassiveArray();
        long duration = System.currentTimeMillis();
        Sorter.quickSort(bigData);
        duration = System.currentTimeMillis() - duration;
        System.out.println("mergeSort duration(ms) = " + duration);
        assertTrue(isSorted(bigData));
    }

    private static int[] generateMassiveArray() {
        int[] bigData = new int[N_DATA];
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < bigData.length; i++) {
            bigData[i] = rand.nextInt(N_DATA);
        }
        return bigData;
    }

    private boolean isSorted(int[] data) {
        if (data == null || data.length <= 1) {
            return true;
        }

        int head = data[0];

        for (int i = 1; i < data.length; i++) {
            if (head > data[i]) {
                return false;
            }
            head = data[i];
        }
        return true;
    }
}
