package crackingthecodinginterview;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Piyush on 25/04/15.
 */
public class BalancedBinaryTreeTest {

    private BalancedBinaryTree tree;

    @Before
    public void setUp() {
        tree = new BalancedBinaryTree();
    }

    @Test
    public void printEmptyTreeInOrder() {
        assertThat(tree.printInOrder(), is(""));
    }

    @Test
    public void printTreeInOrder() {
        tree.insert(0);
        tree.insert(-2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(1);
        tree.insert(-1);
        tree.insert(-3);

        assertThat(tree.printInOrder(), is("-3, -2, -1, 0, 1, 4, 5"));
    }
}
