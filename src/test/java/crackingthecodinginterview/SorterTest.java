package crackingthecodinginterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class SorterTest {

    @Test
    public void selectionSortNull() throws Exception {
        int[] data = null;
        Sorter.selectionSort(data);
        Assert.assertThat(data, is(nullValue()));
    }

    @Test
    public void selectionSortEmptyArray() throws Exception {
        int[] sortedData = {};
        int[] data = {};
        Sorter.selectionSort(data);
        Assert.assertThat(data, is(sortedData));
    }

    @Test
    public void selectionSortOneElement() throws Exception {
        int[] sortedData = {8};
        int[] data = {8};
        Sorter.selectionSort(data);
        Assert.assertThat(data, is(sortedData));
    }

    @Test
    public void selectionSort() throws Exception {
        int[] sortedData = {1, 2, 3};
        int[] data = {2, 3, 1};
        Sorter.selectionSort(data);
        Assert.assertThat(data, is(sortedData));
    }

    @Test
    public void selectionSortSorted() throws Exception {
        int[] sortedData = {1, 2, 3};
        int[] data = {1, 2, 3};
        Sorter.selectionSort(data);
        Assert.assertThat(data, is(sortedData));
    }
}