package crackingthecodinginterview;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class SorterTest {

    @Parameters(name = "{index}: sort({0})")
    public static Iterable<Object[]> data1() {
        return Arrays.asList( new Object[][]{
                {"null array", null, null},
                {"empty array",new int[] {}, new int[] {}},
                {"singleton array", new int[] {8}, new int[] {8}},
                {"mixed array", new int[] {2, 3, 1}, new int[] {1, 2, 3}},
                {"sorted array", new int[] {1, 2, 3}, new int[] {1, 2, 3}}
        });
    }

    private String testDataDescription;
    private int[] input;
    private int[] expected;

    public SorterTest(String testDataDescription, int[] input, int[] expected) {
        this.testDataDescription = testDataDescription;
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void selectionSort() throws Exception {
        Sorter.selectionSort(input);
        Assert.assertThat(input, is(expected));
    }

    @Test
    public void mergeSort() throws Exception {
        Sorter.mergeSort(input);
        Assert.assertThat(input, is(expected));
    }
}