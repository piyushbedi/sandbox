package crackingthecodinginterview;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList list;

    @Before
    public void setUp() {
        list = new LinkedList();
    }

    @Test
    public void printEmptyList() {
        assertThat(list.toString(), is("[]"));
    }

    @Test
    public void insert() {
        list.insert(5);
        list.insert(-1);
        list.insert(47);
        list.insert(1234);
        assertThat(list.toString(), is("[5, -1, 47, 1234]"));
    }

    @Test
    public void reverse() {
        list.insert(5);
        list.insert(-1);
        list.insert(47);
        list.insert(1234);
        assertThat(list.toString(), is("[5, -1, 47, 1234]"));

        list.reverse();
        assertThat(list.toString(), is("[1234, 47, -1, 5]"));
    }

    @Test
    public void reverseSingleList() {
        list.insert(5);
        assertThat(list.toString(), is("[5]"));

        list.reverse();
        assertThat(list.toString(), is("[5]"));
    }
}